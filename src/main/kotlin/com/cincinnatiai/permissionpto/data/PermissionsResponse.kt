package com.cincinnatiai.permissionpto.data

data class PermissionsResponse(
    val isAllowed: Boolean = false,
    val reason: String = ""
)