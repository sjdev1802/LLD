abstract class PaymentMethod {
    abstract val type: String
}

class Cash : PaymentMethod() {
    override val type: String
        get() = "Cash"
}

class Card(cardDetails: String) : PaymentMethod() {
    override val type: String
        get() = "Card"
}


