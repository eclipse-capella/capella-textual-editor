scenario Physical IS "ScenarioName"
	actor "Actor 1" as act1
	actor "Actor 2" as act2
	component "Component 1" as comp1
	act1 -> act2 : "Message"
	act1 -> node1 : "Message2"
end scenario