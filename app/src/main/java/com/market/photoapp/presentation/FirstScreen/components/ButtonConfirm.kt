package com.market.photoapp.presentation.FirstScreen.components

import android.util.Log
import android.widget.Toast
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.market.photoapp.presentation.FirstScreen.FirstScreenViewModel
import com.market.photoapp.presentation.Screens

@Composable
fun ButtonConfirm(navController: NavController,viewModel: FirstScreenViewModel) {

    val context = LocalContext.current
    Log.d("values" , viewModel.numberLimit.toString())
    Log.d("values" , viewModel.firstImage.toString())
    Log.d("values" , viewModel.secondImage.toString())
    val firstImage = viewModel.firstImage.value.toString()
    val secondImage = viewModel.secondImage.value.toString()
    val numberLimit : Int = viewModel.numberLimit.value!!
    Button(onClick = {
        if (numberLimit > 1 && firstImage.length > 20 && secondImage.length > 20) {
        navController.navigate(
            Screens.ListScreen.route +
                    "?numberLimit=${numberLimit}&firstPhoto=${firstImage}&secondPhoto=${secondImage}"
        )
    }else{
        Toast.makeText(context,"Please insert Photos and number limit",Toast.LENGTH_LONG).show()
        }
    }) {
        Text(text = "Generate List")
    }
}