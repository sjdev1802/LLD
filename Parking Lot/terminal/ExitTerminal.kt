import ticket.Ticket
import usecase.CheckoutHandler
import usecase.Printer

class ExitTerminal(id: String,
                   private val printer: Printer,
                   private val checkoutHandler: CheckoutHandler
) : Terminal(id, printer) {

    override val type: String
        get() = "Entry Terminal"

    fun startCheckout(ticket: Ticket){
        val billAmount = checkoutHandler.generateBill(ticket)
        printer.generateReceipt(billAmount)
        payBill(billAmount, ticket)
    }

    private fun payBill(billAmount: Double, ticket: Ticket){
        val paymentMethod = getPaymentMethod()
        checkoutHandler.processPayment(paymentMethod, billAmount, ticket.parkingSpot)
    }

    private fun getPaymentMethod(): PaymentMethod {
        // user will select payment method
        return Cash()
    }
}