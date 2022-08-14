package com.market.photoapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    var firstImage by remember { mutableStateOf<String?>(null) }
    var secondImage by remember { mutableStateOf<String?>(null) }
    var numberLimit by remember { mutableStateOf<Int?>(null) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            Modifier.height(200.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PickImageFromGallery{
                firstImage = it.toString()
                viewModel.onEvent(Events.firstImagePicked(it.toString()))
            }
            PickImageFromGallery{
                secondImage = it.toString()
                viewModel.onEvent(Events.secondEventPicked(it.toString()))
            }
        }
        ListLength{
            numberLimit = it
            viewModel.onEvent(Events.numberPicked(it))
        }
        ButtonConfirm(navController,  viewModel = viewModel)
    }

}
