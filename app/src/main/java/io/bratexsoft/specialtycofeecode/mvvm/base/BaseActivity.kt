package io.bratexsoft.specialtycofeecode.mvvm.base

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import io.bratexsoft.specialtycofeecode.applicaton.SpecialtyCoffeGuideInjector
import io.bratexsoft.specialtycofeecode.di.component.ActivityComponent
import io.bratexsoft.specialtycofeecode.di.component.ApplicationComponent
import io.bratexsoft.specialtycofeecode.di.component.DaggerActivityComponent
import io.bratexsoft.specialtycofeecode.di.module.activity.ActivityModule
import javax.inject.Inject

abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModel: VM

    lateinit var binding: B

    private val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder().
                applicationComponent(getApplicationComponent())
                .activityModule(ActivityModule(this))
                .build()
    }

    @LayoutRes
    abstract fun getLayoutRest(): Int

    abstract fun performFieldInjection(activityComponent: ActivityComponent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performFieldInjection(activityComponent)
        binding = DataBindingUtil.setContentView(this, getLayoutRest())
    }

    private fun getApplicationComponent(): ApplicationComponent = SpecialtyCoffeGuideInjector.INSTANCE.appComponent
}