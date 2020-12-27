package com.drcarter.daggerandroid.ui.main

import androidx.lifecycle.ViewModel
import com.drcarter.daggerandroid.di.VEHICLE_BUS
import com.drcarter.daggerandroid.di.VEHICLE_TAXI
import com.drcarter.daggerandroid.model.Vehicle
import javax.inject.Inject

class MainViewModel @Inject constructor(
    @VEHICLE_BUS private val bus: Vehicle,
    @VEHICLE_TAXI private val taxi: Vehicle
) : ViewModel() {

    fun increaseBusSpeed(speed: Int) {
        bus.increaseSpeed(speed)
    }

    fun currentBusSpeed(): Int {
        return bus.currentSpeed()
    }

    fun decreaseBusSpeed() {
        bus.decreaseSpeed(1)
    }


    fun increaseTaxiSpeed(speed: Int) {
        taxi.increaseSpeed(speed)
    }

    fun currentTaxiSpeed(): Int {
        return taxi.currentSpeed()
    }

    fun decreaseTaxiSpeed() {
        taxi.decreaseSpeed(2)
    }
}