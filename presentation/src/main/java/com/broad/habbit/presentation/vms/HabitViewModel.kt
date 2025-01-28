package com.broad.habbit.presentation.vms

import androidx.lifecycle.ViewModel
import com.broad.habbit.data.HabitUseCaseImpl
import com.broad.habbit.domain.entity.Habit
import com.broad.habbit.domain.usecases.HabitUseCase

class HabitViewModel: ViewModel(), HabitUseCase {

    override fun addHabit(newHabit: Habit) {
        HabitUseCaseImpl.addHabit(newHabit)
    }

    override fun editHabit(currentHabit: Habit, newHabit: Habit) {
        HabitUseCaseImpl.editHabit(currentHabit = currentHabit, newHabit = newHabit)
    }

    override fun removeHabit(currentHabit: Habit) {
        HabitUseCaseImpl.removeHabit(currentHabit)
    }

    override fun getAllHabits(): List<Habit> {
        return HabitUseCaseImpl.getAllHabits()
    }


}