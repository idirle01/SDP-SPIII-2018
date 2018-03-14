package xpay

interface Xpay {
    val creditCardNo: String
    val customerName: String
    val cardExpMonth: String
    val cardExpYear: String
    val cardCVVNo: Short
    val amount: Double
}
