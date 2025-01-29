package com.broad.habbit.presentation.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.broad.habbit.domain.entity.HabitFrequency
import com.broad.habbit.presentation.theme.backgroundColor
import com.broad.habbit.presentation.theme.blue
import com.broad.habbit.presentation.theme.white

@Composable
fun FrequencyView(
    currentFrequency: HabitFrequency,
    onSelected: (HabitFrequency) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        AppText(value = "Выбери частоту привычки", size = TextSize.BODY_REGULAR)

        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .fillMaxWidth()
                .background(white)
                .height(60.dp),
            contentAlignment = Alignment.Center,
        ) {
            Row(
                modifier = Modifier.fillMaxSize(MAX_SCREEN_USAGE),
            ) {

                FrequencyItem(frequency = HabitFrequency.DAILY, selected = currentFrequency == HabitFrequency.DAILY) {
                    onSelected(HabitFrequency.DAILY)
                }

                FrequencyItem(frequency = HabitFrequency.WEEKLY, selected = currentFrequency == HabitFrequency.WEEKLY) {
                    onSelected(HabitFrequency.WEEKLY)
                }

                FrequencyItem(frequency = HabitFrequency.MONTHLY, selected = currentFrequency == HabitFrequency.MONTHLY) {
                    onSelected(HabitFrequency.MONTHLY)
                }
            }
        }

    }
}

@Composable
private fun RowScope.FrequencyItem(
    frequency: HabitFrequency,
    selected: Boolean,
    onSelected: () -> Unit
) {
    val _bgColor by animateColorAsState(targetValue = if(selected) blue else backgroundColor)

    Box(
        modifier = Modifier
            .weight(1f)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .fillMaxSize(MAX_SCREEN_USAGE)
                .background(_bgColor)
                .clickable { onSelected() },
            contentAlignment = Alignment.Center
        ) {
            AppText(value = frequency.name, size = TextSize.BODY_REGULAR)
        }
    }
}