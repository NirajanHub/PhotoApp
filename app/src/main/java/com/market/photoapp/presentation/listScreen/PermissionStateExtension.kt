package com.market.photoapp.presentation.listScreen

import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState

@OptIn(ExperimentalPermissionsApi::class)
fun PermissionState.isPermissionDenied() : Boolean{
 return !shouldShowRationale && !hasPermission
}