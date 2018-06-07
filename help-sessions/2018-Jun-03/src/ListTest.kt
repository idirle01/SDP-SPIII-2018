import org.junit.Assert.*
import kotlin.test.*

import org.junit.Test

class ListTest {

    @Test
    fun creatingAListRaw() {
        val l1: List<Int> = Cons(1, Cons(2, Cons(3, Cons(4, Nil))))

        assertEquals(1, l1.head)
        assertEquals(Cons(2, Cons(3, Cons(4, Nil))), l1.tail)

        val l2: List<String> = Nil
        assertEquals(Nil, l2)
    }

    @Test
    fun createAListVarargs() {
        val l = List(1, 2, 3, 4)
        assertEquals(1, l.head)
        assertEquals(Cons(2, Cons(3, Cons(4, Nil))), l.tail)
    }

    @Test
    fun headOfAnEmptyList() {
        assertFailsWith(NoSuchElementException::class) {
            Nil.head
        }
    }

    @Test
    fun dropElements() {
        val l = List(4, 3, 2, 1)
        assertEquals(List(2, 1), l.drop(2))
    }

    @Test
    fun dropWhile() {
        val l = List(1, 2, 3, 5, 8, 13, 21, 34, 55, 89)
        assertEquals(List(21, 34, 55, 89), l.dropWhile({ e -> e < 20 }))
    }

    @Test
    fun foldLeft() {
        val l = Cons(1, Cons(2, Cons(3, Cons(4, Nil))))
        assertEquals(10, l.foldLeft(0, { r, e -> r + e }))
        assertEquals(24, l.foldLeft(1, { r, e -> r * e }))
    }

    @Test
    fun foldRightSum() {
        val l = Cons(1, Cons(2, Cons(3, Cons(4, Nil))))
        assertEquals(10, l.foldRight(0, { e, r -> e + r }))
        assertEquals(24, l.foldRight(1, { e, r -> e * r }))
        assertEquals(10, l.foldRightViaFoldLeft(0, { e, r -> e + r }))
        assertEquals(24, l.foldRightViaFoldLeft(1, { e, r -> e * r }))
    }

    @Test
    fun reverseAList() {
        val l = List("a", "b", "c")
        assertEquals(List("c", "b", "a"), l.reverse())
    }

    @Test
    fun appendTwoLists() {
        val l1: List<Number> = List(1, 2, 3)
        val l2 = List(4.1, 5.1, 6.1)

        assertEquals(List(1, 2, 3, 4.1, 5.1, 6.1), l1.append(l2))
    }

    @Test
    fun sizeOfANilList() {
        val l = Nil
        assertEquals(0, l.size())
    }

    @Test
    fun sizeOfANonNilList() {
        val l = Cons(1, Cons(2, Cons(3, Cons(4, Nil))))
        assertEquals(4, l.size())
    }

    @Test
    fun mapElements() {
        val l = Cons(1, Cons(2, Cons(3, Nil)))
        val l2 = l.map { e -> e.toString() }
        assertEquals(Cons("1", Cons("2", Cons("3", Nil))), l2)
    }

    @Test
    fun testFlatten() {
        val l = List(List(1, 2), List(3, 4))
        assertEquals(List(1, 2, 3, 4), List.flatten(l))
    }

    @Test
    fun flatMapElements() {
        val l = Cons(1, Cons(2, Cons(3, Nil)))
        val l2 = l.flatMap { e -> List(e.toString(), e.toString()) }

        assertEquals(Cons("1", Cons("1", Cons("2",
                Cons("2", Cons("3", Cons("3", Nil)))))), l2)
    }
}