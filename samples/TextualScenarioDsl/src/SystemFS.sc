scenario {
	function "SystemFunction 4"
	function "SystemFunction 5"
	function "SystemFunction 6"
	"SystemFunction 4" -> "SystemFunction 5" withExecution : "functional exchange"
	"SystemFunction 5" -> "SystemFunction 6" : "functional exchange 2"
	deactivate "SystemFunction 5"
}