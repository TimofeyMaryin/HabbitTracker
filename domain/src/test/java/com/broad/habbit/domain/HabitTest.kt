package com.broad.habbit.domain

import com.broad.habbit.domain.entity.Habit
import com.broad.habbit.domain.entity.HabitCategory
import com.broad.habbit.domain.entity.HabitFrequency
import junit.framework.TestCase.assertTrue
import org.junit.Test

class HabitTest {

    private val habits = mutableListOf(
        Habit("Workout", "Go to the gym", HabitCategory.LESSON, "Morning", HabitFrequency.DAILY),
        Habit("Read", "Read a book", HabitCategory.LESSON, "Evening", HabitFrequency.DAILY),
        Habit("Meditation", "10 min meditation", HabitCategory.WORK, "Morning", HabitFrequency.DAILY)
    )

    @Test
    fun `filterHabitByCategory should return empty list when no matching category`() {
        val result = habits.filterHabitByCategory(HabitCategory.STUDY)
        assertTrue(result.isEmpty())
    }

    @Test
    fun `filterHabitByCategory should return empty list when input list is empty`() {
        val emptyList = mutableListOf<Habit>()
        val result = emptyList.filterHabitByCategory(HabitCategory.LESSON)
        assertTrue(result.isEmpty())
    }

}