package com.broad.habbit.data

import com.broad.habbit.domain.entity.Habit
import com.broad.habbit.domain.usecases.HabitUseCase


object HabitUseCaseImpl : HabitUseCase {
    private var habits = mutableListOf<Habit>()

    override fun Habit.addHabit() { habits.add(this) }

    override fun Habit.editHabit(newHabit: Habit) {

        if (habits.contains(this)) {
            val index = habits.indexOf(this)
            habits[index] = newHabit
            return
        } else {
            throw IllegalArgumentException("Cannot find current element")
        }
    }

    override fun Habit.removeHabit() {
        if (habits.contains(this)) {
            habits.remove(this)
            return
        } else {
            throw IllegalArgumentException("Cannot find current element")
        }

    }

}