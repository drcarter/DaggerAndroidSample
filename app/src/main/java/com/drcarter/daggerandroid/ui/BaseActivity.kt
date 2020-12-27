package com.drcarter.daggerandroid.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity() {

    @LayoutRes
    abstract fun contentViewLayout(): Int

    abstract fun initBinding(binding: VB)

    abstract fun initViewModel()

    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, contentViewLayout())
        binding.lifecycleOwner = this
        initBinding(binding)
        initViewModel()
    }

    override fun onDestroy() {
        this.binding.unbind()
        super.onDestroy()
    }
}