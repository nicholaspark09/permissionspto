package com.cincinnatiai.permissionspto.api

import com.cincinnatiai.permissionspto.data.PermissionsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PermissionsApi {

    @GET("teampermissions")
    suspend fun hasPermission(
        @Query("userId") userId: String,
        @Query("action") action: String,
        @Query("teamId") teamId: String
    ): PermissionsResponse?
}