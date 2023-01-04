package com.sever.caching.components

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.sever.caching.R
import com.sever.caching.enums.FontsEnum
import com.sever.caching.utils.FontCache

class TextView(context: Context, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {
    private var font = FontsEnum.SEMI_BOLD

    init {
        context.obtainStyledAttributes(attrs, R.styleable.TextView).apply {
            try {
                font =
                    if (hasValue(R.styleable.TextView_customFont))
                        FontsEnum.values()[getString(R.styleable.TextView_customFont)!!.toInt()]
                    else FontsEnum.SEMI_BOLD
            } finally {
                recycle()
            }
        }

        this.typeface =
            if (font === FontsEnum.SEMI_BOLD)
                FontCache.get(context, "semi_bold")
            else
                FontCache.get(context, "medium")
    }
}