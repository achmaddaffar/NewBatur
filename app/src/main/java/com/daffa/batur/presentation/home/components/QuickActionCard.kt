package com.daffa.batur.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.daffa.batur.data.models.Course
import com.daffa.batur.presentation.ui.theme.SpaceMedium
import com.daffa.batur.presentation.ui.theme.SpaceSmall

@Composable
fun QuickActionCard(
    modifier: Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    course: Course,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier,
        shape = shape,
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(SpaceMedium),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = course.suku.toString(),
                    style = MaterialTheme.typography.body1
                )
                Spacer(modifier = Modifier.height(SpaceSmall))
                val desc = buildAnnotatedString {
                    append(course.bab)
                    append("\n")
                    append(course.subBab)
                }
                Text(
                    text = desc,
                    style = MaterialTheme.typography.body2
                )
            }
            Button(
                onClick = onClick
            ) {
                Text(
                    text = "Mulai kursus ini!",
                    style = MaterialTheme.typography.body2.copy(
                        color = Color.White
                    )
                )
            }
        }
    }
}