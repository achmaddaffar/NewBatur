package com.daffa.batur.presentation.quiz.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.daffa.batur.presentation.ui.theme.DisabledColor
import com.daffa.batur.presentation.ui.theme.DisabledShadowColor
import com.daffa.batur.presentation.ui.theme.Primary600
import com.daffa.batur.presentation.ui.theme.Primary700
import com.daffa.batur.presentation.ui.theme.Secondary600
import com.daffa.batur.presentation.ui.theme.Secondary700
import com.daffa.batur.presentation.ui.theme.SpaceMedium
import com.daffa.batur.presentation.util.states.SelectionOption
import com.daffa.batur.util.pressClickEffect

@Composable
fun QuizOptionButton(
    modifier: Modifier = Modifier,
    onOptionClick: (SelectionOption) -> Unit = {},
    selectionOption: SelectionOption,
    buttonColor: Color = Primary600,
    shadowColor: Color = Primary700,
    enabled: Boolean = true,
    selected: Boolean = false,
    selectedButtonColor: Color = Secondary600,
    selectedShadowColor: Color = Secondary700,
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
                .background(
                    if (enabled) {
                        if (selected)
                            selectedShadowColor
                        else
                            shadowColor
                    } else DisabledShadowColor
                )
        )
        OptionButton(
            onClick = onOptionClick,
            selectionOption = selectionOption,
            modifier = modifier
                .pressClickEffect(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (selected) selectedButtonColor else buttonColor,
                disabledBackgroundColor = DisabledColor
            ),
            shape = shape,
            enabled = enabled,
            contentPadding = contentPadding,
            content = content
        )
    }
}

@Composable
fun OptionButton(
    onClick: (SelectionOption) -> Unit,
    selectionOption: SelectionOption,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    val contentColor by colors.contentColor(enabled)
    Surface(
        modifier = modifier
            .semantics { role = Role.Button }
            .clickable {
                onClick(selectionOption)
            },
        shape = shape,
        color = colors.backgroundColor(enabled).value,
        contentColor = contentColor.copy(alpha = 1f),
        border = border,
        elevation = elevation?.elevation(enabled, interactionSource)?.value ?: 0.dp,
    ) {
        CompositionLocalProvider(LocalContentAlpha provides contentColor.alpha) {
            ProvideTextStyle(
                value = MaterialTheme.typography.button
            ) {
                Row(
                    Modifier
                        .defaultMinSize(
                            minWidth = ButtonDefaults.MinWidth,
                            minHeight = ButtonDefaults.MinHeight
                        )
                        .padding(contentPadding),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    content = content
                )
            }
        }
    }
}