package adapter

import java.util.*

/**
 * Adapts Enumeration interface to Iterator interface.
 * Does not support remove() operation.
 */
class EnumerationAsIterator<T>(private val enumeration: Enumeration<T>) : Iterator<T> {

    override fun hasNext(): Boolean {
        return this.enumeration.hasMoreElements()
    }

    override fun next(): T {
        return this.enumeration.nextElement()
    }
}