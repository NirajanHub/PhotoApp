package com.market.photoapp.presentation.FirstScreen

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class UtilTest {
    @Test
   fun `test the triangular number pattern`(){
        val arrayList = Util.getNumberArrayList(21)
        val rightArrayList = listOf<Int>(1,3,6,10,15,21)
        assertThat(arrayList).isEqualTo(rightArrayList)
    }
}