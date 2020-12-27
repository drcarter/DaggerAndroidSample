package com.drcarter.daggerandroid.model

interface Vehicle {

    fun increaseSpeed(value: Int)

    fun decreaseSpeed(value: Int)

    fun currentSpeed(): Int

    fun name(): String
}