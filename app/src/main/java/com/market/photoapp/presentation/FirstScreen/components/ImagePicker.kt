package com.market.photoapp.presentation.FirstScreen.components

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.market.photoapp.presentation.FirstScreen.Util

@Composable
fun PickImageFromGallery(firstImage: Uri?,
    selectedImage: (Uri?) ->Unit
) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var context = LocalContext.current
    val bitmap = remember { mutableStateOf<Bitmap?>(null) }
    if(firstImage.toString().isNotEmpty()){
        imageUri = firstImage
    }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri = uri
        selectedImage(uri)
    }

    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        imageUri?.let {
            if(Build.VERSION.SDK_INT < 28){
                bitmap.value = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
            }else{
                val source = ImageDecoder.createSource(context.contentResolver, it)
                bitmap.value = ImageDecoder.decodeBitmap(source)
            }
            bitmap.value?.let {
                    btm ->
                Image(
                    bitmap = btm.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .padding(20.dp)
                )

            }
        }
        Spacer(modifier = Modifier.height(12.dp))

        Button(modifier = Modifier.padding(start = 2.dp, end = 2.dp),
            onClick = {
            launcher.launch("image/*")
        }) {
            Text(text = "Please pick an image")
        }
    }
}
