package com.example.assignment3_cs388_christopherlarena.data

import com.google.gson.annotations.SerializedName

data class Onboarding(
    @SerializedName("title") val title: String?,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("overview") val description: String?
)
