package com.broad.habbit.data

import com.broad.habbit.domain.entity.Habit
import com.broad.habbit.domain.usecases.HabitUseCase


object HabitUseCaseImpl : HabitUseCase {
    private var habits = mutableListOf<Habit>()
    override fun getAllHabits(): List<Habit> {
        return habits
    }

    override fun addHabit(newHabit: Habit) { habits.add(newHabit) }

    override fun editHabit(currentHabit: Habit, newHabit: Habit) {

        if (habits.contains(currentHabit)) {
            val index = habits.indexOf(currentHabit)
            habits[index] = newHabit
            return
        } else {
            throw IllegalArgumentException("Cannot find current element")
        }
    }

    override fun removeHabit(currentHabit: Habit) {
        try {
            _removeHabit(currentHabit)
        } catch (e: NoSuchElementException) {
             throw NoSuchElementException("There is no current habit")
        }
    }

    private fun _removeHabit(currentHabit: Habit) {
        if (habits.isNotEmpty()) {
            habits.remove(currentHabit)
            return
        }
    }

}