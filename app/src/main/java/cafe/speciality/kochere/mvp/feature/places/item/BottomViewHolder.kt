package cafe.speciality.kochere.mvp.feature.places.item

import android.support.v7.widget.RecyclerView
import android.view.View
import cafe.speciality.kochere.mvp.feature.places.contract.PlacesContract
import kotlinx.android.extensions.LayoutContainer

/**
 * Created by mateuszbratkowski on 15/01/2018.
 */
class BottomViewHolder constructor(private val presenter: PlacesContract.Presenter, override val containerView: View?) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        itemView?.setOnClickListener {
            presenter.onBottomItemClick()
        }
    }

}