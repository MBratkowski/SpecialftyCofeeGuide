package cafe.speciality.kochere.support

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by mateuszbratkowski on 06/01/2018.
 */

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, url: String) {
    Picasso.with(imageView.context)
            .load(url)
            .fit()
            .centerCrop()
            .into(imageView)
}