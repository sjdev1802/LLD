package parkingSpot

import ParkingSpot
import utils.orZero
import java.lang.RuntimeException
import java.util.*

class SpotAllocationHandler(private val spots: List<ParkingSpot>) {

    private val availableSpots = mutableMapOf<String, Int>()
    private val spotsMap = mutableMapOf<String, Queue<ParkingSpot>>()

    init {
        processSpots()
    }

    private fun processSpots() {
        spots.forEach {
            val spotType = it.type
            availableSpots[spotType] = availableSpots[spotType].orZero() + 1
            if (!spotsMap.containsKey(spotType)) spotsMap[spotType] = PriorityQueue()
            spotsMap[spotType]?.add(it)
        }
    }

    fun freeAllSpots() {

    }

    fun checkAvailability(type: String): Boolean {
        if (availableSpots[type].orZero() > 0) return true
        return false
    }

    fun bookSpot(spotType: String): Pair<ParkingSpot, String> {
        if (checkAvailability(spotType)) {
            return Pair(reserveSpot(spotType), generateToken())
        } else {
            throw RuntimeException("All slots has been booked")
        }

    }

    private fun generateToken(): String {
        return ""
    }

    private fun reserveSpot(spotType: String): ParkingSpot {
        availableSpots[spotType] = availableSpots[spotType].orZero() - 1;
        return spotsMap[spotType]?.let {
            val value = it.peek()
            it.remove()
            value
        } ?: throw RuntimeException("Error - reserving spot")
    }

    fun releaseSpot(parkingSpot: ParkingSpot){

    }

}

