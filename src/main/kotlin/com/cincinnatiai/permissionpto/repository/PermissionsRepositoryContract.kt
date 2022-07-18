package com.cincinnatiai.permissionpto.repository

import com.cincinnatiai.permissionpto.data.PermissionsRequest
import com.cincinnatiai.permissionpto.data.PermissionsResponse

interface PermissionsRepositoryContract {

    suspend fun hasPermission(request: PermissionsRequest): PermissionsResponse

}