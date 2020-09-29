scenario {
      activity "OperationalActivity 1"
	activity "OperationalActivity 2"
	activity "OperationalActivity 3"
	"OperationalActivity 1" -> "OperationalActivity 2" withExecution : "interaction"
	"OperationalActivity 2" -> "OperationalActivity 3" : "interaction 2"
	deactivate "OperationalActivity 2"
}