package cafe.speciality.kochere.mvp.base

/**
 * Created by mateuszbratkowski on 15/01/2018.
 */
abstract class BasePresenter<V : Any> {

    open lateinit var view: V

    fun onAttachView(view: V) {
        this.view = view
        onAttachedView()
    }

    abstract fun onAttachedView()
}