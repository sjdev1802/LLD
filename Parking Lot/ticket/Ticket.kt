package ticket

import ParkingSpot
import utils.Date

class Ticket(
        val no: String,
        val parkingSpot: ParkingSpot,
        val entryTime: Date
)