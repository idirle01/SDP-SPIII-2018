package observer

// This interface handles adding, deleting and updating
// all observers

interface Subject {

    fun register(o: Observer): ArrayList<Observer>

    fun unregister(o: Observer): ArrayList<Observer>

    fun notifyObserver()

}