package io.bratexsoft.specialtycofeecode

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.ViewGroup
import io.bratexsoft.specialtycofeecode.widget.BaseViewHolder

fun <B : ViewDataBinding> ViewGroup.inflateItemLayout(@LayoutRes layoutRes: Int, attachToParent: Boolean = false): BaseViewHolder<B> {
    return BaseViewHolder(DataBindingUtil.inflate(LayoutInflater.from(context),
            layoutRes,
            this,
            attachToParent))

}