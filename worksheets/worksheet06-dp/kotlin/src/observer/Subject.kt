package observer

interface Subject {
    fun subscribeObserver(observer: Observer): Unit
    fun unSubscribeObserver(observer: Observer): Unit
    fun notifyObservers(): Unit
    fun subjectDetails(): String
}
