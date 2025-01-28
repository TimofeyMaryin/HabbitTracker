package com.broad.habbit.presentation

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.broad.habbit.domain.entity.Habit
import com.broad.habbit.domain.entity.HabitCategory
import com.broad.habbit.domain.factory.DailyHabit
import com.broad.habbit.domain.factory.MonthlyHabit
import com.broad.habbit.domain.factory.WeeklyHabit
import com.broad.habbit.presentation.vms.HabitViewModel

@Composable
fun MainFragment() {
    val viewModel: HabitViewModel = HabitViewModel()

    LaunchedEffect(key1 = Unit, key2 = viewModel.triggerMainFragment) {
        Log.e("TAG", "MainFragment: UPDATE", )
        // currentSizeListHabits = viewModel.getAllHabits().toMutableList()
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {

        Text(text = "All habits: ${viewModel.getAllHabits()}")

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                onClick = {
                    viewModel.addHabit(DailyHabit().create(name = "Habit 1", description = "Desc 1", category = HabitCategory.WORK, habitInitiation = "00:00"))
                }
            ) {
                Text(text = "Create Daily Habit")
            }

            Button(
                onClick = {
                    viewModel.editHabit(
                        newHabit = WeeklyHabit().create("Weekly habbit", description = "Weekly desc 1", category = HabitCategory.LESSON, habitInitiation = "00:00"),
                        currentHabit = viewModel.getAllHabits().last()
                    )
                }
            ) {
                Text(text = "Update Last Habit")
            }

            Button(
                onClick = {
                    viewModel.removeHabit(
                        viewModel.getAllHabits().last()
                    )
                }
            ) {
                Text(text = "Remove Last Habit")
            }

        }

    }

}