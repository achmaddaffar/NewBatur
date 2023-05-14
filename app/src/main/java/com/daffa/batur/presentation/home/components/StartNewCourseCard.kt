package com.daffa.batur.presentation.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Icon
import com.daffa.batur.R
import com.daffa.batur.presentation.ui.theme.IconSizeExtra
import com.daffa.batur.presentation.ui.theme.IconSizeExtraLarge
import com.daffa.batur.presentation.ui.theme.IconSizeLarge
import com.daffa.batur.presentation.ui.theme.IconSizeSmall
import com.daffa.batur.presentation.ui.theme.IconSizeUltra
import com.daffa.batur.presentation.ui.theme.Primary200
import com.daffa.batur.presentation.ui.theme.Primary300
import com.daffa.batur.presentation.ui.theme.Primary400
import com.daffa.batur.presentation.ui.theme.Primary500
import com.daffa.batur.presentation.ui.theme.Primary600
import com.daffa.batur.presentation.ui.theme.Primary800
import com.daffa.batur.presentation.ui.theme.SpaceExtraLarge
import com.daffa.batur.presentation.ui.theme.SpaceLarge
import com.daffa.batur.presentation.ui.theme.SpaceMedium
import com.daffa.batur.presentation.ui.theme.SpaceUltraLarge

@Composable
fun StartNewCourseCard(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    cardHeight: Dp = 100.dp
) {
    BoxWithConstraints(
        modifier = modifier
            .height(cardHeight)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = shape,
            backgroundColor = Primary200,
            elevation = 5.dp
        ) {
            Canvas(
                modifier = Modifier
                    .size(IconSizeUltra)
                    .offset(
                        x = minWidth / 2.5f,
                        y = minWidth / 5
                    )
            ) {
                drawCircle(
                    color = Primary600,
                    radius = 175f
                )
            }
            Canvas(
                modifier = Modifier
                    .size(IconSizeSmall)
                    .offset(
                        x = minWidth / 5f,
                        y = minWidth / 8
                    )
            ) {
                drawCircle(
                    color = Primary400,
                    radius = 50f
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpaceMedium),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = stringResource(R.string.mulai_kursus_baru),
                        style = MaterialTheme.typography.body1
                    )
                    Spacer(modifier = Modifier.height(SpaceMedium))
                    Button(
                        onClick = {}
                    ) {
                        Text(
                            text = stringResource(R.string.pilih_kursus),
                            style = MaterialTheme.typography.body2.copy(
                                color = Color.White
                            )
                        )
                    }
                }
                IconButton(
                    onClick = {},
                    modifier = Modifier.offset(
                        x = -SpaceMedium,
                        y = -SpaceMedium
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.next_arrow),
                        contentDescription = stringResource(R.string.start_new_course),
                        tint = Primary800,
                        modifier = Modifier
                            .size(IconSizeExtra)
                    )
                }
            }
        }
    }
}