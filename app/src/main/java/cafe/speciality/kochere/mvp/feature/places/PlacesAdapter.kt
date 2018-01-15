package cafe.speciality.kochere.mvp.feature.places

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import cafe.speciality.kochere.mvp.feature.places.contract.PlacesContract
import cafe.speciality.kochere.mvp.feature.places.item.BottomViewHolder
import cafe.speciality.kochere.mvp.feature.places.item.FeaturedItemViewHolder
import cafe.speciality.kochere.mvp.feature.places.item.RegularItemViewHolder
import cafe.speciality.kochere.mvp.feature.places.item.definition.PlacesType
import cafe.speciality.kochere.repository.model.Places

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
class PlacesAdapter(private val presenter: PlacesContract.Presenter) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var listItem: List<Places> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        return when (viewType) {
            PlacesType.ITEM_REGULAR, PlacesType.ITEM_FEATURED -> RegularItemViewHolder(presenter, LayoutInflater.from(parent?.context).inflate(viewType,
                    parent,
                    false))
            PlacesType.ITEM_FEATURED -> FeaturedItemViewHolder(presenter, LayoutInflater.from(parent?.context).inflate(viewType,
                    parent,
                    false))
            PlacesType.ITEM_BOTTOM -> BottomViewHolder(presenter, LayoutInflater.from(parent?.context).inflate(viewType,
                    parent,
                    false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            PlacesType.ITEM_REGULAR -> {
                presenter.onBindItemRegular(position, holder as RegularItemViewHolder)
            }
            PlacesType.ITEM_FEATURED -> {
                presenter.onBindItemFeatured(position, holder as FeaturedItemViewHolder)
            }
        }
    }

    override fun getItemCount(): Int {
        return presenter.getCount()
    }

    override fun getItemViewType(position: Int): Int {
        return presenter.getList()[position].getViewType()
    }
}