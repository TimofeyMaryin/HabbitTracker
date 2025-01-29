package com.broad.habbit.presentation.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.broad.habbit.domain.entity.HabitCategory
import com.broad.habbit.presentation.theme.backgroundColor
import com.broad.habbit.presentation.theme.blue
import com.broad.habbit.presentation.theme.white

@Composable
fun CategoryView(
    currentCategory: HabitCategory,
    onSelected: (HabitCategory) -> Unit
) {
    val director = CategoryItemDataClassDirector()

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AppText(value = "Выбери тип категории", size = TextSize.BODY_REGULAR)
        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .fillMaxWidth()
                .background(white)
                .height(60.dp),
            contentAlignment = Alignment.Center,
        ) {

            Row(
                modifier = Modifier.fillMaxSize(MAX_SCREEN_USAGE),
            ) {
                CategoryItem(
                    data = director.createStudyCategoryItem(currentCategory == HabitCategory.STUDY)
                ) {
                    onSelected(HabitCategory.STUDY)
                }

                CategoryItem(data = director.createLessonCategoryItem(currentCategory == HabitCategory.LESSON)) {
                    onSelected(HabitCategory.LESSON)
                }

                CategoryItem(data = director.createWorkCategoryItem(currentCategory == HabitCategory.WORK)) {
                    onSelected(HabitCategory.WORK)
                }
            }

        }
    }
}

@Composable
private fun RowScope.CategoryItem(
    data: CategoryItemDataClass,
    onClick: () -> Unit
) {
    val _bgColor by animateColorAsState(targetValue = if(data.selected) blue else backgroundColor)

    Box(
        modifier = Modifier
            .weight(1f)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .fillMaxSize(MAX_SCREEN_USAGE)
                .background(_bgColor)
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            AppText(value = data.category.name, size = TextSize.BODY_REGULAR)
        }
    }
}

private interface CategoryItemData {
    fun setCategory(category: HabitCategory): CategoryItemData
    fun setSelected(value: Boolean): CategoryItemData
    fun build() : CategoryItemDataClass
}

private data class CategoryItemDataClass(
    val category: HabitCategory,
    val selected: Boolean,
) {
    class Builder : CategoryItemData {
        private var category = HabitCategory.NONE
        private var selected: Boolean = false

        override fun setCategory(category: HabitCategory): CategoryItemData {
            this.category = category
            return this
        }

        override fun setSelected(value: Boolean): CategoryItemData {
            this.selected = value
            return this
        }

        override fun build(): CategoryItemDataClass {
            return CategoryItemDataClass(
                category = this.category,
                selected = this.selected
            )
        }

    }
}

private class CategoryItemDataClassDirector {
    fun createStudyCategoryItem(value: Boolean): CategoryItemDataClass {
        return CategoryItemDataClass.Builder()
            .setCategory(HabitCategory.STUDY)
            .setSelected(value = value)
            .build()
    }

    fun createLessonCategoryItem(value: Boolean): CategoryItemDataClass {
        return CategoryItemDataClass.Builder()
            .setCategory(HabitCategory.LESSON)
            .setSelected(value = value)
            .build()
    }

    fun createWorkCategoryItem(value: Boolean): CategoryItemDataClass {
        return CategoryItemDataClass.Builder()
            .setCategory(HabitCategory.WORK)
            .setSelected(value = value)
            .build()
    }
}





@Preview
@Composable
private fun CategoryViewPrev() {
    CategoryView(currentCategory = HabitCategory.WORK) {
        HabitCategory.LESSON
    }
}