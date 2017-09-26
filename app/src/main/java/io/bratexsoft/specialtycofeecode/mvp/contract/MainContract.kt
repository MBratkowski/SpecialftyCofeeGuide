package io.bratexsoft.specialtycofeecode.mvp.contract

import io.bratexsoft.specialtycofeecode.mvp.view.BaseView

interface MainContract {
    interface Presenter {
        fun openFromView()

        fun openToView()
    }

    interface View : BaseView {

    }

}