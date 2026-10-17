package com.lauravoetzsch.deeplinksapp.data

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class Article(
    val id: Int = -1,
    val name: String = "",
    val date: String = "",
    val website: String = "",
    @DrawableRes val drawable: Int = -1
)