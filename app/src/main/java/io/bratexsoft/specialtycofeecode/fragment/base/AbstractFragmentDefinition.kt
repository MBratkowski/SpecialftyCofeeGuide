package io.bratexsoft.specialtycofeecode.fragment.base

import android.support.v4.app.Fragment

abstract class AbstractFragmentDefinition {

    abstract fun getFragmentName(): String

    abstract fun createFragment(): Fragment


    interface FragmentTitle {

        fun getFragmentTitle(): String
    }


}