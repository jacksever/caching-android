package com.sever.caching.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sever.caching.entities.CollectionEventEntity
import com.sever.caching.entities.CollectionHeaderEntity
import com.sever.caching.interfaces.CollectionListItemInterface

class LibraryWallpaperPagerAdapter(
    private val models: List<CollectionListItemInterface>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return models[position].type()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LibraryViewHolderFactory.create(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            CollectionListItemInterface.TYPE_HEADER -> {
                holder as LibraryViewHolderFactory.LibraryHeaderViewHolder
                val item = models[position] as CollectionHeaderEntity
                holder.run {
                    bind(item)
                }
            }

            CollectionListItemInterface.TYPE_EVENT -> {
                holder as LibraryViewHolderFactory.LibraryWallpaperViewHolder
                val item = models[position] as CollectionEventEntity
                holder.run {
                    bind(item)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return models.size
    }
}