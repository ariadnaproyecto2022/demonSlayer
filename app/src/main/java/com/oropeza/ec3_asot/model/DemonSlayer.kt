package com.oropeza.ec3_asot.model

import com.google.gson.annotations.SerializedName

data class DemonSlayer(
    val image: String,
    @SerializedName("url")
    val url: String,
    val name: String,
    val race: String,
    val gender: String,
    val height: String,
    @SerializedName("hair color")
    val hair_color: String,
    @SerializedName("eye color ")
    val eye_color: String,
    val affiliation: String,
    val occupation: String,
    @SerializedName("combat style")
    val combat_style: String,
)
