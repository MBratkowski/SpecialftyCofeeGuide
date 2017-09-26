package io.bratexsoft.specialtycofeecode.adapter.deleagte

import android.databinding.ViewDataBinding
import android.view.ViewGroup
import io.bratexsoft.specialtycofeecode.widget.BaseViewHolder

interface ViewTypeDelegate<B : ViewDataBinding> {
    fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder<B>

    fun onBindViewHolder(holder: BaseViewHolder<*>, item: ViewType)
}