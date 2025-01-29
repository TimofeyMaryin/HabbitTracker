package com.broad.habbit.presentation.component.button

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.broad.habbit.presentation.theme.white

@Composable
fun AppIconButton(
    onBack: () -> Unit
) {
    androidx.compose.material3.IconButton(onClick = { onBack() }) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = null,
            modifier = Modifier.size(35.dp),
            tint = white
        )
    }
}