package com.market.photoapp.presentation

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.market.photoapp.presentation.FirstScreen.Events
import com.market.photoapp.presentation.FirstScreen.FirstScreenViewModel
import com.market.photoapp.presentation.FirstScreen.Values

import androidx.hilt.navigation.compose.hiltViewModel
import com.market.photoapp.presentation.FirstScreen.components.ButtonConfirm
import com.market.photoapp.presentation.FirstScreen.components.ListLength
import com.market.photoapp.presentation.FirstScreen.components.PickImageFromGallery
import dagger.hilt.android.internal.lifecycle.HiltViewModelMap

@HiltViewModelMap
@Composable
fun FirstScreen(

    navController: NavController,
    viewModel: FirstScreenViewModel = hiltViewModel()) {

    val values = Values("","",0)
    var firstImage by remember { mutableStateOf<Uri?>(null) }
    var secondImage by remember { mutableStateOf<Uri?>(null) }
    var numberLimit by remember { mutableStateOf<Int?>(null) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.verticalScroll(rememberScrollState()).fillMaxSize()
    ) {
        Row(
            Modifier.height(400.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            PickImageFromGallery (viewModel.firstImage.value){
                firstImage = it
                viewModel.onEvent(Events.firstImagePicked(it))
            }
            PickImageFromGallery(viewModel.secondImage.value){
                secondImage = it
                viewModel.onEvent(Events.secondEventPicked(it))
            }
        }
        ListLength(viewModel.numberLimit.value){
            numberLimit = it
            viewModel.onEvent(Events.numberPicked(it))
        }
        ButtonConfirm(navController,  viewModel = viewModel)
    }

}
