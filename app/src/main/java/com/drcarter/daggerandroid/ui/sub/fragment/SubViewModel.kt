package com.drcarter.daggerandroid.ui.sub.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drcarter.daggerandroid.di.VEHICLE_BUS
import com.drcarter.daggerandroid.di.VEHICLE_TAXI
import com.drcarter.daggerandroid.model.Vehicle
import javax.inject.Inject

class SubViewModel @Inject constructor(
    @VEHICLE_BUS private val bus: Vehicle,
    @VEHICLE_TAXI private val taxi: Vehicle
) : ViewModel() {

    val vehicleLiveData = MutableLiveData<Vehicle?>(null)

    fun selectVehicle(key: String) {
        when (key) {
            "bus" -> {
                vehicleLiveData.value = bus
            }
            "taxi" -> {
                vehicleLiveData.value = taxi
            }
        }
    }

}