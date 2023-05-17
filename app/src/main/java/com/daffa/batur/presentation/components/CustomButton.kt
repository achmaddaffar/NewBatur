package com.daffa.batur.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.daffa.batur.presentation.ui.theme.DisabledColor
import com.daffa.batur.presentation.ui.theme.DisabledShadowColor
import com.daffa.batur.presentation.ui.theme.Primary600
import com.daffa.batur.presentation.ui.theme.Primary700
import com.daffa.batur.presentation.ui.theme.SpaceMedium
import com.daffa.batur.util.pressClickEffect


@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    buttonColor: Color = Primary600,
    shadowColor: Color = Primary700,
    enabled: Boolean = true,
    shape: CornerBasedShape = MaterialTheme.shapes.medium,
    contentPadding: PaddingValues = PaddingValues(SpaceMedium),
    content: @Composable RowScope.() -> Unit = {},
) {
    Box(
        modifier = modifier
    ) {
        Box(
            modifier = modifier
                .clip(shape)
                .height(53.dp)
                .background(if (enabled) shadowColor else DisabledShadowColor)
        )
        Button(
            onClick = onClick,
            modifier = modifier
                .pressClickEffect(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = buttonColor,
                disabledBackgroundColor = DisabledColor
            ),
            shape = shape,
            enabled = enabled,
            contentPadding = contentPadding,
            content = content
        )
    }
}