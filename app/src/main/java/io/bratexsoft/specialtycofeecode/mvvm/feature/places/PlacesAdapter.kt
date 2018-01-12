package io.bratexsoft.specialtycofeecode.mvvm.feature.places

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.bratexsoft.specialtycofeecode.databinding.PlacesAdapterItemFeaturedBinding
import io.bratexsoft.specialtycofeecode.databinding.PlacesAdapterItemRegularBinding
import io.bratexsoft.specialtycofeecode.mvvm.feature.places.item.FeaturedItemViewModel
import io.bratexsoft.specialtycofeecode.mvvm.feature.places.item.ItemClickListener
import io.bratexsoft.specialtycofeecode.mvvm.feature.places.item.PlacesType
import io.bratexsoft.specialtycofeecode.mvvm.feature.places.item.RegularItemViewModel
import io.bratexsoft.specialtycofeecode.widget.BaseViewHolder

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
class PlacesAdapter(private val listener: ItemClickListener) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    companion object {
        const val LAYOUT_MANAGER_GRID = 2
        const val ONE_COLUMN_GRID = 2
        const val TWO_COLUMNS_GRID = 1
    }

    var listItem: List<PlacesType> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<ViewDataBinding> {
        return BaseViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent?.context),
                viewType,
                parent,
                false), listener)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (getItemViewType(position)) {
            PlacesType.ITEM_REGULAR -> {
                val normalHolder = holder.binding as PlacesAdapterItemRegularBinding
                normalHolder.viewModel = listItem[position] as RegularItemViewModel
                normalHolder.listener = listener
                normalHolder.executePendingBindings()
            }
            PlacesType.ITEM_FEATURED -> {
                val headerHolder = holder.binding as PlacesAdapterItemFeaturedBinding
                headerHolder.viewModel = listItem[position] as FeaturedItemViewModel
                headerHolder.listener = listener
                headerHolder.executePendingBindings()
            }
        }
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun getItemViewType(position: Int): Int {
        return listItem[position].getViewType()
    }
}