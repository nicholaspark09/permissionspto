package com.cincinnatiai.permissionpto


import com.cincinnatiai.permissionpto.api.PermissionsApi
import com.cincinnatiai.permissionpto.repository.PermissionsRepository
import com.cincinnatiai.permissionpto.repository.PermissionsRepositoryContract
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PermissionsLibrary private constructor(
    private val url: String,
    private val apiKey: String? = null
) {

    private val okHttp: OkHttpClient by lazy {
        OkHttpClient.Builder().apply {
            if (apiKey != null) {
            } // TODO add api key interceptor later
        }.build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(okHttp)
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val api: PermissionsApi = retrofit.create(PermissionsApi::class.java)

    val permissionsRepo: PermissionsRepositoryContract by lazy {
        PermissionsRepository(api)
    }

    companion object {
        @Volatile
        var INSTANCE: PermissionsLibrary? = null

        fun init(url: String, apiKey: String? = null) {
            if (INSTANCE == null) {
                synchronized(this) {
                    if (INSTANCE == null) {
                        INSTANCE = PermissionsLibrary(url, apiKey)
                    }
                }
            }
        }

        fun instance() = INSTANCE ?: throw java.lang.IllegalArgumentException("Must be initialized with url first")
    }
}