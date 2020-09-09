scenario {
	component "LC 1"
	component "LC 2"
	actor "LA 2"
	"LC 1" -> "LC 2" withExecution : "new component exchange"
	"LC 2" -> "LA 2" : "new component exchange 2"
	deactivate "LC 2"
}