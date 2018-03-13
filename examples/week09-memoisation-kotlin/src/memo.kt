fun <A, B> memo(f: (A) -> B): (A) -> B {
    val cache = HashMap<A, B>()
    return { a: A ->
        val result = cache.get(a)
        when (result) {
            null -> {
                val temp = f(a)
                cache[a] = temp
                temp
            }
            else -> result
        }
    }
}
