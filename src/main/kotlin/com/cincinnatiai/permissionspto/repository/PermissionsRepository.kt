package com.cincinnatiai.permissionspto.repository

import com.cincinnatiai.permissionspto.api.PermissionsApi
import com.cincinnatiai.permissionspto.data.PermissionsRequest
import com.cincinnatiai.permissionspto.data.PermissionsResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PermissionsRepository(
    private val api: PermissionsApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : PermissionsRepositoryContract {

    override suspend fun hasPermission(request: PermissionsRequest): PermissionsResponse =
        withContext(dispatcher) {
            try {
                when (val response =
                    api.hasPermission(request.userId, request.action, request.teamId)) {
                    null -> throw IllegalArgumentException("There was no permissions response")
                    else -> response
                }
            } catch (e: Throwable) {
                e.printStackTrace()
                throw e
            }
        }

}