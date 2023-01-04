package com.sever.caching.utils

import com.sever.caching.R
import com.sever.caching.entities.CollectionEventEntity
import com.sever.caching.entities.CollectionHeaderEntity
import com.sever.caching.interfaces.CollectionListItemInterface

object CollectionList {
    fun getList(): List<CollectionListItemInterface> {
        return mutableListOf<CollectionListItemInterface>().apply {
            add(CollectionHeaderEntity("Загружены", 16))
            repeat(10) {
                add(CollectionEventEntity("Alpha", 3, R.drawable.alpha))
                add(CollectionEventEntity("Firewatch", 4, R.drawable.firewatch))
            }
            add(CollectionHeaderEntity("Не загружены", 16))
            repeat(30) {
                add(CollectionEventEntity("Highway", 3, R.drawable.highway))
                add(CollectionEventEntity("Alpha", 3, R.drawable.alpha))
                add(CollectionEventEntity("Firewatch", 4, R.drawable.firewatch))
            }
        }
    }
}