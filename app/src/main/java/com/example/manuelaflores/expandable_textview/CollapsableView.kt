package com.example.manuelaflores.expandable_textview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout

class CollapsableView(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {
    init {
        inflate(context, R.layout.collapsable_view, this)

        context.obtainStyledAttributes(attrs,R.styleable.CollapsableView).apply {
            try {
                 getBoolean(R.styleable.CollapsableView_isExpandable,false)
                getInteger(R.styleable.CollapsableView_itemsToShow,3)
            } finally {
                recycle()
            }
        }
    }
}