abstract class ParkingSpot(val id: String, val position: String) {
    abstract val type: String
    abstract val hourlyRate: Double
}

class LargeVehicleSpot(id: String, position: String) : ParkingSpot(id, position) {
    override val type: String
        get() = TYPE
    override val hourlyRate: Double
        get() = 10.0

    companion object {
        const val TYPE = "Large Vehicle"
    }
}

class CarParkingSpot(id: String, position: String) : ParkingSpot(id, position) {
    override val type: String
        get() = TYPE
    override val hourlyRate: Double
        get() = 5.0

    companion object {
        const val TYPE = "Car"
    }
}

class TwoWheelerSpot(id: String, position: String) : ParkingSpot(id, position) {
    override val type: String
        get() = TYPE
    override val hourlyRate: Double
        get() = 2.0

    companion object {
        const val TYPE = "Two wheeler"
    }
}