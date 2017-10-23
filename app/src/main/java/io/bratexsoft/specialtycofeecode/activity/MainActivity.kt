package io.bratexsoft.specialtycofeecode.activity

import android.os.Bundle
import io.bratexsoft.specialtycofeecode.R
import io.bratexsoft.specialtycofeecode.databinding.MainActivityBinding
import io.bratexsoft.specialtycofeecode.di.component.ActivityComponent
import io.bratexsoft.specialtycofeecode.di.module.activity.MainModule
import io.bratexsoft.specialtycofeecode.fragment.adapter.MainFragmentPagerAdapter
import io.bratexsoft.specialtycofeecode.mvp.contract.MainContract
import io.bratexsoft.specialtycofeecode.mvp.presenter.MainPresenter
import javax.inject.Inject

class MainActivity : BaseActivity<MainActivityBinding, MainContract.View, MainPresenter>(), MainContract.View {
    override fun attachViewToPresenter(presenter: MainPresenter) {
        presenter.onTakeView(this)
    }

    override fun attachPresenterToDataBinding(presenter: MainPresenter, binding: MainActivityBinding) {
        
    }

    @Inject
    lateinit var pageAdapter: MainFragmentPagerAdapter

    override fun showError() {
    }

    override fun getLayoutRest(): Int = R.layout.main_activity

    override fun performFieldInjection(activityComponent: ActivityComponent) {
        activityComponent.plusModule(MainModule()).inject(this)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewPager()
    }

    private fun initViewPager() {
        binding.mainViewPager.adapter = pageAdapter
        binding.mainViewPager.offscreenPageLimit = 2
    }

}