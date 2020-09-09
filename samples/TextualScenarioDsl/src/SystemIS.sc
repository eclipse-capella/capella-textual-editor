scenario {
	component "System"
	actor "SA 19"
	actor "SA 20"
	actor "SA 21"
	actor "SA 22"
	"SA 19" -> "SA 20" withExecution : "message 1"
	"SA 20" -> "SA 21" withExecution : "message 2"
	"SA 21" -> "SA 22" : "message 3"
	deactivate "SA 21"
	deactivate "SA 20"
} 