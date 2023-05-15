package com.daffa.batur.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import com.daffa.batur.data.models.User
import com.daffa.batur.presentation.ui.theme.Secondary600
import com.daffa.batur.presentation.ui.theme.Slate900
import com.daffa.batur.presentation.ui.theme.SpaceExtraSmall
import com.daffa.batur.presentation.ui.theme.SpaceSmall

@Composable
fun UserLevelSection(
    user: User,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        val level = buildAnnotatedString {
            append("LV. ")
            append(user.level.toString())
        }
        Text(
            text = level,
            style = MaterialTheme.typography.body1.copy(
                color = Color.White
            )
        )
        Spacer(modifier = Modifier.width(SpaceSmall))
        UserLevelIndicator(
            user = user,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun UserLevelIndicator(
    user: User,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Slate900,
    indicatorColor: Color = Secondary600,
    indicatorWidth: Dp = 130.dp,
    addedWidth: Int = 70
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .background(backgroundColor)
                .width(indicatorWidth + addedWidth.dp),
        ) {
            Row(
                modifier = Modifier
                    .background(indicatorColor)
                    .width((indicatorWidth + addedWidth.dp) * (user.currentXp + addedWidth) / (user.maxXp + addedWidth))
                    .padding(SpaceExtraSmall),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val level = buildAnnotatedString {
                    append(user.currentXp.toString())
                    append("/")
                    append(user.maxXp.toString())
                    append(" XP")
                }
                Text(
                    text = level,
                    style = MaterialTheme.typography.body2.copy(
                        color = Slate900
                    )
                )
            }
        }
    }
}