package com.sanket.sampleapp.application

import android.util.LruCache

/**
 * Created by Sanket on 02/05/19.
 */
object AppCache {

    private val lruCache = LruCache<String, Any>(80)

    operator fun get(key: String): Any {
        return lruCache.get(key)
    }

    fun put(key: String, value: Any) {
        lruCache.put(key, value)
    }

    fun remove(key: String) {
        lruCache.remove(key)
    }

    fun clear() {
        lruCache.evictAll()
    }
}
