import android.app.Activity
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun <T : View> Activity.bindView(@IdRes idRes: Int): Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return unsafeLazy { findViewById<T>(idRes) }
}

fun <T : View> View.bindView(@IdRes idRes: Int): Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return unsafeLazy { findViewById<T>(idRes) }
}

fun <T : View> bindView(view: T): Lazy<T> {
    return lazy {
        view
    }
}

fun RecyclerView.createViewHolder(@LayoutRes layoutRes: Int, parent: ViewGroup): View {
    return LayoutInflater
            .from(parent.context)
            .inflate(layoutRes, parent, false)
}


private fun <T> unsafeLazy(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)