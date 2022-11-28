package com.sever.caching.entities

import com.sever.caching.interfaces.CollectionListItemInterface

data class CollectionHeaderEntity(
    val title: String,
    val size: Int
) : CollectionListItemInterface {
    override fun type(): Int {
        return CollectionListItemInterface.TYPE_HEADER
    }
}