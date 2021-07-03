package usecase

import ParkingSpot
import PaymentMethod
import PaymentProcessor
import parkingSpot.SpotAllocationHandler
import ticket.Ticket
import utils.Date
import utils.calculateNumberOfHours
import java.lang.RuntimeException

class CheckoutHandler (private val spotAllocationHandler: SpotAllocationHandler){

    lateinit var paymentProcessor: PaymentProcessor

    fun generateBill(ticket: Ticket): Double {
        val rate = ticket.parkingSpot.hourlyRate
        val currentTime = Date()
        val numberOfHours = calculateNumberOfHours(currentTime, ticket.entryTime)
        return rate * numberOfHours
    }

    fun processPayment(paymentMethod: PaymentMethod, billAmount: Double, parkingSpot: ParkingSpot) {
        val success : Boolean = paymentProcessor.processPayment(billAmount, paymentMethod)
        if (success){
            spotAllocationHandler.releaseSpot(parkingSpot)
        }else throw RuntimeException("Error - processing payment")
    }
}