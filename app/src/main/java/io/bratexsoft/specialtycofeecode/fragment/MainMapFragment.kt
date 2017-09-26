package io.bratexsoft.specialtycofeecode.fragment

import android.support.v4.app.Fragment
import io.bratexsoft.specialtycofeecode.R
import io.bratexsoft.specialtycofeecode.databinding.MainMapFragmentBinding
import io.bratexsoft.specialtycofeecode.di.component.FragmentComponent
import io.bratexsoft.specialtycofeecode.di.module.fragment.MainMapModule
import io.bratexsoft.specialtycofeecode.fragment.base.AbstractFragmentDefinition
import io.bratexsoft.specialtycofeecode.fragment.base.BaseFragment
import io.bratexsoft.specialtycofeecode.mvp.contract.MainMapContract
import io.bratexsoft.specialtycofeecode.mvp.presenter.MainMapPresenter

class MainMapFragment : BaseFragment<MainMapFragmentBinding, MainMapContract.View, MainMapPresenter>(), MainMapContract.View {

    override fun getLayoutRest(): Int = R.layout.main_map_fragment

    override fun performFieldInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.plusModule(MainMapModule()).inject(this)
    }

    override fun attachViewToPresenter(presenter: MainMapPresenter) {
        presenter.onTakeView(this)
    }

    override fun attachPresenterToDataBinding(presenter: MainMapPresenter, binding: MainMapFragmentBinding) {
    }

    override fun showError() {
    }

    class Definition : AbstractFragmentDefinition() {
        override fun getFragmentName(): String = "Map"

        override fun createFragment(): Fragment = MainMapFragment()
    }


}