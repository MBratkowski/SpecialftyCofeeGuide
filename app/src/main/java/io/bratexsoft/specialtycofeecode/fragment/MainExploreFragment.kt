package io.bratexsoft.specialtycofeecode.fragment

import android.support.v4.app.Fragment
import io.bratexsoft.specialtycofeecode.R
import io.bratexsoft.specialtycofeecode.databinding.MainExploreFragmentBinding
import io.bratexsoft.specialtycofeecode.di.component.FragmentComponent
import io.bratexsoft.specialtycofeecode.di.module.fragment.MainExploreModule
import io.bratexsoft.specialtycofeecode.fragment.base.AbstractFragmentDefinition
import io.bratexsoft.specialtycofeecode.fragment.base.BaseFragment
import io.bratexsoft.specialtycofeecode.mvp.contract.MainExploreContract
import io.bratexsoft.specialtycofeecode.mvp.presenter.MainExplorePresenter

class MainExploreFragment : BaseFragment<MainExploreFragmentBinding, MainExploreContract.View, MainExplorePresenter>(),
        MainExploreContract.View {

    override fun getLayoutRest(): Int = R.layout.main_explore_fragment

    override fun performFieldInjection(fragmentComponent: FragmentComponent) {
        fragmentComponent.plusModule(MainExploreModule()).inject(this)
    }

    override fun attachViewToPresenter(presenter: MainExplorePresenter) {
        presenter.onTakeView(this)
    }

    override fun attachPresenterToDataBinding(presenter: MainExplorePresenter, binding: MainExploreFragmentBinding) {

    }

    override fun showError() {
    }

    class Definition : AbstractFragmentDefinition() {
        override fun getFragmentName(): String = "Explore"

        override fun createFragment(): Fragment = MainExploreFragment()
    }
}
