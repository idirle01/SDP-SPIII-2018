package observer

import java.text.DecimalFormat

data class Stock(
        private val stockGrabber: Subject,
        private val stock: String,
        private var price: Double) {

    override fun run() {
        for (i in 1..20) {

            try {
                // Sleep for 2 seconds
                Thread.sleep(2000)

                // Use Thread.sleep(startTime * 1000); to
                // make sleep time variable
            } catch (e: InterruptedException) {
            }

            // Generates a random number between -.03 and .03
            val randNum = Math.random() * .06 - .03

            // Formats decimals to 2 places
            val df = DecimalFormat("#.##")

            // Change the price
            stockGrabber.price += randNum

            println("${stock}: $price ")
            println()
        }
    }
}