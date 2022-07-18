package com.cincinnatiai.permissionspto.data

data class PermissionsResponse(
    val isAllowed: Boolean = false,
    val reason: String = ""
)