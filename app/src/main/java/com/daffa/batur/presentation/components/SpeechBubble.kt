package com.daffa.batur.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.daffa.batur.R
import com.daffa.batur.presentation.ui.theme.IconSizeLarge
import com.daffa.batur.presentation.ui.theme.Slate200
import com.daffa.batur.presentation.ui.theme.SpaceLarge
import com.daffa.batur.presentation.ui.theme.SpaceMedium

@Composable
fun SpeechBubble(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = Slate200,
    transX: Float = 0f,
    transY: Float = 0f,
    rotZ: Float = 0f,
    flipHorizontally: Boolean = false,
    tailAlignment: Alignment,
    content: @Composable BoxScope.() -> Unit,
) {
    Box {
        Box(
            modifier = Modifier
                .clip(shape)
                .background(backgroundColor)
                .padding(SpaceMedium)
        ) {
            Box {
                content()
            }
        }
        Icon(
            painter = painterResource(id = R.drawable.chat_bubble_tail),
            tint = backgroundColor,
            contentDescription = null,
            modifier = Modifier
                .size(IconSizeLarge)
                .align(tailAlignment)
                .graphicsLayer {
                    translationX = transX
                    translationY = transY
                    rotationZ = rotZ
                    rotationY = if (flipHorizontally) 180f else 0f
                }
        )
    }
}


@Preview
@Composable
fun ChatBubbleReview() {
    SpeechBubble(
        tailAlignment = Alignment.BottomStart,
        transY = 60f
    ) {
        Text(text = "HALOOOOO")
    }
}