package com.sever.caching.adapters

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sever.caching.databinding.CardLibraryWindowEventBinding
import com.sever.caching.databinding.CardLibraryWindowHeaderBinding
import com.sever.caching.entities.CollectionEventEntity
import com.sever.caching.entities.CollectionHeaderEntity
import com.sever.caching.interfaces.CollectionListItemInterface

object LibraryViewHolderFactory {
    fun create(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CollectionListItemInterface.TYPE_EVENT -> LibraryWallpaperViewHolder(
                CardLibraryWindowEventBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> {
                LibraryHeaderViewHolder(
                    CardLibraryWindowHeaderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    class LibraryHeaderViewHolder(private val binding: CardLibraryWindowHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CollectionHeaderEntity) {
            binding.stateText.text = item.title
            binding.stateText.setTextSize(TypedValue.COMPLEX_UNIT_SP, item.size.toFloat())
        }
    }

    class LibraryWallpaperViewHolder(private val binding: CardLibraryWindowEventBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CollectionEventEntity) {
            binding.name.text = item.text
            binding.image.setImageResource(item.image)
            binding.time.text = "Каждые ${item.time} часа"
        }
    }
}