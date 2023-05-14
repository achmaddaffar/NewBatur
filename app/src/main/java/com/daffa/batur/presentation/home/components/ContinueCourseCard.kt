package com.daffa.batur.presentation.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Icon
import com.daffa.batur.R
import com.daffa.batur.presentation.ui.theme.IconSizeExtra
import com.daffa.batur.presentation.ui.theme.IconSizeSmall
import com.daffa.batur.presentation.ui.theme.IconSizeUltra
import com.daffa.batur.presentation.ui.theme.Secondary200
import com.daffa.batur.presentation.ui.theme.Secondary600
import com.daffa.batur.presentation.ui.theme.Slate800
import com.daffa.batur.presentation.ui.theme.Slate900
import com.daffa.batur.presentation.ui.theme.SpaceMedium

@Composable
fun ContinueCourseCard(
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
            backgroundColor = Secondary200,
            elevation = 5.dp
        ) {
            Canvas(
                modifier = Modifier
                    .size(IconSizeUltra)
                    .offset(
                        x = minWidth / 3,
                        y = -minWidth / 10
                    )
            ) {
                drawCircle(
                    color = Secondary600,
                    radius = 175f
                )
            }
            Canvas(
                modifier = Modifier
                    .size(IconSizeSmall)
                    .offset(
                        x = minWidth / 6.5f,
                        y = minWidth / 10
                    )
            ) {
                drawCircle(
                    color = Slate800,
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
                        text = stringResource(R.string.lanjutkan_kursus),
                        style = MaterialTheme.typography.body1
                    )
                    Spacer(modifier = Modifier.height(SpaceMedium))
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Secondary600
                        )
                    ) {
                        Text(
                            text = stringResource(R.string.lanjutkan),
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
                        tint = Slate900,
                        modifier = Modifier
                            .size(IconSizeExtra)
                    )
                }
            }
        }
    }
}