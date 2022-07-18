package com.cincinnatiai.permissionspto.data

data class PermissionsRequest(
    val userId: String,
    val teamId: String,
    val action: String
)