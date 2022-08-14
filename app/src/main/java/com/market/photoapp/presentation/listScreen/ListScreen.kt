package com.market.photoapp.presentation

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.market.photoapp.presentation.FirstScreen.Util
import com.market.photoapp.presentation.listScreen.isPermissionDenied


@OptIn(ExperimentalFoundationApi::class, ExperimentalPermissionsApi::class)
@Composable
fun ListScreen(numberLimit: Int, firstPhoto: String, secondPhoto: String) {

    val arraylist = Util.getNumberArrayList(numberLimit = numberLimit)
    MainScreen(
        numberLimit = numberLimit,
        arraylist = arraylist,
        firstPhoto = firstPhoto,
        secondPhoto = secondPhoto
    )

}


@Composable
fun MainScreen(
    numberLimit: Int,
    arraylist: ArrayList<Int>,
    firstPhoto: String,
    secondPhoto: String
) {

    val context = LocalContext.current
    val bitmapFirst = remember { mutableStateOf<Bitmap?>(null) }
    val bitmapSecond = remember { mutableStateOf<Bitmap?>(null) }

    val firstPhotoUri = firstPhoto.replace("image:", "image%3A").toUri()
    val secondPhotoUri = secondPhoto.replace("image:", "image%3A").toUri()

    Log.d("photo", "$firstPhotoUri")
    Log.d("photo2", "$secondPhotoUri")

    firstPhotoUri.let {
        if (Build.VERSION.SDK_INT < 28) {
            bitmapFirst.value = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
        } else {
            val source = ImageDecoder.createSource(context.contentResolver, it)
            bitmapFirst.value = ImageDecoder.decodeBitmap(source)
        }
    }
    secondPhotoUri.let {
        if (Build.VERSION.SDK_INT < 28) {
            bitmapSecond.value = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
        } else {
            val source = ImageDecoder.createSource(context.contentResolver, it)
            bitmapSecond.value = ImageDecoder.decodeBitmap(source)
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            FlowRow(
                mainAxisSize = SizeMode.Expand,
                mainAxisAlignment = FlowMainAxisAlignment.SpaceEvenly
            ) {
                for (i in 1..numberLimit) {
                    if (arraylist.contains(i)) {
                        Image(
                            bitmap = bitmapFirst.value!!.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .size(200.dp)
                                .padding(20.dp)
                        )
                    } else {
                        Image(
                            bitmap = bitmapSecond.value!!.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .size(200.dp)
                                .padding(20.dp)
                        )
                    }
                    Text(text = "$i", textAlign = TextAlign.Center)
                }

            }

        }
    }
}


