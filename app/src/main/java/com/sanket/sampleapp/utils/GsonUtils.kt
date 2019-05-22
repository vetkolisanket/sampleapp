package com.sanket.sampleapp.utils

import com.google.gson.GsonBuilder
import java.lang.reflect.Type

/**
 * Created by Sanket on 22/05/19.
 */
object GsonUtils {

    val gson by unsafeLazy { GsonBuilder().create() }

    fun <T : Any> getObjectFromJson(responseBody: String, classType: Class<T>): T? {
        try {
            return gson.fromJson(responseBody, classType)
        } catch (e: Exception) {
            e.printStackTrace()
//            Crashlytics.logException(Throwable(responseBody, e))
            return null
        }
    }

    fun <T : Any> getObjectFromJson(responseBody: String, classType: Type): T? {
        try {
            return gson.fromJson(responseBody, classType)
        } catch (e: Exception) {
            e.printStackTrace()
//            Crashlytics.logException(Throwable(responseBody, e))
            return null
        }
    }

    fun getJsonString(`object`: Any): String {
        return gson.toJson(`object`).toString()
    }

    /*fun getGsonFactory(): Converter.Factory {
        return GsonConverterFactory.create(getGson())
    }*/

}