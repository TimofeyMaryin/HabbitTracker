package com.broad.habbit.presentation.navigation

sealed class Screen(val route: String) {
    data object MainScreen : Screen("main-screen")
    data object DailyTaskScreen : Screen("daily-task-screen")
    data object AllTasksScreen : Screen("all-task-screen")
    data object CalendarScreen : Screen("calendar-screen")
}