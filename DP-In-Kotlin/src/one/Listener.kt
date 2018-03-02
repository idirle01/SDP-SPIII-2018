package one

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

interface TextChangedListener {
    fun onTextChanged(prop: KProperty<*>, oldText: String, newText: String)
}

class PrintingTextChangedListener : TextChangedListener {
    override fun onTextChanged(prop: KProperty<*>, oldText: String, newText: String) =
            println("For property \"${prop.name}\" the value is changed from $oldText to $newText")
}

class TextView {
    lateinit var listener: TextChangedListener

    var text: String by Delegates.observable("Start") { prop, old, new ->
        listener.onTextChanged(prop,old,new)
    }
}

fun main(args: Array<String>) {
    val textView = TextView()
    textView.listener = PrintingTextChangedListener()
    textView.text = "Before"
    println(textView.text)
    textView.text = "After"
}

