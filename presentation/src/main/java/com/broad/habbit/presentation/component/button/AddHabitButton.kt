package com.broad.habbit.presentation.component.button

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.broad.habbit.presentation.theme.green

@Composable
fun AddHabitButton(
    onAdd: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .border(2.dp, green, MaterialTheme.shapes.medium)
            .size(35.dp)
            .clickable { onAdd() },
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            modifier = Modifier.size(25.dp),
            tint = green,
        )
    }
}