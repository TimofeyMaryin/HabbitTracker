package com.broad.habbit.presentation.fragments

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.broad.habbit.domain.entity.Habit
import com.broad.habbit.domain.entity.HabitCategory
import com.broad.habbit.domain.entity.HabitFrequency
import com.broad.habbit.domain.getCurrentDate
import com.broad.habbit.presentation.component.AppText
import com.broad.habbit.presentation.component.AppTextField
import com.broad.habbit.presentation.component.CategoryView
import com.broad.habbit.presentation.component.FragmentContainer
import com.broad.habbit.presentation.component.FrequencyView
import com.broad.habbit.presentation.component.TextSize
import com.broad.habbit.presentation.component.button.AddHabitButton
import com.broad.habbit.presentation.component.button.AppIconButton
import com.broad.habbit.presentation.vms.HabitViewModel


@Composable
fun EditHabitScreen(
    navController: NavController,
    viewModel: HabitViewModel,
) {
    var habitName by remember { mutableStateOf(viewModel.editHabit!!.name) }
    var habitDescription by remember { mutableStateOf(viewModel.editHabit!!.description) }
    var habitCategory by remember { mutableStateOf(viewModel.editHabit!!.category) }
    var habitFrequency by remember { mutableStateOf(viewModel.editHabit!!.frequency) }

    FragmentContainer(
        topBar = {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    AppIconButton {
                        navController.popBackStack()
                    }

                    AppText(value = "Добавить привычку", size = TextSize.BODY_REGULAR)
                }

                AnimatedVisibility(
                    visible =
                    habitName.isNotEmpty() &&
                            habitDescription.isNotEmpty() &&
                            habitFrequency != HabitFrequency.NONE
                ) {
                    AddHabitButton {
                        viewModel.editHabit(
                            newHabit = Habit.Builder()
                                .setName(habitName)
                                .setDescription(habitDescription)
                                .setHabitInitiation(getCurrentDate())
                                .setHabitFrequency(habitFrequency)
                                .setCategory(habitCategory)
                                .build(),
                            currentHabit = viewModel.editHabit!!
                        )
                        navController.popBackStack()
                    }
                }

            }
        }
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AppTextField(placeholder = "Новое название Привычки", value = habitName) {
                habitName = it
            }

            AppTextField(placeholder = "Новое описание привычки", value = habitDescription) {
                habitDescription = it
            }

            CategoryView(currentCategory = habitCategory) {
                habitCategory = it
            }

            FrequencyView(currentFrequency = habitFrequency) {

            }
        }

    }
}