package cafe.speciality.kochere.mvp.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import cafe.speciality.kochere.applicaton.SpecialtyCoffeGuideInjector
import cafe.speciality.kochere.di.component.ActivityComponent
import cafe.speciality.kochere.di.component.ApplicationComponent
import cafe.speciality.kochere.di.component.DaggerActivityComponent
import cafe.speciality.kochere.di.module.activity.ActivityModule
import javax.inject.Inject

abstract class BaseActivity<V : BaseView, P : BasePresenter<V>> : AppCompatActivity() {

    @Inject lateinit var presenter: P

    private val activityComponent: ActivityComponent by lazy {
        DaggerActivityComponent.builder().
                applicationComponent(getApplicationComponent())
                .activityModule(ActivityModule(this))
                .build()
    }

    @LayoutRes
    abstract fun getLayoutRest(): Int

    abstract fun performFieldInjection(activityComponent: ActivityComponent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRest())
        performFieldInjection(activityComponent)
        presenter.onAttachView(this as V)
    }

    private fun getApplicationComponent(): ApplicationComponent = SpecialtyCoffeGuideInjector.INSTANCE.appComponent
}