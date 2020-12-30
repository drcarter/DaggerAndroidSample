package com.drcarter.daggerandroid.ui.main

import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.drcarter.daggerandroid.R.layout
import com.drcarter.daggerandroid.databinding.ActivityMainBinding
import com.drcarter.daggerandroid.ui.BaseActivity
import com.drcarter.daggerandroid.ui.sub.SubActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val mainViewModel: MainViewModel by viewModels() {
        viewModelFactory
    }

    override fun contentViewLayout(): Int = layout.activity_main

    override fun initBinding(binding: ActivityMainBinding) {
        binding.run {
            buttonBusSpeedIncrease.setOnClickListener {
                mainViewModel.increaseBusSpeed(5)

                textBusSpeed.text = "bus speed : " + mainViewModel.currentBusSpeed()
            }
            buttonBusSpeedDecrease.setOnClickListener {
                mainViewModel.decreaseBusSpeed()

                textBusSpeed.text = "bus speed : " + mainViewModel.currentBusSpeed()
            }

            buttonTaxiSpeedIncrease.setOnClickListener {
                mainViewModel.increaseTaxiSpeed(10)
                textTaxiSpeed.text = "taxi speed : " + mainViewModel.currentTaxiSpeed()
            }
            buttonTaxiSpeedDecrease.setOnClickListener {
                mainViewModel.decreaseTaxiSpeed()
                textTaxiSpeed.text = "taxi speed : " + mainViewModel.currentTaxiSpeed()
            }

            buttonSub.setOnClickListener {
                Intent(this@MainActivity, SubActivity::class.java).run {
                    startActivity(this)
                }
            }
        }
    }

    override fun initViewModel() {
        mainViewModel.run {

        }
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}