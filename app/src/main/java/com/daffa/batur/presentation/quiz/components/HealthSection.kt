package com.daffa.batur.presentation.quiz.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.wear.compose.material.Icon
import com.daffa.batur.R
import com.daffa.batur.presentation.ui.theme.IconSizeMedium
import com.daffa.batur.presentation.ui.theme.Primary600
import com.daffa.batur.presentation.ui.theme.SpaceExtraSmall

@Composable
fun HealthSection(
    modifier: Modifier = Modifier,
    currentHealth: Int = 3,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.End
    ) {
        items(currentHealth) {
            Icon(
                painter = painterResource(id = R.drawable.health_icon),
                contentDescription = "Nyawa",
                tint = Primary600,
                modifier = Modifier.size(IconSizeMedium)
            )
            Spacer(modifier = Modifier.width(SpaceExtraSmall))
        }
    }
}