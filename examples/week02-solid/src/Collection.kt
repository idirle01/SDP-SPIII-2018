interface Collection<E> : Iterable<E> {

    val isEmpty: Boolean
    //-- Basic operations
    fun size(): Int

    operator fun contains(o: Any): Boolean

    fun add(o: E): Boolean                     // Optional

    fun remove(o: Any): Boolean             // Optional

    override fun iterator(): Iterator<E>

    //-- Collection operations
    fun containsAll(c: Collection<*>): Boolean

    fun addAll(c: Collection<out E>): Boolean  // Optional

    fun removeAll(c: Collection<*>): Boolean   // Optional

    fun retainAll(c: Collection<*>): Boolean   // Optional

    fun clear()                         // Optional

    //-- Array operations
    fun toArray(): Array<Any>

    fun <T> toArray(a: Array<T>): Array<T>
}