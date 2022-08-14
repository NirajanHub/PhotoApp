package com.market.photoapp.presentation.FirstScreen

import android.net.Uri

sealed class Events {
    data class numberPicked(val numberLimit: Int): Events()
    data class firstImagePicked(val firstImage:Uri?): Events()
    data class secondEventPicked(val secondImage:Uri?): Events()
}