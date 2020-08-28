scenario OAS "ScenarioName"
	activity "Activity 1" as act1
	activity "Activity 2" as act2
	act1 -> act2 : "Message"
end scenario