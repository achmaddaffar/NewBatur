package com.daffa.batur.presentation.game_map.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.daffa.batur.R
import com.daffa.batur.data.models.User
import com.daffa.batur.presentation.components.CoinSection
import com.daffa.batur.presentation.components.UserLevelSection
import com.daffa.batur.presentation.ui.theme.Primary600
import com.daffa.batur.presentation.ui.theme.Primary700
import com.daffa.batur.presentation.ui.theme.SpaceExtraSmall
import com.daffa.batur.presentation.ui.theme.SpaceLarge
import com.daffa.batur.presentation.ui.theme.SpaceMedium
import com.daffa.batur.presentation.ui.theme.SpaceSmall

@Composable
fun MapTopBanner(
    user: User,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Primary700)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Primary600)
                .padding(
                    horizontal = SpaceLarge,
                    vertical = SpaceMedium
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            UserLevelSection(
                user = user,
                modifier = Modifier.fillMaxWidth(0.6f)
            )
            CoinSection(
                user = user,
                modifier = Modifier
                    .fillMaxWidth(0.4f)
            )
        }
        Spacer(modifier = Modifier.height(SpaceExtraSmall))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Primary600)
                .padding(
                    horizontal = SpaceLarge,
                    vertical = SpaceMedium
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                // SUKU
                Text(
                    text = "UNIT 8",
                    style = MaterialTheme.typography.body1.copy(
                        color = Color.White
                    )
                )
                Spacer(modifier = Modifier.height(SpaceSmall))
                // Pelajaran
                Text(
                    text = "Kesenian Suku Sunda",
                    style = MaterialTheme.typography.body2.copy(
                        color = Color.White
                    )
                )
            }
            Card(
                modifier = Modifier
                    .background(Primary700)
                    .padding(SpaceExtraSmall)
                    .background(Primary600),
                shape = MaterialTheme.shapes.small
            ) {
                IconButton(
                    onClick = {},
                    Modifier.background(Primary600)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.hamburger_list_icon),
                        contentDescription = "Daftar Level",
                        tint = Color.White,
                    )
                }
            }
        }
    }
}