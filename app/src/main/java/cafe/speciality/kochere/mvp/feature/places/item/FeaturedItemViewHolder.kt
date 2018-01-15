package cafe.speciality.kochere.mvp.feature.places.item

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import cafe.speciality.kochere.mvp.feature.places.contract.PlacesContract
import cafe.speciality.kochere.mvp.feature.places.item.definition.FeaturedItemView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.places_adapter_item_featured.view.*

/**
 * Created by mateuszbratkowski on 15/01/2018.
 */
class FeaturedItemViewHolder constructor(presenter: PlacesContract.Presenter,
                                         override val containerView: View?) : RecyclerView.ViewHolder(containerView), LayoutContainer, FeaturedItemView {

    private val cover: ImageView = itemView.restaurant_featured_cover
    private val titleTextView: TextView = itemView.restaurant_featured_title
    private val specializationTextView: TextView = itemView.restaurant_featured_specialization

    init {
        itemView.setOnClickListener {
            presenter.onRegularItemClick(adapterPosition)
        }
    }

    override fun showTitle(title: String) {
        titleTextView.text = title
    }

    override fun showSpecialization(specialization: String) {
        specializationTextView.text = specialization
    }

    override fun showCover(imageUrl: String) {
        Picasso.with(containerView?.context)
                .load(imageUrl)
                .fit()
                .centerCrop()
                .into(cover)
    }


}