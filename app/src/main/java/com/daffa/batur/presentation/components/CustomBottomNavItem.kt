package com.daffa.batur.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daffa.batur.presentation.ui.theme.IconSizeLarge
import com.daffa.batur.presentation.ui.theme.IconSizeMedium
import com.daffa.batur.presentation.ui.theme.IconSizeSmall
import com.daffa.batur.presentation.ui.theme.Slate400
import com.daffa.batur.presentation.ui.theme.SpaceSmall

@Composable
fun RowScope.CustomBottomNavItem(
    modifier: Modifier = Modifier,
    sectionName: String? = null,
    icon: Painter? = null,
    contentDescription: String? = null,
    selected: Boolean = false,
    selectedColor: Color = MaterialTheme.colors.primary,
    unselectedColor: Color = Slate400,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    BottomNavigationItem(
        selected = selected,
        onClick = { onClick() },
        modifier = modifier,
        enabled = enabled,
        selectedContentColor = selectedColor,
        unselectedContentColor = unselectedColor,
        icon = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    if (icon != null)
                        Icon(
                            painter = icon,
                            contentDescription = contentDescription,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(IconSizeLarge)
                        )
                }
                Text(
                    text = sectionName.toString(),
                    style = MaterialTheme.typography.body2,
                    color = if (selected) selectedColor else unselectedColor
                )
            }
        }
    )
}