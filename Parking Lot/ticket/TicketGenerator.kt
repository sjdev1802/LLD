package ticket

import parkingSpot.SpotAllocationHandler
import utils.Date

// Singleton class

class TicketGenerator(private val spotAllocationHandler: SpotAllocationHandler) {

    fun generateTicket(parkingSpot: String): Ticket {
        val entryTime = Date()
        val bookingDetails = spotAllocationHandler.bookSpot(parkingSpot)
        return Ticket(bookingDetails.second, bookingDetails.first, entryTime)
    }

}