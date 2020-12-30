package com.drcarter.daggerandroid.ui.sub.fragment

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.drcarter.daggerandroid.R
import com.drcarter.daggerandroid.databinding.FragmentSubBinding
import com.drcarter.daggerandroid.ui.BaseFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class SubFragment : BaseFragment<FragmentSubBinding>(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<SubViewModel> { viewModelFactory }

    override fun getLayoutId(): Int = R.layout.fragment_sub

    override fun initViewDataBinding() {
        binding.run {
            viewModel = this@SubFragment.viewModel
        }
    }

    override fun initViewModel() {
        viewModel.selectVehicle(arguments?.getString("key") ?: "taxi")
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    companion object {
        fun newInstance(key: String): SubFragment {
            return SubFragment().apply {
                arguments = Bundle().apply {
                    putString("key", key)
                }
            }
        }
    }
}