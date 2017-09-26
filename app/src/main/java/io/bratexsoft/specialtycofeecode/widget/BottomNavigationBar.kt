package io.bratexsoft.specialtycofeecode.widget

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.util.AttributeSet
import android.widget.LinearLayout

//TODO This class will be develop to provide more fluent api to modify of widget behavior
class BottomNavigationBar : LinearLayout {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {}

    fun addItem(@DrawableRes iconSelector: Int, @StringRes iconTex: Int) {

    }

    private fun init() {

    }
}