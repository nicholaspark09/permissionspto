package com.cincinnatiai.permissionpto.api

import com.cincinnatiai.permissionpto.data.PermissionsRequest
import com.cincinnatiai.permissionpto.data.PermissionsResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface PermissionsApi {

    @POST("teampermissions")
    suspend fun hasPermission(@Body request: PermissionsRequest): PermissionsResponse?
}