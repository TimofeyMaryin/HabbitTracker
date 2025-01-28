package com.broad.habbit.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.broad.habbit.presentation.InitFragment
import com.broad.habbit.presentation.fragments.AllTaskFragment
import com.broad.habbit.presentation.fragments.CalendarFragment
import com.broad.habbit.presentation.fragments.DailyTaskFragment
import com.broad.habbit.presentation.fragments.MainFragment
import com.broad.habbit.presentation.vms.HabitViewModel

@Composable
fun ApplicationNavigation() {
    val viewModel: HabitViewModel = HabitViewModel()
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        this.composable(
            route = Screen.MainScreen.route
        ) {
            MainFragment()
        }

        this.composable(
            route = Screen.CalendarScreen.route
        ) {
            CalendarFragment(viewModel = viewModel)
        }

        this.composable(
            route = Screen.AllTasksScreen.route
        ) {
            AllTaskFragment(viewModel = viewModel)
        }

        this.composable(
            route = Screen.DailyTaskScreen.route
        ) {
            DailyTaskFragment(viewModel = viewModel)
        }
    }
}