package decorator

class DVD(private val mTitle: String, price: Float) : Product(price)

abstract class Product(open val price: Float)

class WrappedProduct(private val mContents: Product) : Product(mContents.price) {

    // Override the default  price to return the
    // price plus the wrapping cost (£1.50).
    override val price: Float
        get() {
            return mContents.price + 1.50f
        }
}

