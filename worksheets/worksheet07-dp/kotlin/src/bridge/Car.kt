package bridge

abstract class Car(val product: Product, val carType: String) {
    abstract fun assemble()
    abstract fun produceProduct()
    abstract fun printDetails()
}
