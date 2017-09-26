package io.bratexsoft.specialtycofeecode.widget

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

class BaseViewHolder<Binding : ViewDataBinding>(private val binding: Binding) : RecyclerView.ViewHolder(binding.root)