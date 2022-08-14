package com.market.photoapp.presentation.FirstScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.chargemap.compose.numberpicker.NumberPicker

@Composable
fun ListLength(
    setNumber : Int?,
    listLength: (Int) -> Unit) {
    var pickerValue by remember {
        mutableStateOf(0)
    }
    Column (horizontalAlignment = Alignment.CenterHorizontally ){
        Text(text = "Please pick the size of the list")
        NumberPicker(modifier = Modifier.fillMaxWidth(), value = setNumber!!,onValueChange = {
            pickerValue = it
            listLength(pickerValue)
        }, range = 1..100)
    }

}