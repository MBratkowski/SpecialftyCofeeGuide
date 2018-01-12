package io.bratexsoft.specialtycofeecode.widget

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import io.bratexsoft.specialtycofeecode.mvvm.feature.places.item.ItemClickListener

class BaseViewHolder<out Binding : ViewDataBinding>(val binding: Binding, val listener: ItemClickListener) : RecyclerView.ViewHolder(binding.root)
