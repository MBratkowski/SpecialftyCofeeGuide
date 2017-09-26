package io.bratexsoft.specialtycofeecode.activity

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
import io.bratexsoft.specialtycofeecode.mvp.presenter.BasePresenter
import io.bratexsoft.specialtycofeecode.mvp.view.BaseView
import javax.inject.Inject

abstract class BaseActivity<B : ViewDataBinding, V : BaseView, P : BasePresenter<V>> : AppCompatActivity() {

    @Inject
    lateinit var presenter: P

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

    abstract fun attachViewToPresenter(presenter: P)

    abstract fun attachPresenterToDataBinding(presenter: P, binding: B)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performFieldInjection(activityComponent)
        binding = DataBindingUtil.setContentView(this, getLayoutRest())
        attachPresenterToDataBinding(presenter, binding)
        attachViewToPresenter(presenter)
    }

    private fun getApplicationComponent(): ApplicationComponent = SpecialtyCoffeGuideInjector.INSTANCE.appComponent
}