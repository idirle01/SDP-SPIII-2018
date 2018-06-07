package algebraic

sealed class DeliveryStatus {

    object Preparing : DeliveryStatus()

    data class Dispatching(
            val trackingNumber: String
    ) : DeliveryStatus()

    object Delivered : DeliveryStatus()

}

fun showDeliveryStatus(status: DeliveryStatus) {
    return when (status) {
        is DeliveryStatus.Preparing -> showPreparing()
        is DeliveryStatus.Dispatching -> showDispatched(status.trackingNumber) // note that no cast needed!
        is DeliveryStatus.Delivered -> showDelivered()
    }
}

fun showPreparing() {}

fun showDispatched(trackingNumber: String) {}

fun showDelivered() {}