package com.sever.caching.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sever.caching.adapters.LibraryWallpaperPagerAdapter
import com.sever.caching.databinding.ActivityMainBinding
import com.sever.caching.utils.CollectionList
import com.sever.caching.utils.FontCache

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.cardList) {
            adapter = LibraryWallpaperPagerAdapter(CollectionList.getList())
        }
    }

    override fun onDestroy() {
        FontCache.clear()
        super.onDestroy()
    }
}