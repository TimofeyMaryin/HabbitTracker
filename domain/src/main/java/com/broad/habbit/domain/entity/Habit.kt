package com.broad.habbit.domain.entity


interface HabitBuilder {
    fun setName(name: String): HabitBuilder
    fun setDescription(description: String): HabitBuilder
    fun setCategory(category: HabitCategory): HabitBuilder
    fun setHabitInitiation(initiation: String): HabitBuilder
    fun setHabitFrequency(frequency: HabitFrequency): HabitBuilder
}

data class Habit(
    var name: String,
    var description: String,
    var category: HabitCategory,
    var habitInitiation: String,
    var frequency: HabitFrequency,
) {
    class Builder: HabitBuilder {
        private var name: String = ""
        private var description: String = ""
        private var habitInitiation: String = ""
        private var category: HabitCategory = HabitCategory.NONE
        private var frequency: HabitFrequency = HabitFrequency.NONE

        override fun setName(name: String) = apply { this.name = name }
        override fun setDescription(description: String) = apply { this.description = description }
        override fun setCategory(category: HabitCategory) = apply { this.category = category }
        override fun setHabitInitiation(initiation: String): HabitBuilder = apply { this.habitInitiation = initiation }
        override fun setHabitFrequency(frequency: HabitFrequency): HabitBuilder = apply { this.frequency = frequency }

        fun build(): Habit {
            return Habit(
                name = this.name,
                description = this.description,
                category = this.category,
                habitInitiation = this.habitInitiation,
                frequency = this.frequency
            )
        }
    }
}


enum class HabitCategory { LESSON, STUDY, WORK, NONE }
enum class HabitFrequency { DAILY, WEEKLY, MONTHLY, NONE }


