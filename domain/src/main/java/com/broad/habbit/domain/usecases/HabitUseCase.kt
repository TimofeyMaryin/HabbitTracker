package com.broad.habbit.domain.usecases

import com.broad.habbit.domain.entity.Habit

interface HabitUseCase {

    fun Habit.addHabit()
    fun Habit.editHabit(newHabit: Habit)
    fun Habit.removeHabit()

}