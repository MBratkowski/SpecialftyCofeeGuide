package cafe.speciality.kochere.widget

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

class BaseViewHolder<out Binding : ViewDataBinding>(val binding: Binding) : RecyclerView.ViewHolder(binding.root)
