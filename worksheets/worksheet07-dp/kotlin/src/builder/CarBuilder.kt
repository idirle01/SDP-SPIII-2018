package builder

interface CarBuilder {
    fun buildBodyStyle()
    fun buildPower()
    fun buildEngine()
    fun buildBrakes()
    fun buildSeats()
    fun buildWindows()
    fun buildFuelType()
    fun getCar(): Car
}