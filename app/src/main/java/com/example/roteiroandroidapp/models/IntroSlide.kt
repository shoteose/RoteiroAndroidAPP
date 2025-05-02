package com.example.roteiroandroidapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class IntroSlide(
    val imagem: Int,
    val titulo: String,
    val descricao: String
) : Parcelable