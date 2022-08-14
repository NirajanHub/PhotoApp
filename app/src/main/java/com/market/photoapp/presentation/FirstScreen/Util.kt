package com.market.photoapp.presentation.FirstScreen

import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream


class Util {
    companion object {
        fun convert(bitmap: Bitmap?): String? {
            val outputStream = ByteArrayOutputStream()
            bitmap?.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            return Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT)
        }

        fun getNumberArrayList(numberLimit: Int): ArrayList<Int> {
            val arraylist = ArrayList<Int>()
            var j = 1
            for (i in 1..numberLimit step 1) {
                if (j >= numberLimit)
                    break
                arraylist.add(j)
                print(" j : $j")
                print(" i : $i")
                j += i + 1
            }
            return arraylist
        }

    }
}