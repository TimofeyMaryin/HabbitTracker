package com.broad.habbit.presentation.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.broad.habbit.domain.entity.IMenuViewBehavior
import com.broad.habbit.domain.entity.MenuViewField
import com.broad.habbit.presentation.R
import com.broad.habbit.presentation.theme.containerColor
import com.broad.habbit.presentation.theme.emptyBrush
import com.broad.habbit.presentation.theme.green
import com.broad.habbit.presentation.theme.primaryBorderBrush



class MenuViewBehaviorDirector(private var builder: IMenuViewBehavior) {

    fun createDailyMenuView(name: String): MenuViewField {
        return builder
            .setIcon(R.drawable.ic_check)
            .setName(name)
            .setStatus(primary = true)
            .build()
    }


    fun createUserHabitMenuView(): MenuViewField {
        return builder
            .setIcon(R.drawable.ic_check)
            .setName("Ваши привычки")
            .setStatus(false)
            .build()
    }

    fun createCalendarMenuView(): MenuViewField {
        return builder
            .setIcon(R.drawable.ic_calendar)
            .setName("Календарь")
            .build()
    }


}


@Composable
fun MenuView(
    model: MenuViewField,
    onClick: () -> Unit
) {


    Box(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .border(
                width = 2.dp,
                brush = if (model.status) primaryBorderBrush else emptyBrush,
                shape = MaterialTheme.shapes.medium
            )
            .fillMaxWidth()
            .height(model.height.dp)
            .background(containerColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {

        Row(
            modifier = Modifier.fillMaxSize(MAX_SCREEN_USAGE),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AppText(value = model.text, size = TextSize.BODY_REGULAR, fontWeight = FontWeight.Bold)

            Icon(
                painter = painterResource(id = model.ic),
                contentDescription = null,
                tint = green,
                modifier = Modifier.size(40.dp)
            )
        }

    }

}