package com.broad.habbit.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.broad.habbit.domain.entity.Habit
import com.broad.habbit.domain.entity.HabitCategory
import com.broad.habbit.presentation.theme.containerColor
import com.broad.habbit.presentation.theme.red
import com.broad.habbit.presentation.theme.white

@Composable
fun HabitBlockByCategoryView(
    category: HabitCategory,
    habits: MutableList<Habit>,
    onDel: (Habit) -> Unit
) {

    Box(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .fillMaxWidth()
            .background(containerColor),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            AppText(value = category.name, size = TextSize.BODY_REGULAR)

            Divider()

            Column {
                habits.forEach { habit ->
                    HabitItem(habit = habit) {
                        onDel(habit)
                    }
                }
            }

        }
    }

}

@Composable
private fun HabitItem(
    habit: Habit,
    onDel: () -> Unit,
) {

    Box(
        modifier = Modifier.fillMaxWidth(.95f),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                AppText(value = habit.name, size = TextSize.TITLE_LARGE, fontWeight = FontWeight.Bold)
                AppText(value = habit.habitInitiation, size = TextSize.BODY_REGULAR, fontStyle = FontStyle.Italic, color = white.copy(.6f))
            }

            IconButton(onClick = { onDel() }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    tint = red,
                    modifier = Modifier.size(35.dp)
                )
            }
        }
    }

}