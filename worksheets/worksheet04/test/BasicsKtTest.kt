import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import solution.*
import java.math.BigInteger
import java.util.*

class BasicsKtTest {
    lateinit var n: Random

    @Before
    fun start() {
        n = Random()
    }

    /**
     * The add function should return the addition of a and b
     */
    @Test
    fun addTest() {
        for (x in 1..1000) {
            val a = n.nextInt(1000)
            val b = n.nextInt(1000)
            val r = add(a, b)
            assertTrue("Your add function produced the result $r from adding $a to $b", a + b == r)
        }
    }

    /**
     * The orig.inRange function should return an inclusive range
     */
    @Test
    fun inRangeTest() {
        for (i in 1..1000) {
            for (j in 1..1000) {
                if (j > i) {
                    val r = inRange(i, j)
                    val head = r.take(1).get(0)
                    val last = r.last
                    assertEquals("The first element in your range ($head) does not match the expected value $i", i, head)
                    assertEquals("The last element in your range ($last) does not match the expected value $j", j, last)
                }
            }
        }
    }

    /**
     * The orig.oddRange function should return a range of all odd integers from 1 to n"
     */
    @Test
    fun oddRangeTest() {
        for (n in 1..1000) {
            val r = oddRange(n)
            assertEquals("The first element in your range is not 1", r.start, 1)
            for (v in r) {
                assertEquals("You have a non-odd value $v in your range", v % 2, 1)
            }
        }
    }

    /**
     * The orig.minWhile function should return the minimum integer in an array using a while loop
     */
    @Test
    fun minWhileTest() {
        assertEquals(1, minWhile(arrayOf(55, 6, 24, 32, 1, 16, 12)))
        assertEquals(2, minWhile(arrayOf(2, 3, 4, 5)))
        assertEquals(12, minWhile(arrayOf(99, 98, 45, 100, 107, 12, 1012, 15, 45, 45, 909)))
    }

    /**
     * The orig.minFor function should return the minimum integer in an array using a for loop
     */
    @Test
    fun minForTest() {
        assertEquals(1, minFor(arrayOf(55, 6, 24, 32, 1, 16, 12)))
        assertEquals(2, minFor(arrayOf(2, 3, 4, 5)))
        assertEquals(12, minFor(arrayOf(99, 98, 45, 100, 107, 12, 1012, 15, 45, 45, 909)))
    }

    /**
     * The orig.minRecursive function should return the minimum integer in an array using recursion
     */
    @Test
    fun minRecursiveTest() {
        assertEquals(1, minRecursive(arrayOf(55, 6, 24, 32, 1, 16, 12)))
        assertEquals(2, minRecursive(arrayOf(2, 3, 4, 5)))
        assertEquals(12, minRecursive(arrayOf(99, 98, 45, 100, 107, 12, 1012, 15, 45, 45, 909)))
    }

    /**
     * The orig.base36 function should return the base 36 equivalent of the given BigInt
     */
    @Test
    fun base36Test() {
        assertEquals("21i3v9", base36(BigInteger("123456789")))
        assertEquals("4jc8lik", base36(BigInteger("9876543212")))
        assertEquals("xrls1yk9rf9", base36(BigInteger("123456789123456789")))
    }

    /**
     * The orig.splitInHalf function should split a string in half
     */
    @Test
    fun splitInHalfTest() {
        fun check(s: String, ls: String, rs: String) = {
            val (l, r) = splitInHalf(s)
            assertEquals("$l is not the same as $ls", ls, l)
            assertEquals("$r is not the same as $rs", rs, r)
        }
        check("racecar", "rac", "ecar")
        check("sloppy", "slo", "ppy")
    }

    /**
     * orig.isPalindrome should return true if a string is a palindrome
     */
    @Test
    fun isPalindromeTest() {
        val pp = arrayOf(
                "racecar",
                "A car, a man, a maraca",
                "A Toyota's a Toyota",
                "In words, alas, drown I"
        )

        for (p in pp) {
            assertTrue("$p is a palindrome", isPalindrome(p))
        }
    }

    /**
     * For you to complete...
     */
    @Ignore
    @Test
    fun wordCounter() {
        TODO()
    }
}