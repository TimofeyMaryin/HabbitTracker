package com.broad.habbit.domain

import com.broad.habbit.domain.entity.Habit
import com.broad.habbit.domain.entity.HabitCategory


fun MutableList<Habit>.filterHabitByCategory(category: HabitCategory): MutableList<Habit> {
    return this.filter {
        it.category == category
    }.toMutableList()
}