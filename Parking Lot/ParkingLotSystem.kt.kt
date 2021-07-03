import ticket.TicketGenerator
import usecase.CheckoutHandler
import usecase.Printer
import parkingSpot.SpotAllocationHandler
import java.lang.RuntimeException

class ParkingLotSystem {

    lateinit var exitTerminals: MutableList<ExitTerminal>

    lateinit var entryTerminals: MutableList<EntryTerminal>

    private lateinit var parkingSpotAllocationHandler: SpotAllocationHandler
    private lateinit var ticketGenerator: TicketGenerator
    private lateinit var parkingSpots: List<ParkingSpot>

    fun initializeSystem(noOfEntryTerminal: Int, noOfExitTerminals: Int, parkingSpots: List<ParkingSpot>) {
        this.parkingSpots = parkingSpots
        entryTerminals = mutableListOf()
        exitTerminals = mutableListOf()
        parkingSpotAllocationHandler = SpotAllocationHandler(parkingSpots)
        ticketGenerator = TicketGenerator(parkingSpotAllocationHandler)
        for (i in 0..noOfEntryTerminal) {
            entryTerminals.add(EntryTerminal(i.toString(), Printer(), ticketGenerator))
        }
        for (i in 0..noOfExitTerminals) {
            exitTerminals.add(ExitTerminal(i.toString(), Printer(), CheckoutHandler(parkingSpotAllocationHandler)))
        }
    }

    fun requestVehicleEntry() {
        askAndReserveSpot()
    }

    private fun askAndReserveSpot() {
        // get spot type from user
        val spotType = CarParkingSpot.TYPE
        // fetch terminal
        val terminal: EntryTerminal = entryTerminals[0]


        val available = parkingSpotAllocationHandler.checkAvailability(spotType)
        if (available) {
            terminal.getTicket(spotType)
        } else throw RuntimeException("Desired parking spot is not available")
    }

    fun resetSystem() {
        parkingSpotAllocationHandler.freeAllSpots()
    }

}