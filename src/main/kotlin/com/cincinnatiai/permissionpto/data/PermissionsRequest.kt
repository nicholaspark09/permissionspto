package com.cincinnatiai.permissionpto.data

data class PermissionsRequest(
    val userId: String,
    val teamId: String,
    val action: String
)