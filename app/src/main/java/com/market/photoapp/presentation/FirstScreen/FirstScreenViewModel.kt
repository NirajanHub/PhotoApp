package com.market.photoapp.presentation.FirstScreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FirstScreenViewModel @Inject constructor() :ViewModel() {

       var firstImage = ""
       var secondImage = ""
       var numberLimit = 1

   fun onEvent(events: Events){
       when(events){
           is Events.firstImagePicked ->{
               firstImage = events.firstImage
           }
           is Events.secondEventPicked ->{
               secondImage = events.secondImage
           }
           is Events.numberPicked -> {
               numberLimit = events.numberLimit
           }
       }
   }
}