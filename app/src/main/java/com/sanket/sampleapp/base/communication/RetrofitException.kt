package com.sanket.sampleapp.base.communication

import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException

/**
 * Created by Sanket on 11/05/19.
 */
class RetrofitException(
    override val message: String?,
    private val url: String?,
    private val response: Response<Any>?,
    private val kind: Kind,
    private val exception: Throwable?,
    private val retrofit: Retrofit?
) : RuntimeException(message, exception) {

    fun httpError(url: String, response: Response<Any>, retrofit: Retrofit): RetrofitException {
        val message = response.code().toString() + " " + response.message()
        return RetrofitException(message, url, response, Kind.HTTP, null, retrofit)
    }

    fun networkError(exception: IOException): RetrofitException {
        return RetrofitException(exception.message, null, null, Kind.NETWORK, exception, null)
    }

    fun unexpectedError(exception: Throwable): RetrofitException {
        return RetrofitException(exception.message, null, null, Kind.UNEXPECTED, exception, null)
    }

    /** Identifies the event kind which triggered a [RetrofitException].  */
    enum class Kind {
        /** An [IOException] occurred while communicating to the server.  */
        NETWORK,
        /** A non-200 HTTP status code was received from the server.  */
        HTTP,
        /**
         * An internal error occurred while attempting to execute a request. It is best practice to
         * re-throw this exception so your application crashes.
         */
        UNEXPECTED
    }

    /** The request URL which produced the error.  */
    fun getUrl(): String? {
        return url
    }

    /** Response object containing status code, headers, body, etc.  */
    fun getResponse(): Response<Any>? {
        return response
    }

    /** The event kind which triggered this error.  */
    fun getKind(): Kind {
        return kind
    }

    /** The Retrofit this request was executed on  */
    fun getRetrofit(): Retrofit? {
        return retrofit
    }

    /**
     * HTTP response body converted to specified `type`. `null` if there is no
     * response.
     *
     * @throws IOException if unable to convert the body to the specified `type`.
     */
    @Throws(IOException::class)
    fun <T> getErrorBodyAs(type: Class<T>): T? {
        if (response?.errorBody() == null) {
            return null
        }
        //        Converter<ResponseBody, T> converter = retrofit.responseConverter(type, new Annotation[0]);
        val converter = retrofit!!.responseBodyConverter<T>(type, arrayOfNulls<Annotation>(0))
        return converter.convert(response.errorBody())
    }

}