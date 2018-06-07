package memoization

import java.util.concurrent.ConcurrentHashMap

fun <A, R> memoize(fn: (A) -> R): (A) -> R {
    val map = ConcurrentHashMap<A, R>()
    return { a ->
        map.getOrPut(a) {
            fn(a)
        }
    }
}
