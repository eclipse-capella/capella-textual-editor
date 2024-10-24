pipeline {
	agent {
		label 'migration'
	}
  
	tools {
		maven 'apache-maven-latest'
		jdk 'openjdk-jdk17-latest'
	}
  
	environment {
		BUILD_KEY = (github.isPullRequest() ? CHANGE_TARGET : BRANCH_NAME).replaceFirst(/^v/, '')
		CAPELLA_PRODUCT_PATH = "${WORKSPACE}/capella/capella"
		CAPELLA_CONFIGURATION_PATH = "${WORKSPACE}/capella/configuration"
		VM_ARGS = "-Dlogback.configurationFile=${CAPELLA_CONFIGURATION_PATH}/logback.xml"
		CAPELLA_BRANCH = 'master'
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
                      def customParams = github.isPullRequest() ? '' : '-Psign'
             
                      sh "mvn -Djacoco.skip=true -DjavaDocPhase=none ${customParams} clean package -f pom.xml"
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
					deployer.addonNightlyUpdateSite("${WORKSPACE}/releng/org.polarsys.capella.scenario.editor.site/target/bom.json", deploymentDirName)
					currentBuild.description = "${deploymentDirName} - <a href=\"https://download.eclipse.org/capella/addons/textualeditor/dropins/nightly/${deploymentDirName}\">drop-in</a> - <a href=\"https://download.eclipse.org/capella/addons/textualeditor/updates/nightly/${deploymentDirName}\">update-site</a>"
	       		
	       		}         
	     	}
	    }
	    
	    stage('Download Capella') {
        	steps {
        		script {
	        		def capellaURL = capella.getDownloadURL("${CAPELLA_BRANCH}", 'linux', '')
	        		
	        		sh "curl -k -o capella.tar.gz ${capellaURL}"
					sh "tar xvzf capella.tar.gz"

	       		}         
	     	}
	    }

    	stage('Install test features') {
        	steps {
        		script {
	        		sh "chmod 755 ${CAPELLA_PRODUCT_PATH}"
	        		sh "chmod 755 ${WORKSPACE}/capella/jre/bin/java"
	        			        		
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", capella.getTestUpdateSiteURL("${CAPELLA_BRANCH}"), 'org.polarsys.capella.test.feature.feature.group', "${VM_ARGS}")
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", "file:/${WORKSPACE}/releng/org.polarsys.capella.scenario.editor.site/target/repository/".replace("\\", "/"), 'org.polarsys.capella.scenario.editor.feature.feature.group', "${VM_ARGS}")
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", "https://download.eclipse.org/releases/2023-03/", 'org.eclipse.xtext.sdk.feature.group', "${VM_ARGS}")
	        		eclipse.installFeature("${CAPELLA_PRODUCT_PATH}", "file:/${WORKSPACE}/releng/org.polarsys.capella.scenario.editor.site/target/repository/".replace("\\", "/"), 'org.polarsys.capella.scenario.editor.tests.feature.feature.group', "${VM_ARGS}")
	       		}         
	     	}
	    }
	    
    	stage('Run tests') {
        	steps {
        		script {
        			wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
		        		
		        		tester.runUITests("${CAPELLA_PRODUCT_PATH}", 'ScenarioEditorTestSuite', 'org.polarsys.capella.scenario.editor.ju', 
		        			['org.polarsys.capella.scenario.editor.ju.ScenarioEditorTestSuite'])		        			 
	        		}
	        		
	        		tester.publishTests()
				}
			}
		}

		stage('Sonar') {
			tools {
				jdk 'openjdk-jdk17-latest'
			}
			steps {
				script {
					sonar.runSonar("eclipse-capella_capella-textual-editor", "eclipse-capella/capella-textual-editor", 'sonarcloud-token-textual-editor')
				}
			}
		}

	}
  
	post {
    	always {
       		archiveArtifacts artifacts: '**/*.log, *.log, *.xml, **/*.layout, *.exec'
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