package com.market.photoapp.presentation.FirstScreen

sealed class Events {
    data class numberPicked(val numberLimit: Int): Events()
    data class firstImagePicked(val firstImage:String): Events()
    data class secondEventPicked(val secondImage:String): Events()
}