package cafe.speciality.kochere.mvp.feature.places.item

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import cafe.speciality.kochere.mvp.feature.places.contract.PlacesContract
import cafe.speciality.kochere.mvp.feature.places.item.definition.RegularItemView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.places_adapter_item_regular.view.*

/**
 * Created by mateuszbratkowski on 15/01/2018.
 */
class RegularItemViewHolder constructor(presenter: PlacesContract.Presenter,
                                        override val containerView: View?) : RecyclerView.ViewHolder(containerView), LayoutContainer, RegularItemView {

    private val cover: ImageView = itemView.restaurant_icon
    private val titleTextView: TextView = itemView.restaurant_title
    private val specializationTextView: TextView = itemView.restaurant_specialization

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