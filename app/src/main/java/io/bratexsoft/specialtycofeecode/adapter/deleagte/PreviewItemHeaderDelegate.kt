package io.bratexsoft.specialtycofeecode.adapter.deleagte

import android.view.ViewGroup
import io.bratexsoft.specialtycofeecode.R
import io.bratexsoft.specialtycofeecode.databinding.PreviewItemHeaderBinding
import io.bratexsoft.specialtycofeecode.inflateItemLayout
import io.bratexsoft.specialtycofeecode.widget.BaseViewHolder

class PreviewItemHeaderDelegate : ViewTypeDelegate<PreviewItemHeaderBinding> {

    override fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder<PreviewItemHeaderBinding> {
        return parent.inflateItemLayout(R.layout.preview_item_header)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, item: ViewType) {
    }

}