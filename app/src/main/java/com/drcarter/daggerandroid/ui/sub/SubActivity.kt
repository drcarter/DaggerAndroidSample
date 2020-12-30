package com.drcarter.daggerandroid.ui.sub

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.drcarter.daggerandroid.R
import com.drcarter.daggerandroid.databinding.ActivitySubBinding
import com.drcarter.daggerandroid.ui.BaseActivity
import com.drcarter.daggerandroid.ui.sub.fragment.SubFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class SubActivity : BaseActivity<ActivitySubBinding>(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun contentViewLayout(): Int = R.layout.activity_sub

    override fun initBinding(binding: ActivitySubBinding) {
        binding.run {
            with(viewpager) {
                adapter = SubAdapter(supportFragmentManager, lifecycle)
            }
        }
    }

    override fun initViewModel() {
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

}

class SubAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                SubFragment.newInstance("taxi")
            }
            1 -> {
                SubFragment.newInstance("bus")
            }
            else -> {
                SubFragment.newInstance("taxi")
            }
        }
    }

}