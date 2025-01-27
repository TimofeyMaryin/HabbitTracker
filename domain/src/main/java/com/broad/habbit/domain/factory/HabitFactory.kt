package com.broad.habbit.domain.factory

import com.broad.habbit.domain.entity.Habit
import com.broad.habbit.domain.entity.HabitCategory
import com.broad.habbit.domain.entity.HabitFrequency

interface HabitFactory {
    fun create(
        name: String,
        description: String,
        category: HabitCategory,
        habitInitiation: String,
    ): Habit
}

class DailyHabit : HabitFactory {
    override fun create(
        name: String,
        description: String,
        category: HabitCategory,
        habitInitiation: String
    ): Habit {
        return Habit.Builder()
            .setName(name)
            .setDescription(description)
            .setCategory(category)
            .setHabitFrequency(frequency = HabitFrequency.DAILY)
            .build()
    }
}


class WeeklyHabit : HabitFactory {
    override fun create(
        name: String,
        description: String,
        category: HabitCategory,
        habitInitiation: String
    ): Habit {
        return Habit.Builder()
            .setName(name)
            .setDescription(description)
            .setCategory(category)
            .setHabitInitiation(initiation = habitInitiation)
            .setHabitFrequency(frequency = HabitFrequency.WEEKLY)
            .build()
    }
}

class MonthlyHabit : HabitFactory {
    override fun create(
        name: String,
        description: String,
        category: HabitCategory,
        habitInitiation: String
    ): Habit {
        return Habit.Builder()
            .setName(name)
            .setDescription(description = description)
            .setCategory(category = category)
            .setHabitInitiation(initiation = habitInitiation)
            .setHabitFrequency(frequency = HabitFrequency.MONTHLY)
            .build()
    }
}