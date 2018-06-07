package observer

// Uses the Subject interface to update all Observers

class StockGrabber : Subject {
    private lateinit var observers: ArrayList<Observer>

    var price: Double = 0.0
        set(value) {
            price = value
            notifyObserver()
        }

    init {
        // Creates an ArrayList to hold all observers
        observers = ArrayList<Observer>()
    }

    override fun register(newObserver: Observer): ArrayList<Observer> {
        // Adds a new observer to the ArrayList
        observers.add(newObserver)
        return observers
    }

    override fun unregister(deleteObserver: Observer): ArrayList<Observer> {
        // Get the index of the observer to delete
        val observerIndex = observers.indexOf(deleteObserver)

        // Print out message (Have to increment index to match)
        println("Observer ${(observerIndex + 1)} deleted")

        // Removes observer from the ArrayList
        observers.removeAt(observerIndex)

        return observers
    }

    override fun notifyObserver() {
        // Cycle through all observers and notifies them of price changes
        for (observer in observers) {
            observer.update()
        }
    }
}