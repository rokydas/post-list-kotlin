package com.example.retrofit

import com.google.gson.annotations.SerializedName

data class MyDataItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)