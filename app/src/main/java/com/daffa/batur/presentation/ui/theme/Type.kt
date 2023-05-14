package com.daffa.batur.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.daffa.batur.R

val rocko = FontFamily(
    Font(R.font.rocko, FontWeight.Normal),
    Font(R.font.rocko_bold, FontWeight.Bold)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = rocko,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Slate900
    ),
    body2 = TextStyle(
        fontFamily = rocko,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Slate400
    ),
    h1 = TextStyle(
        fontFamily = rocko,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        color = Slate900
    ),
    h2 = TextStyle(
        fontFamily = rocko,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = Color.White
    )
)