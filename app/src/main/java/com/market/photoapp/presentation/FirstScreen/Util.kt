package com.market.photoapp.presentation.FirstScreen

import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream


class Util {
    companion object {

        fun getNumberArrayList(numberLimit: Int): ArrayList<Int> {
            val arraylist = ArrayList<Int>()
            var j = 1
            for (i in 1..numberLimit step 1) {
                arraylist.add(j)
                j += i + 1
                if (j > numberLimit)
                    break
            }
            return arraylist
        }

    }
}