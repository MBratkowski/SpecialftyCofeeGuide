package cafe.speciality.kochere.mvp.feature.places.item.definition

/**
 * Created by mateuszbratkowski on 15/01/2018.
 */
interface RegularItemView {

    fun showTitle(title: String)

    fun showSpecialization(specialization: String)

    fun showCover(imageUrl: String)

}