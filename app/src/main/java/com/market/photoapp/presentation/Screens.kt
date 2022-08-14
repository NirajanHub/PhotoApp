package com.market.photoapp.presentation

sealed class Screens(val route: String) {
    object FirstScreen: Screens("first_screen")
    object ListScreen: Screens("list_screen")
}
