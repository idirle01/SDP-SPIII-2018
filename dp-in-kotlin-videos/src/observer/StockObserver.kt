package observer

// Represents each Observer that is monitoring changes in the subject

class StockObserver(
        // Will hold reference to the StockGrabber object
        private val stockGrabber: Subject) : Observer {

    // Used to track the observers
    private val observerID: Int

    init {
        // Assign an observer ID and increment the static counter
        this.observerID = ++observerIDTracker

        // Message notifies user of new observer
        println("New Observer " + this.observerID)

        // Add the observer to the Subjects List
        stockGrabber.register(this)


    }
// Called to update all observers

    override fun update() {
        println(observerID)
        println("Updated: $stockGrabber")
    }

    companion object {
        private var observerIDTracker = 0
    }
}