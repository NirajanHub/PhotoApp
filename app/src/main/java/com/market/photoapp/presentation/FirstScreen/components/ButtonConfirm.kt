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
    Button(onClick = {
        if (viewModel.numberLimit > 1 && viewModel.firstImage!!.length > 20 && viewModel.secondImage!!.length > 20) {
        navController.navigate(
            Screens.ListScreen.route +
                    "?numberLimit=${viewModel.numberLimit}&firstPhoto=${viewModel.firstImage}&secondPhoto=${viewModel.secondImage}"
        )
    }else{
        Toast.makeText(context,"Please insert Photos and number limit",Toast.LENGTH_LONG).show()
        }
    }) {
        Text(text = "Generate List")
    }
}