package observer

import kotlin.properties.Delegates

interface ValueChangedObserver {
    fun onValueChanged(newValue: String)
}

class TextChangedObserver : ValueChangedObserver {
    override fun onValueChanged(newValue: String) =
            println("Text is changed to $newValue")
}

// There are different types of Delegates in Kotlin.
// We’re using the Observable type, which takes two arguments:
// the initial value and a handler for modifications.
// The handler gets called every time we assign to the property.

class TextObservable(listener: ValueChangedObserver) {
    var text: String by Delegates.observable(
            initialValue = "",
            onChange = { _, _, new ->
                listener.onValueChanged(new)
            })
}

fun main(args: Array<String>) {
    val observableObject = TextObservable(TextChangedObserver())
    observableObject.text = "Hello"
    observableObject.text = "Goodbye!"
}
