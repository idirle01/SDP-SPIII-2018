package solution

/**
 * tail that takes a list and removes the first element, returning the rest
 * of the list.
 * Calling tail on an empty list throws an IllegalArgumentException.
 *
 * @param ls : List[T] the list to process
 * @return A list containing all but the first element of ls
 */
fun <T> tail(l: List<T>): List<T> = when (l) {
    emptyList<T>() -> throw IllegalArgumentException()
    else -> l.drop(1)
}

/**
 * setHead replaces the first value in a list with a given value. If the
 * list is empty, it adds the value to the front of the list.
 *
 * @param ls : List[T] the list to be changed
 * @param a  : A the value that will replace the head of ls
 * @return a list whose head is `a' and whose tail is all but the first element of ls.
 **/
fun <T> setHead(l: List<T>, item: T): List<T> = when (l) {
    emptyList<T>() -> listOf(item)
    else -> listOf(item) + tail(l)
}

/**
 * drop removes n elements from the given list. If n is greater than the
 * length of the list, the function returns an empty list.
 *
 * @param ls : List[T] the list to be changed
 * @param n  : Int the number of elements to drop.
 * @return a list with the first n elements of ls removed, or an empty list.
 */
fun <T> drop(l: List<T>, n: Int): List<T> = when (l) {
    emptyList<T>() -> l
    else ->
        when (n) {
            1 -> l.drop(1)
            else -> drop(tail(l), n - 1)
        }
}

/**
 * init takes a list and removes the last element.
 * Like tail, init of the empty list throws an IllegalArgumentException.
 * Implement this function recursively, preferably using pattern matching.
 *
 * @param ls : List[T] the list to be changed.
 * @return a list with the last element of ls removed.
 */
fun <T> init(l: List<T>): List<T> = when (l) {
    emptyList<T>() -> throw IllegalArgumentException()
    else -> if (l.size == 1) emptyList() else listOf(head(l)) + init(tail(l))
}

/*
   * foldLeft reduces a list down to a single value by iteratively applying a
   * function over the elements of the list and carrying the cumulative result along.
   *
   * @param ls: the list to be reduced.
   * @param accum: the initial value
   * @param f: the binary function applied to the elements of the list and the cumulative value.
   * @return the final value
   */
fun <T> foldLeft(l: List<T>, accum: T, f: (T, T) -> T): T = when (l) {
    emptyList<T>() -> accum
    else -> foldLeft(tail(l), f(accum, head(l)), f)
}

fun <T> head(l: List<T>): T = l.take(1).get(0)

/**
 * Use your implementation of foldLeft to implement these functions:
 * - sum: produces the sum of all elements
 * - product: produces the product of all elements
 * - length: finds the length of the list.
 * - reverse: a new list with the elements of the first list in reverse order. T
 *   That is, reverse(listOf(1,2,3)) = listOf(3,2,1).
 * - flatten: Takes a list and produces a list by joining all the sublists into one long list.
 *   For example, flatten(listOf(listOf(1,2,3),listOf(4,5,6))) produces listOf(1,2,3,4,5,6).
 */
fun <T> sum(l: List<T>): T = foldLeft(l, 0, { x, y -> x + y })

fun <T> product(l: List<T>): T = foldLeft(l, 1, { x, y -> x * y })

fun <T> length(l: List<T>): Int = foldLeft(l, 0, { x, y -> 1 + y })

fun <T> reverse(l: List<T>): List<T> = when (l) {
    emptyList<T>() -> l
    else -> flatten(reverse(tail(l)) + listOf(head(l)))
}

fun <T> flatten(l: List<List<T>>): List<T> = when (l) {
    emptyList<T>() -> l
    else -> when (head(l)) {
        is List<*> -> flatten(head(l)) + flatten(tail(l))
    }
}

/**
 * map applies a function to a list, producing a new list of the functions' values.
 * As with the other functions, implement this recursively.
 *
 * @param ls : the list to be changed.
 * @param f  : the function to be applied to each element of the input.
 * @return the resulting list from applying f to each element of ls.
 */
fun <T> map(l: List<T>, f: (T) -> T): List<T> = when (l) {
    emptyList<T>() -> l
    else -> listOf(f(head(l))) + map(tail(l), f)
}

/**
 * filter removes all elements from a list for which a given predicate returns false.
 * As usual, this should be recursive.
 *
 * @param ls : the list to be filtered.
 * @param f  : the predicate
 * @return the filtered list.
 */
fun <T> filter(l: List<T>, f: (T) -> Boolean): List<T> = when (l) {
    emptyList<T>() -> l
    else -> if (f(head(l))) listOf(head(l)) + filter(tail(l), f) else filter(tail(l), f)
}

/**
 * flatMap is very similar to map. However, the function returns a List,
 * and flatMap flattens all of the resulting lists into one.
 *
 * @param ls : the list to be changed.
 * @param f  : the function to be applied.
 * @return a list containing the flattened results of applying f to all elements of ls.
 */
fun <T> flatMap(l: List<T>, f: (T) -> List<T>): List<T> {
    fun helper(result: List<T>, input: List<T>, f: (T) -> List<T>): List<T> = when (input) {
        is List<T> -> helper(result + f(head(input)), tail(input), f)
        else -> result
    }
    helper(listOf(), l, f)
}

/**
 * maxAverage takes a list of triples numbers) and returns the average value of the largest value in each triple.
 * You must use the methods you wrote above, particularly map and foldLeft.
 *
 * @param ls : a list of triples of real numbers, whose length is greater than 0.
 * @return the average value of the largest values in the triples.
 */
fun <T> maxAverage(l: List<Triple<T, T, T>>): T {
    fun <N: Double> maxTriple(x: Triple<N,N,N>){
        val (a,b,c) = x
        maxOf(x)
    }

   val resultList = map(l, maxTriple<Number>(l))
    sum<Double>(resultList) / length<Int>(resultList)

}


fun <T> variance(l: List<T>): T = TODO()