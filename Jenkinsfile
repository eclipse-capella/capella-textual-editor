pipeline {
	agent {
		label 'migration'
	}
  
	tools {
		maven 'apache-maven-latest'
		jdk 'oracle-jdk8-latest'
	}
  
	environment {
		BUILD_KEY = (github.isPullRequest() ? CHANGE_TARGET : BRANCH_NAME).replaceFirst(/^v/, '')
		CAPELLA_PRODUCT_PATH = "${WORKSPACE}/capella/capella"
  	}
  
  	stages {
  	
		stage('Generate Target Platform') {
	    	steps {        
	        	script { 
		        	if(github.isPullRequest()){
		        	    github.buildStartedComment()
		        	}
		
		        	currentBuild.description = BUILD_KEY
		        	
		        	sh 'env'
		        	sh 'mvn clean verify -f releng/org.polarsys.capella.scenario.editor.update/pom.xml'
	       		}         
	     	}
	    }
	    
    	stage('Build and Package') {
      		steps {
      			script {
					withCredentials([string(credentialsId: 'sonar-token-capella', variable: 'SONARCLOUD_TOKEN')]) {
						withEnv(['MAVEN_OPTS=-Xmx4g']) {
							def sign = github.isPullRequest() ? '' : '-Psign'
							def sonarCommon = 'sonar:sonar -Dsonar.projectKey=eclipse_capella -Dsonar.organization=eclipse -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=${SONARCLOUD_TOKEN} '
							def sonarBranchAnalysis = '-Dsonar.branch.name=${BRANCH_NAME}'
							def sonarPullRequestAnalysis = '-Dsonar.pullrequest.provider=GitHub -Dsonar.pullrequest.github.repository=eclipse/capella -Dsonar.pullrequest.key=${CHANGE_ID} -Dsonar.pullrequest.branch=${CHANGE_BRANCH}'
							def sonar = sonarCommon + (github.isPullRequest() ? sonarPullRequestAnalysis : sonarBranchAnalysis)
	      					sh "mvn clean verify -f pom.xml -Djacoco.skip=true -DjavaDocPhase=none -Pfull ${sign} ${sonar}"
						}
					}
      			}
	     	}
	    }
    
		stage('Deploy to Nightly') {
      		steps {
				script {
		    		def deploymentDirName = 
		    			(github.isPullRequest() ? "${BUILD_KEY}-${BRANCH_NAME}-${BUILD_ID}" : "${BRANCH_NAME}-${BUILD_ID}")
		    			.replaceAll('/','-')		
					
					deployer.addonNightlyDropins("${WORKSPACE}/releng/org.polarsys.capella.scenario.editor.site/target/*-dropins-*.zip", deploymentDirName)
					deployer.addonNightlyUpdateSite("${WORKSPACE}/releng/org.polarsys.capella.scenario.editor.site/target/*-updateSite-*.zip", deploymentDirName)					
					currentBuild.description = "${deploymentDirName} - <a href=\"https://download.eclipse.org/capella/addons/textualeditor/dropins/nightly/${deploymentDirName}\">drop-in</a> - <a href=\"https://download.eclipse.org/capella/addons/textualeditor/updates/nightly/${deploymentDirName}\">update-site</a>"
	       		
	       		}         
	     	}
	    }
	    
	    stage('Download Capella') {
    		when {
        		expression { 
        			github.isPullRequest() 
        		}
      		}
      		
        	steps {
        		script {
	        		def capellaURL = capella.getDownloadURL("${BUILD_KEY}", 'linux', '')
	        		
	        		sh "curl -k -o capella.zip ${capellaURL}"
					sh "unzip -q capella.zip"

	       		}         
	     	}
	    }

    	stage('Install test features') {
    		when {
        		expression { 
        			github.isPullRequest() 
        		}
      		}
      		
        	steps {
        		script {
	        		sh "chmod 755 ${CAPELLA_PRODUCT_PATH}"
	        		
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", 'http://download.eclipse.org/tools/orbit/downloads/drops/R20130827064939/repository', 'org.jsoup')	        		
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", capella.getTestUpdateSiteURL("${BUILD_KEY}"), 'org.polarsys.capella.test.feature.feature.group')
	        		
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", "file:/${WORKSPACE}/releng/org.polarsys.capella.scenario.editor.site/target/repository/".replace("\\", "/"), 'org.polarsys.capella.scenario.editor.feature.feature.group')
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", "file:/${WORKSPACE}/releng/org.polarsys.capella.scenario.editor.site/target/repository/".replace("\\", "/"), 'org.polarsys.capella.scenario.editor.tests.feature.feature.group')
	       		}         
	     	}
	    }
	    
    	stage('Run tests') {
    		when {
        		expression { 
        			github.isPullRequest() 
        		}
      		}
    	
        	steps {
        		script {
        			wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
		        		
		        		tester.runUITests("${CAPELLA_PRODUCT_PATH}", 'ScenarioEditorTestSuite', 'org.polarsys.capella.scenario.editor.ju', 
		        			['org.polarsys.capella.scenario.editor.ju.ScenarioEditorTestSuite'])		        			 
	        		}
	        		
	        		junit '*.xml'
				}
			}
		}
	}
  
	post {
    	always {
       		archiveArtifacts artifacts: '**/*.log, *.log, *.xml, **/*.layout'
    	}
    	
    	success  {
    		script {
    			if(github.isPullRequest()){
        			github.buildSuccessfullComment()
        		}
        	}
    	}
    	
	    unstable {
	    	script {
	    		if(github.isPullRequest()){
	        		github.buildUnstableComment()
	        	}
	        }
	    }
    
	    failure {
	    	script {
	    		if(github.isPullRequest()){
	        		github.buildFailedComment()
	        	}
	        }
	    }
	    
	    aborted {
	    	script {
	    		if(github.isPullRequest()){
	        		github.buildAbortedComment()
	        	}
	        }
	    }
	}
}