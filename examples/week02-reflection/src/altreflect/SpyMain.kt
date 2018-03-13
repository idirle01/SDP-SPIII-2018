package altreflect

fun main(args: Array<String>) {
    try {
        val thisClassPrinter = Spy.getSpy("altreflect.Spy")
        thisClassPrinter.printAll(args)
    } catch (ex: ClassNotFoundException) {
        println("It broke!")
    }

}
