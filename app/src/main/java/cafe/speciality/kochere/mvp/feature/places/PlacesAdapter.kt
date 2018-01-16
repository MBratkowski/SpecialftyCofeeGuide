package cafe.speciality.kochere.mvp.feature.places

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import cafe.speciality.kochere.mvp.feature.places.contract.PlacesContract
import cafe.speciality.kochere.mvp.feature.places.item.BottomViewHolder
import cafe.speciality.kochere.mvp.feature.places.item.FeaturedItemViewHolder
import cafe.speciality.kochere.mvp.feature.places.item.RegularItemViewHolder
import cafe.speciality.kochere.mvp.feature.places.item.definition.PlaceViewType

/**
 * Created by mateuszbratkowski on 08/01/2018.
 */
class PlacesAdapter(private val presenter: PlacesContract.Presenter) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var listItem: List<PlaceViewType> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        return when (viewType) {
            PlaceViewType.ITEM_REGULAR -> RegularItemViewHolder(presenter, LayoutInflater.from(parent?.context).inflate(viewType,
                    parent,
                    false))
            PlaceViewType.ITEM_FEATURED -> FeaturedItemViewHolder(presenter, LayoutInflater.from(parent?.context).inflate(viewType,
                    parent,
                    false))
            PlaceViewType.ITEM_BOTTOM -> BottomViewHolder(presenter, LayoutInflater.from(parent?.context).inflate(viewType,
                    parent,
                    false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            PlaceViewType.ITEM_REGULAR -> {
                presenter.onBindItemRegular(position, holder as RegularItemViewHolder)
            }
            PlaceViewType.ITEM_FEATURED -> {
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