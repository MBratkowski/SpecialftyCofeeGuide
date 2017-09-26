package io.bratexsoft.specialtycofeecode.fragment.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import io.bratexsoft.specialtycofeecode.fragment.base.AbstractFragmentDefinition

class MainFragmentPagerAdapter constructor(fragmentManager: FragmentManager,
                                           private val fragments: List<AbstractFragmentDefinition>) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = fragments[position].createFragment()

    override fun getCount(): Int = fragments.size
}