package com.sever.caching.utils

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import java.util.Hashtable

object FontCache {
    @JvmStatic
    private val cacheFonts = Hashtable<String, Typeface>()
    private const val tag = "FontCache"

    fun get(context: Context, name: String): Typeface? {
        if (!cacheFonts.containsKey(name)) {
            saveFontToCache(context, name)
        }
        return cacheFonts[name]
    }

    private fun saveFontToCache(context: Context, name: String) {
        val path = "fonts/$name.ttf"
        try {
            val t = Typeface.createFromAsset(context.assets, path)
            cacheFonts[name] = t
        } catch (e: Exception) {
            Log.e(tag, "Failed to load font")
        }
    }

    fun contains(name: String): Boolean {
        return cacheFonts.containsKey(name)
    }

    fun clear() {
        cacheFonts.clear()
    }
}