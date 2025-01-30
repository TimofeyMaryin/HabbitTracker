package com.broad.habbit.domain

import com.broad.habbit.domain.entity.Habit
import com.broad.habbit.domain.entity.HabitCategory
import com.broad.habbit.domain.entity.HabitFrequency


fun MutableList<Habit>.filterHabitByCategory(category: HabitCategory): MutableList<Habit> {
    return this.filter {
        it.category == category
    }.toMutableList()
}

fun MutableList<Habit>.filterByFrequency(frequency: HabitFrequency): MutableList<Habit> {
    return this.filter {
        it.frequency == frequency
    }.toMutableList()
}