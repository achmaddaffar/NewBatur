package com.daffa.batur.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.daffa.batur.R
import com.daffa.batur.data.models.User
import com.daffa.batur.presentation.components.CoinSection
import com.daffa.batur.presentation.components.UserLevelSection
import com.daffa.batur.presentation.ui.theme.IconSizeLarge
import com.daffa.batur.presentation.ui.theme.IconSizeUltra
import com.daffa.batur.presentation.ui.theme.Primary500
import com.daffa.batur.presentation.ui.theme.Primary600
import com.daffa.batur.presentation.ui.theme.SpaceExtraSmall
import com.daffa.batur.presentation.ui.theme.SpaceLarge
import com.daffa.batur.presentation.ui.theme.SpaceSmall

@Composable
fun ProfileSectionCard(
    user: User,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Primary600)
                .padding(SpaceLarge)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = user.username,
                        style = MaterialTheme.typography.body1.copy(
                            color = Color.White,
                            fontSize = 24.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(SpaceExtraSmall))
                    Text(
                        text = user.email,
                        style = MaterialTheme.typography.body2.copy(
                            color = Color.White
                        )
                    )
                    Spacer(modifier = Modifier.height(SpaceSmall))
                    CoinSection(user = user)
                }
                Image(
                    painter = painterResource(id = R.drawable.profile_picture_default),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(IconSizeUltra)
                        .clip(CircleShape),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(SpaceSmall))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Primary500)
                        .padding(SpaceSmall)
                ) {
                    UserLevelSection(user = user)
                }
            }
        }
    }
}