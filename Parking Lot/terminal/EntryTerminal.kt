import ticket.Ticket
import ticket.TicketGenerator
import usecase.Printer

class EntryTerminal(
        id: String,
        private val printer: Printer,
        private val ticketGenerator: TicketGenerator
) : Terminal(id, printer) {

    override val type: String
        get() = "Entry Terminal"

    // called by user
    fun getTicket(spotType: String){
        val ticket = generateTicket(spotType)
        printer.printTicket(ticket)
    }

    private fun generateTicket(spotType: String): Ticket {
        return ticketGenerator.generateTicket(spotType)
    }
}