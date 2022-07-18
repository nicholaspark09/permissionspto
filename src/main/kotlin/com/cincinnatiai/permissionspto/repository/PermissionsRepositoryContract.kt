package com.cincinnatiai.permissionspto.repository

import com.cincinnatiai.permissionspto.data.PermissionsRequest
import com.cincinnatiai.permissionspto.data.PermissionsResponse

interface PermissionsRepositoryContract {

    suspend fun hasPermission(request: PermissionsRequest): PermissionsResponse

}