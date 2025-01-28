package com.broad.habbit.domain.usecases

import com.broad.habbit.domain.entity.Habit

interface HabitUseCase {

    fun getAllHabits(): List<Habit>
    fun addHabit(newHabit: Habit)
    fun editHabit(currentHabit: Habit, newHabit: Habit)
    fun removeHabit(currentHabit: Habit)

}