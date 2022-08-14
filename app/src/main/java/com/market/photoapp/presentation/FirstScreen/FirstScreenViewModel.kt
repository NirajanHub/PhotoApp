package com.market.photoapp.presentation.FirstScreen

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstScreenViewModel @Inject constructor() : ViewModel() {

    private var _firstImage = mutableStateOf<Uri?>(null)
    private var _secondImage = mutableStateOf<Uri?>(null)
    private var _numberLimit = mutableStateOf<Int?>(0)

     var firstImage = _firstImage
     var secondImage = _secondImage
     var numberLimit = _numberLimit

    fun onEvent(events: Events) {
        when (events) {
            is Events.firstImagePicked -> {
                _firstImage.value = events.firstImage
            }
            is Events.secondEventPicked -> {
                _secondImage.value = events.secondImage
            }
            is Events.numberPicked -> {
                _numberLimit.value = events.numberLimit
            }
        }
    }
}