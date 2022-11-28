package com.sever.caching.components

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.sever.caching.R
import com.sever.caching.enums.FontsEnum
import com.sever.caching.utils.FontCache

class TextView : AppCompatTextView {
    private var font = FontsEnum.SEMI_BOLD

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        applyAttributes(attrs)
    }

    init {
        this.typeface =
            if (font === FontsEnum.SEMI_BOLD)
                FontCache.get(context, "semi_bold")
            else
                FontCache.get(context, "medium")
    }

    private fun applyAttributes(attrs: AttributeSet?) {
        if (attrs != null) {
            val attributes = context.obtainStyledAttributes(attrs, R.styleable.TextView)
            font =
                if (attributes.hasValue(R.styleable.TextView_customFont))
                    FontsEnum.values()[attributes.getString(R.styleable.TextView_customFont)!!
                        .toInt()]
                else FontsEnum.SEMI_BOLD

            attributes.recycle()
        }
    }

    fun setFont(font: FontsEnum) {
        this.font = font
        invalidate()
    }
}