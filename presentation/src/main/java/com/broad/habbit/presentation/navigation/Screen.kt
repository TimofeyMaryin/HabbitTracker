package com.broad.habbit.presentation.navigation

sealed class Screen(val route: String) {
    data object MainScreen : Screen("main-screen")
    data object AllTasksScreen : Screen("all-task-screen")
    data object CalendarScreen : Screen("calendar-screen")
    data object AddHabitScreen : Screen("add-habit-screen")
    data object EditHabitScreen : Screen("edit-habit-screen")
    data object DailyHabitScreen : Screen("daily-habit-screen")
}