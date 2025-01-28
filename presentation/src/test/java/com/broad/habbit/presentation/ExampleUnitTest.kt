package com.broad.habbit.presentation

import com.broad.habbit.data.HabitUseCaseImpl
import com.broad.habbit.domain.entity.Habit
import com.broad.habbit.domain.entity.HabitCategory
import com.broad.habbit.domain.factory.DailyHabit
import com.broad.habbit.domain.factory.WeeklyHabit
import org.junit.Test

import org.junit.Assert.*


class ExampleUnitTest {
    private val habitUserCase = HabitUseCaseImpl


    @Test
    fun getAllHabitIsCorrect1() {
        habitUserCase.addHabit(DailyHabit().create("name", description = "desc", category = HabitCategory.WORK, habitInitiation = "00:00"))
        assertEquals(
            listOf(DailyHabit().create("name", description = "desc", category = HabitCategory.WORK, habitInitiation = "00:00")),
            habitUserCase.getAllHabits()
        )
    }

    @Test
    fun removeHabit_Test1() {
        habitUserCase.addHabit(DailyHabit().create("name", description = "desc", category = HabitCategory.WORK, habitInitiation = "00:00"))
        habitUserCase.removeHabit(DailyHabit().create("name", description = "desc", category = HabitCategory.WORK, habitInitiation = "00:00"))
        assertEquals(
            emptyList<Habit>(),
            habitUserCase.getAllHabits()
        )
    }


    @Test
    fun editHabit_Test1() {
        habitUserCase.addHabit(DailyHabit().create("name", description = "desc", category = HabitCategory.WORK, habitInitiation = "00:00"))
        habitUserCase.editHabit(
            currentHabit = DailyHabit().create("name", description = "desc", category = HabitCategory.WORK, habitInitiation = "00:00"),
            newHabit = WeeklyHabit().create("week", description = "desc", category = HabitCategory.WORK, habitInitiation = "00:00")
        )
        assertEquals(
            listOf(WeeklyHabit().create("week", description = "desc", category = HabitCategory.WORK, habitInitiation = "00:00")),
            habitUserCase.getAllHabits()
        )
    }

}