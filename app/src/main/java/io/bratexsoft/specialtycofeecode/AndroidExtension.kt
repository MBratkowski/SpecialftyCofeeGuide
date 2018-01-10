import android.app.Activity
import android.support.annotation.IdRes
import android.view.View

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

private fun <T> unsafeLazy(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)