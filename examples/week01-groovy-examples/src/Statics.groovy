3.times {
    println Math.random()
}

Math.metaClass.static.random = { ->
    return 0.5
}

3.times {
    println Math.random()
}
