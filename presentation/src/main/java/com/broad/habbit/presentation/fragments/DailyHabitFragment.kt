package com.broad.habbit.presentation.fragments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.broad.habbit.domain.entity.Habit
import com.broad.habbit.domain.entity.HabitCategory
import com.broad.habbit.domain.entity.HabitFrequency
import com.broad.habbit.domain.filterByFrequency
import com.broad.habbit.domain.filterHabitByCategory
import com.broad.habbit.domain.getCurrentDate
import com.broad.habbit.presentation.component.AppText
import com.broad.habbit.presentation.component.FragmentContainer
import com.broad.habbit.presentation.component.HabitBlockByCategoryView
import com.broad.habbit.presentation.component.TextSize
import com.broad.habbit.presentation.component.button.AddHabitButton
import com.broad.habbit.presentation.component.button.AppIconButton
import com.broad.habbit.presentation.navigation.Screen
import com.broad.habbit.presentation.vms.HabitViewModel

@Composable
fun DailyHabitFragment(
    viewModel: HabitViewModel,
    navController: NavController,
) {

    val habits = remember { mutableStateListOf<Habit>() }

    LaunchedEffect(key1 = Unit, key2 = viewModel.triggerMainFragment) {
        habits.clear()
        habits.addAll(viewModel.getAllHabits().toMutableList().filterByFrequency(HabitFrequency.DAILY))
    }


    FragmentContainer(
        topBar = {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    AppIconButton {
                        navController.popBackStack()
                    }

                    AppText(value = getCurrentDate(), size = TextSize.BODY_REGULAR)
                }

                AddHabitButton {
                    navController.navigate(Screen.AddHabitScreen.route)
                }
            }
        }
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                HabitBlockByCategoryView(
                    category = HabitCategory.WORK,
                    habits = habits.filterHabitByCategory(HabitCategory.WORK),
                    onEdit = {
                        viewModel.setEdit_Habit(it)
                        navController.navigate(Screen.EditHabitScreen.route)
                    }
                ) {
                    habits.remove(it)
                    viewModel.removeHabit(it)
                }
            }
            item {
                HabitBlockByCategoryView(
                    category = HabitCategory.STUDY,
                    habits = habits.filterHabitByCategory(HabitCategory.STUDY),
                    onEdit = {
                        viewModel.setEdit_Habit(it)
                        navController.navigate(Screen.EditHabitScreen.route)
                    }
                ) {
                    habits.remove(it)
                    viewModel.removeHabit(it)
                }
            }
            item {
                HabitBlockByCategoryView(
                    category = HabitCategory.LESSON,
                    habits = habits.filterHabitByCategory(HabitCategory.LESSON),
                    onEdit = {
                        viewModel.setEdit_Habit(it)
                        navController.navigate(Screen.EditHabitScreen.route)
                    }
                ) {
                    habits.remove(it)
                    viewModel.removeHabit(it)
                }
            }
        }

    }


}