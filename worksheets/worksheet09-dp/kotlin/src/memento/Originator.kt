package memento

data class Originator(
        var x: Double,
        var y: Double,
        var careTaker: CareTaker
) {

    private var lastUndoSavepoint: String = TODO()

    init {
        createSavepoint("INITIAL")
    }

    fun createSavepoint(savepointName: String) {
        TODO()
    }

    fun undo() {
        TODO()
    }

    fun undo(savepointName: String) {
        TODO()
    }

    fun undoAll() {
        TODO()
    }

    private fun setOriginatorState(savepointName: String) {
        TODO()
    }
}
