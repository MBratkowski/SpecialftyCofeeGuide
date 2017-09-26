package io.bratexsoft.specialtycofeecode.fragment

import android.support.v4.app.Fragment
import io.bratexsoft.specialtycofeecode.R
import io.bratexsoft.specialtycofeecode.databinding.MainProfileFragmentBinding
import io.bratexsoft.specialtycofeecode.di.component.FragmentComponent
import io.bratexsoft.specialtycofeecode.di.module.fragment.MainProfileModule
import io.bratexsoft.specialtycofeecode.fragment.base.AbstractFragmentDefinition
import io.bratexsoft.specialtycofeecode.fragment.base.BaseFragment
import io.bratexsoft.specialtycofeecode.mvp.contract.MainProfileContract
import io.bratexsoft.specialtycofeecode.mvp.presenter.MainProfilePresenter

class MainProfileFragment : BaseFragment<MainProfileFragmentBinding, MainProfileContract.View, MainProfilePresenter>(), MainProfileContract.View {

    override fun getLayoutRest(): Int = R.layout.main_profile_fragment

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun performFieldInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.plusModule(MainProfileModule()).inject(this)
    }

    override fun attachViewToPresenter(presenter: MainProfilePresenter) {
        presenter.onTakeView(this)
    }

    override fun attachPresenterToDataBinding(presenter: MainProfilePresenter, binding: MainProfileFragmentBinding) {
    }

    class Definition : AbstractFragmentDefinition() {
        override fun getFragmentName(): String = "Profile"

        override fun createFragment(): Fragment = MainProfileFragment()
    }
}