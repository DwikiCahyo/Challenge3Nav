package com.dwiki.wordappnav.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Alphabet(
    val alphabetName:String,
    val firstItem:String,
    val secondItem:String,
    val thirdItem:String,
    val imgAlphabet:Int
):Parcelable
