package observer

import java.util.*

fun main(args: Array<String>) {
    val obj: Observable = CommentaryObjectObservable("Soccer Match [2018AUG24]")
    val observer = SMSUsersObserver(obj, "Adam Warner [New York]")
    val observer2 = SMSUsersObserver(obj, "Tim Ronney [London]")
    observer.subscribe()
    observer2.subscribe()
    println("-".repeat(40))
    // other operations
    observer.unsubscribe()
    // other operation
}
