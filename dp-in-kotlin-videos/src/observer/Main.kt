package observer

fun main(args: Array<String>) {

    // Create the Subject object
    // It will handle updating all observers
    // as well as deleting and adding them

    val stockGrabber = StockGrabber()

    // Create an Observer that will be sent updates from Subject

    val observer1 = StockObserver(stockGrabber)

    stockGrabber.ibmPrice = 197.00
    stockGrabber.aaplPrice = 677.60
    stockGrabber.googPrice = 676.40

    val observer2 = StockObserver(stockGrabber)

    stockGrabber.ibmPrice = 197.00
    stockGrabber.aaplPrice = 677.60
    stockGrabber.googPrice = 676.40

    // Delete one of the observers

    stockGrabber.unregister(observer2);

    stockGrabber.ibmPrice = 197.00
    stockGrabber.aaplPrice = 677.60
    stockGrabber.googPrice = 676.40

    // Create 3 threads using the Runnable interface
    // GetTheStock implements Runnable, so it doesn't waste its one extendable class option

    val getIBM = GetTheStock(stockGrabber, 2, "IBM", 197.00)
    val getAAPL = GetTheStock(stockGrabber, 2, "AAPL", 677.60)
    val getGOOG = GetTheStock(stockGrabber, 2, "GOOG", 676.40)

    // Call for the code in run to execute

    Thread(getIBM).start()
    Thread(getAAPL).start()
    Thread(getGOOG).start()
}
