package singleton

// Straightforward given the object type or the use of invoke on a class

// @see https://medium.com/@pablisco/companion-factory-methods-in-kotlin-e2eeb1e87f1b

object Database {
    init {
        println("init complete")
    }
}