package xpay

interface PayD {
    val custCardNo: String
    val cardOwnerName: String
    val cardExpMonthDate: String
    val CVVNo: Integer
    val totalAmount: Double
}
