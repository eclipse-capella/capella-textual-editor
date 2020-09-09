scenario {
	component "PC 2"
	component "PC 1"
	component "PC 3"
	actor "PA 3"
	"PC 3" -> "PA 3" withExecution : "component exchange"
	"PA 3" -> "PC 3" : "component exchange 2"
	deactivate "PA 3"
}