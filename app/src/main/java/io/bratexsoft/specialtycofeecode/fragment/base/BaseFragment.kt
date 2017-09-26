package io.bratexsoft.specialtycofeecode.fragment.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.bratexsoft.specialtycofeecode.applicaton.SpecialtyCoffeGuideInjector
import io.bratexsoft.specialtycofeecode.di.component.ApplicationComponent
import io.bratexsoft.specialtycofeecode.di.component.DaggerFragmentComponent
import io.bratexsoft.specialtycofeecode.di.component.FragmentComponent
import io.bratexsoft.specialtycofeecode.di.module.fragment.FragmentModule
import io.bratexsoft.specialtycofeecode.mvp.presenter.BasePresenter
import io.bratexsoft.specialtycofeecode.mvp.view.BaseView
import javax.inject.Inject

abstract class BaseFragment<B : ViewDataBinding, V : BaseView, P : BasePresenter<V>> : Fragment() {

    @Inject
    lateinit var presenter: P

    lateinit var binding: B

    private val fragmentComponent: FragmentComponent by lazy {
        DaggerFragmentComponent.builder()
                .applicationComponent(getApplicationComponent())
                .fragmentModule(FragmentModule(this))
                .build()
    }

    @LayoutRes
    abstract fun getLayoutRest(): Int

    abstract fun performFieldInjection(fragmentComponent: FragmentComponent)

    abstract fun attachViewToPresenter(presenter: P)

    abstract fun attachPresenterToDataBinding(presenter: P, binding: B)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performFieldInjection(fragmentComponent)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutRest(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachViewToPresenter(presenter)
    }

    private fun getApplicationComponent(): ApplicationComponent = SpecialtyCoffeGuideInjector.INSTANCE.appComponent
}