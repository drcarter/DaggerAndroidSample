package com.drcarter.daggerandroid.di.module

import com.drcarter.daggerandroid.di.VEHICLE_BUS
import com.drcarter.daggerandroid.di.VEHICLE_TAXI
import com.drcarter.daggerandroid.model.Bus
import com.drcarter.daggerandroid.model.Taxi
import com.drcarter.daggerandroid.model.Vehicle
import dagger.Module
import dagger.Provides

@Module
class VehicleModule {

    @VEHICLE_BUS
    @Provides
    fun provideBus(): Vehicle {
        return Bus()
    }

    @VEHICLE_TAXI
    @Provides
    fun provideTaxi(): Vehicle {
        return Taxi()
    }
}