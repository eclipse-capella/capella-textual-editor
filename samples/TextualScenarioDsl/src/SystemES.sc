scenario {
	component "System"
	actor "SA 23"
	actor "SA 24"
	actor "SA 25"
	"SA 23" -> "SA 24" withExecution : "new functional exchange"
	"SA 24" -> "SA 25" : "new functional exchange 2"
	deactivate "SA 24"
} 