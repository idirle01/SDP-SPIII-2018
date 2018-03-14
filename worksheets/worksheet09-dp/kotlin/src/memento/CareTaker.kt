package memento

class CareTaker() {

    private val savepointStorage = mutableMapOf<String, Memento>()

    fun saveMemento(memento: Memento, savepointName: String) {
        TODO()
    }

    fun getMemento(savepointName: String): Memento {
        TODO()
    }

    fun clearSavepoints() {
        TODO()
    }
}
