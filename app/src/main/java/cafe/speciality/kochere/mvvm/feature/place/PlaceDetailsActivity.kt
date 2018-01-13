package cafe.speciality.kochere.mvvm.feature.place

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cafe.speciality.kochere.R
import cafe.speciality.kochere.repository.model.Place

/**
 * Created by mateuszbratkowski on 12/01/2018.
 */
class PlaceDetailsActivity : AppCompatActivity() {

    companion object {

        const val EXTRA_DATA = "EXTRA_DATA"

        fun startActivity(context: Context, place: Place) {
            val intent = Intent(context, PlaceDetailsActivity::class.java)
            intent.putExtra(EXTRA_DATA, place)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.place_details_activity)
    }
}