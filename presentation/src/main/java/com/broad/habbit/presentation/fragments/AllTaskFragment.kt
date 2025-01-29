package com.broad.habbit.presentation.fragments

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.broad.habbit.presentation.component.button.AppIconButton
import com.broad.habbit.presentation.component.AppText
import com.broad.habbit.presentation.component.FragmentContainer
import com.broad.habbit.presentation.component.TextSize
import com.broad.habbit.presentation.component.button.AddHabitButton
import com.broad.habbit.presentation.navigation.Screen
import com.broad.habbit.presentation.vms.HabitViewModel

@Composable
fun AllTaskFragment(
    viewModel: HabitViewModel,
    navController: NavController,
) {

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
                    
                    AppText(value = "Все привычки", size = TextSize.BODY_REGULAR)
                }

                AddHabitButton {
                    navController.navigate(Screen.AddHabitScreen.route)
                }
            }
        }
    ) {
        AppText(value = viewModel.getAllHabits().joinToString(" | "), size = TextSize.BODY_REGULAR)
    }

}