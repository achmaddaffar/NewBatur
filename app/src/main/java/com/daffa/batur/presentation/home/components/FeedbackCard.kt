package com.daffa.batur.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.daffa.batur.R
import com.daffa.batur.presentation.ui.theme.IconSizeUltra
import com.daffa.batur.presentation.ui.theme.SpaceMedium
import com.daffa.batur.presentation.ui.theme.SpaceSmall

@Composable
fun FeedbackCard(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = Color.White,
    image: Painter = painterResource(id = R.drawable.feedback_image),
) {
    Card(
        modifier = modifier,
        shape = shape,
        elevation = 5.dp,
        backgroundColor = backgroundColor
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = image,
                contentDescription = stringResource(R.string.feedback_image),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(SpaceMedium)
            ) {
                Text(
                    text = "Menyukai Aplikasi Batur?",
                    style = MaterialTheme.typography.body1
                )
                Spacer(modifier = Modifier.height(SpaceSmall))
                Text(
                    text = "Berikan apresiasi maupun kritik pada kami agar kami dapat berkembang menjadi lebih baik lagi",
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}