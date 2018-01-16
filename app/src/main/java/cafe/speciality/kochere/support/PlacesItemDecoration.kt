package cafe.speciality.kochere.support

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import cafe.speciality.kochere.mvp.feature.places.item.definition.PlaceViewType


/**
 * Created by mateuszbratkowski on 16/01/2018.
 */
class PlacesItemDecoration : RecyclerView.ItemDecoration {

    private val attrs = intArrayOf(android.R.attr.listDivider)
    private val divider: Drawable

    constructor(context: Context) {
        val styledAttributes: TypedArray = context.obtainStyledAttributes(attrs);
        divider = styledAttributes.getDrawable(0);
        styledAttributes.recycle();
    }

    constructor(context: Context, @DrawableRes resId: Int) {
        divider = ContextCompat.getDrawable(context, resId)!!
    }

    override fun onDrawOver(c: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        val left = parent!!.paddingLeft
        val right = parent.width - parent.paddingRight

        val childCount = parent.childCount
        var currentPosition = 0
        while (currentPosition < childCount) {
            val view = parent.getChildAt(currentPosition)
            val position = parent.getChildAdapterPosition(view)
            val viewType = parent.adapter.getItemViewType(position)
            if (viewType == PlaceViewType.ITEM_REGULAR) {
                val params = view.layoutParams as RecyclerView.LayoutParams

                val top = view.bottom + params.bottomMargin
                val bottom = top + divider.intrinsicHeight
                divider.setBounds(left, top, right, bottom)
                divider.draw(c)
            }
            currentPosition++
        }
    }

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        val position = parent?.getChildAdapterPosition(view)!!
        val viewType: Int = parent.adapter?.getItemViewType(position)!!
        if (viewType == PlaceViewType.ITEM_REGULAR) {
            outRect?.set(0, 0, 0, divider.intrinsicHeight)
        } else {
            outRect?.setEmpty()
        }
    }
}