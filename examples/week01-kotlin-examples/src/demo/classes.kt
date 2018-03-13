package demo

// ----- CLASSES -----
// There are no static methods
// Classes are final by default unless marked open
// The fields must also be marked as open

open class Animal(val name: String, var height: Double, var weight: Double) {

    // Objects are initialized in init
    init {

        // Regex that matches for a number any place
        // in a string
        val regex = Regex(".*\\d+.*")

        // If these requirements aren't met an
        // IllegalArgumentException is thrown
        require(!name.matches(regex)) { "Animal Name can't Contain Numbers" }

        require(height > 0) { "Height must be greater then 0" }

        require(weight > 0) { "Weight must be greater then 0" }

    }

    // If you want to allow overriding of this method
    // you must use open
    open fun getInfo(): Unit {
        println("$name is $height tall and weighs $weight")
    }
}

// ----- INHERITANCE -----
class Dog(name: String,
          height: Double,
          weight: Double,
          var owner: String) : Animal(name, height, weight) {

    // Overriding Animal method
    override fun getInfo(): Unit {
        println("$name is $height tall, weighs $weight and is owned by $owner")
    }

}
