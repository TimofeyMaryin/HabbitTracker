package com.broad.habbit.domain.entity


interface HabitBuilder {
    fun setName(name: String): HabitBuilder
    fun setDescription(description: String): HabitBuilder
    fun setCategory(category: HabitCategory): HabitBuilder
}

data class Habit(
    var name: String,
    var description: String,
    var category: HabitCategory,
) {
    class Builder: HabitBuilder {
        private var name: String = ""
        private var description: String = ""
        private var category: HabitCategory = HabitCategory.NONE

        override fun setName(name: String) = apply { this.name = name }
        override fun setDescription(description: String) = apply { this.description = description }
        override fun setCategory(category: HabitCategory) = apply { this.category = category }

        fun build(): Habit {
            return Habit(
                name = this.name,
                description = this.description,
                category = this.category
            )
        }
    }
}


enum class HabitCategory {
    LESSON, STUDY, WORK, NONE
}

