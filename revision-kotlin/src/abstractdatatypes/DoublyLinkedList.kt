package abstractdatatypes

class LinkedList<E> {
    class Node<E>(var data: E, var prev: Node<E>? = null, var next: Node<E>? = null) {
        override fun toString(): String {
            val sb = StringBuilder(this.data.toString())
            var node = this.next
            while (node != null) {
                sb.append(" -> ", node.data.toString())
                node = node.next
            }
            return sb.toString()
        }
    }

    var first: Node<E>? = null
    var last: Node<E>? = null

    fun addFirst(value: E) {
        if (first == null) {
            first = Node(value)
            last = first
        } else {
            val node = first!!
            first = Node(value, null, node)
            node.prev = first
        }
    }

    fun addLast(value: E) {
        if (last == null) {
            last = Node(value)
            first = last
        } else {
            val node = last!!
            last = Node(value, node, null)
            node.next = last
        }
    }

    fun insert(after: Node<E>?, value: E) {
        if (after == null)
            addFirst(value)
        else if (after == last)
            addLast(value)
        else {
            val next = after.next
            val new = Node(value, after, next)
            after.next = new
            if (next != null) next.prev = new
        }
    }

    override fun toString() = first.toString()
}

fun main(args: Array<String>) {
    val n1 = Node(1)
    val n2 = Node(2, n1)
    n1.next = n2
    val n3 = Node(3, n2)
    n2.next = n3
    println(n1)
    println(n2)
    println(n3)

    val ll = LinkedList<Int>()
    ll.addFirst(1)
    ll.addLast(4)
    ll.insert(ll.first, 2)
    ll.insert(ll.last!!.prev, 3)
    println(ll)
}