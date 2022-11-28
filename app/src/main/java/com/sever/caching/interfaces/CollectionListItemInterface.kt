package com.sever.caching.interfaces

interface CollectionListItemInterface {
    fun type(): Int

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_EVENT = 1
    }
}