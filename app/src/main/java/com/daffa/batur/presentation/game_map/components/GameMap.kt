package com.daffa.batur.presentation.game_map.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Icon
import com.daffa.batur.R
import com.daffa.batur.presentation.util.states.MapNodeState

@Composable
fun GameMap(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        reverseLayout = true
    ) {
        val nodes = listOf<MapNodeState>(
            MapNodeState.Completed,
            MapNodeState.Completed,
            MapNodeState.LastCompleted,
            MapNodeState.Current,
            MapNodeState.Locked,
            MapNodeState.Locked,
            MapNodeState.Locked,
            MapNodeState.Locked,
            MapNodeState.Locked,
            MapNodeState.Locked
        )
        item {
            Spacer(modifier = Modifier.height(60.dp))
        }
        var turningPoint = -1
        items(10) { index ->
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                var offsetSize = 0.dp
                when (index % 4) {
                    0 -> {
                        turningPoint *= -1
                        offsetSize = 20.dp
                    }
                    1 -> offsetSize = 40.dp
                    2 -> offsetSize = 60.dp
                    3 -> offsetSize = 80.dp
                }
                Image(
                    painter = if (nodes[index] == MapNodeState.Completed)
                        painterResource(id = R.drawable.node_completed) else
                        if (nodes[index] == MapNodeState.LastCompleted)
                            painterResource(id = R.drawable.node_last_completed) else
                            if (nodes[index] == MapNodeState.Current)
                                painterResource(id = R.drawable.node_current) else
                                painterResource(id = R.drawable.node_locked),
                    contentDescription = "Map Node",
                    modifier = Modifier
                        .offset(x = offsetSize * turningPoint)
                        .clickable {  }
                )
            }
        }
        item {
            Spacer(modifier = Modifier.height(150.dp))
        }
    }
}