package io.bratexsoft.specialtycofeecode.mvp.contract

import io.bratexsoft.specialtycofeecode.mvp.presenter.BasePresenter
import io.bratexsoft.specialtycofeecode.mvp.view.BaseView

interface MainContract {

    interface View : BaseView {
    }

    abstract class Presenter : BasePresenter<View>() {
        abstract fun openFromView()

        abstract fun openToView()
    }

}