package com.daffa.batur.presentation.game_map.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.daffa.batur.R
import com.daffa.batur.data.models.User
import com.daffa.batur.presentation.ui.theme.IconSizeExtra
import com.daffa.batur.presentation.ui.theme.IconSizeMedium
import com.daffa.batur.presentation.ui.theme.Primary300
import com.daffa.batur.presentation.ui.theme.Secondary600
import com.daffa.batur.presentation.ui.theme.SpaceExtraSmall

@Composable
fun CoinSection(
    user: User,
    modifier: Modifier = Modifier,
    onSectionClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .clickable {
                onSectionClick()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.coin_icon),
            contentDescription = stringResource(R.string.coin_icon),
            tint = Secondary600,
            modifier = Modifier.size(IconSizeMedium)
        )
        Spacer(modifier = Modifier.width(SpaceExtraSmall))
        Text(
            text = user.coin.toString(),
            style = MaterialTheme.typography.body1.copy(
                color = Color.White
            )
        )
        Spacer(modifier = Modifier.width(SpaceExtraSmall))
        Icon(
            painter = painterResource(id = R.drawable.plus_icon),
            contentDescription = stringResource(R.string.tambah_coin),
            tint = Primary300,
            modifier = Modifier.width(IconSizeExtra)
        )
    }
}