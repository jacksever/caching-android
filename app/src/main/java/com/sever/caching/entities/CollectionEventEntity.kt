package com.sever.caching.entities

import androidx.annotation.DrawableRes
import com.sever.caching.interfaces.CollectionListItemInterface

data class CollectionEventEntity(
    val text: String,
    val time: Int,
    @DrawableRes val image: Int,
) : CollectionListItemInterface {
    override fun type(): Int {
        return CollectionListItemInterface.TYPE_EVENT
    }
}