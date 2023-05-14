package com.daffa.batur.presentation.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.daffa.batur.R
import com.daffa.batur.presentation.ui.theme.IconSizeLarge
import com.daffa.batur.presentation.ui.theme.IconSizeUltra
import com.daffa.batur.presentation.ui.theme.Primary500
import com.daffa.batur.presentation.ui.theme.Primary600
import com.daffa.batur.presentation.ui.theme.Secondary600
import com.daffa.batur.presentation.ui.theme.SpaceLarge
import com.daffa.batur.presentation.ui.theme.SpaceMedium

@Composable
fun TopBanner(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(
        bottomStart = SpaceMedium,
        bottomEnd = SpaceMedium
    ),
    mascotSize: Dp = 150.dp,
    createAccountButtonOnClick: () -> Unit = {}
) {
    Card(
        modifier = modifier,
        shape = shape,
        elevation = 5.dp
    ) {
        BoxWithConstraints {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                Secondary600,
                                Primary600
                            ),
                            center = Offset(
                                x = constraints.maxWidth * 0.8f,
                                y = constraints.maxHeight.toFloat()
                            ),
                            radius = maxWidth.value * 3.8f
                        )
                    )
                    .padding(SpaceLarge)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.batur_logo),
                    contentDescription = stringResource(id = R.string.batur_logo),
                    modifier = Modifier.height(IconSizeLarge),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                Card(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    BoxWithConstraints(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Primary600)
                            .padding(SpaceMedium)
                    ) {
                        Canvas(modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(IconSizeUltra * 3)
                        ) {
                            drawCircle(
                                color = Primary500,
                                radius = maxWidth.value,
                                center = Offset(
                                    x = constraints.maxWidth.toFloat() * 0.6f,
                                    y = constraints.maxHeight.toFloat() * 0.85f
                                )
                            )
                        }
                        Column(
                            modifier = Modifier
                                .align(Alignment.TopStart)
                        ) {
                            Text(
                                text = "Buat Akun Yuk!",
                                style = MaterialTheme.typography.body1.copy(
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Text(
                                text = "Kamu perlu membuat akun agar \npencapaianmu tersimpan",
                                style = MaterialTheme.typography.body2.copy(
                                    color = Color.White
                                )
                            )
                        }
                        Button(
                            onClick = createAccountButtonOnClick,
                            modifier = Modifier
                                .align(Alignment.BottomStart),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Secondary600
                            )
                        ) {
                            Text(
                                text = "Buat Akun",
                                style = MaterialTheme.typography.body1.copy(
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.batur_mascot_smile),
                            contentDescription = stringResource(id = R.string.batur_mascot),
                            modifier = Modifier
                                .height(mascotSize)
                                .align(Alignment.BottomEnd)
                                .graphicsLayer {
                                    translationY = constraints.maxHeight / 2.5f
                                    translationX = constraints.maxWidth / 12f
                                    rotationZ = -10f
                                }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TopBannerPreview() {
    TopBanner(
        modifier = Modifier
            .width(400.dp)
            .height(250.dp)
    )
}