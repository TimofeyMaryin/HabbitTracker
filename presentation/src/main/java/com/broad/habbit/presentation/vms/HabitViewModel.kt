package com.broad.habbit.presentation.vms

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.broad.habbit.data.HabitUseCaseImpl
import com.broad.habbit.domain.entity.Habit
import com.broad.habbit.domain.entity.HabitFrequency
import com.broad.habbit.domain.factory.DailyHabit
import com.broad.habbit.domain.usecases.HabitUseCase

class HabitViewModel: ViewModel(), HabitUseCase {
    var triggerMainFragment by mutableIntStateOf(0)

    override fun addHabit(newHabit: Habit) {
        HabitUseCaseImpl.addHabit(newHabit)
        this.triggerMainFragment++
    }

    override fun editHabit(currentHabit: Habit, newHabit: Habit) {
        HabitUseCaseImpl.editHabit(currentHabit = currentHabit, newHabit = newHabit)
        this.triggerMainFragment++
    }

    override fun removeHabit(currentHabit: Habit) {
        HabitUseCaseImpl.removeHabit(currentHabit)
        this.triggerMainFragment++
    }

    override fun getAllHabits(): List<Habit> {
        return HabitUseCaseImpl.getAllHabits()
    }


}