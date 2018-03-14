package observer

data class CommentaryObject(var subscribers: List<Observer>, val title: String) : Subject {
    override fun subscribeObserver(observer: Observer): Unit = TODO()
    override fun unSubscribeObserver(observer: Observer): Unit = TODO()
    override fun notifyObservers(): Unit = TODO()
    override fun subjectDetails(): String = TODO()
}
