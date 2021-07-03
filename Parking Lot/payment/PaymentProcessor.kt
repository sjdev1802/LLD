abstract class PaymentProcessor(id: String) {
    abstract fun processPayment(billAmount: Double, paymentMethod: PaymentMethod): Boolean

    abstract val type: String
}

class CashPaymentProcessor(id: String) : PaymentProcessor(id) {
    override fun processPayment(billAmount: Double, paymentMethod: PaymentMethod): Boolean {
        return true
    }

    override val type: String
        get() = "Cash Processor"
}

class CardProcessor(id: String) : PaymentProcessor(id) {
    override fun processPayment(billAmount: Double, paymentMethod: PaymentMethod): Boolean {
        return true
    }

    override val type: String
        get() = "Card Processor"
}
