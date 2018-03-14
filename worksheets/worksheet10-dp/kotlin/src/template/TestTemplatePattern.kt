package template

fun main(args: Array<String>) {
    println("For MYSQL....")
    var template: ConnectionTemplate = MySqLCSVCon()
    template.run()
    println("\nFor Oracle...")
    template = OracleTxtCon()
    template.run()
}
