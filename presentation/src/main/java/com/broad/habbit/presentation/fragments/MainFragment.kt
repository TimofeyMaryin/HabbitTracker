package com.broad.habbit.presentation.fragments

import android.util.Log
import android.view.Menu
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.broad.habbit.presentation.R
import com.broad.habbit.presentation.component.AppText
import com.broad.habbit.presentation.component.MAX_SCREEN_USAGE
import com.broad.habbit.presentation.component.MenuView
import com.broad.habbit.presentation.component.MenuViewBehaviorDirector
import com.broad.habbit.presentation.component.MenuViewBehaviorImpl
import com.broad.habbit.presentation.component.TextSize

@Composable
fun MainFragment() {
    val menuViewBehaviorImpl = MenuViewBehaviorImpl()
    val menuViewBehaviorDirector = MenuViewBehaviorDirector(builder = menuViewBehaviorImpl)


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize(MAX_SCREEN_USAGE),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                
                AppText(value = "TrackerHabbit", size = TextSize.TITLE_LARGE)
                AppText(
                    value = "Ваш системный подход ко всему! Создавай привычки и выполняй их каждый день, а мы поможем довести дело до конца!",
                    size = TextSize.BODY_REGULAR
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                MenuView(model = menuViewBehaviorDirector.createDailyMenuView("28 Jan")) {
                    Log.e("TAG", "MainFragment createDailyMenuView: ${menuViewBehaviorDirector.createDailyMenuView("28 Jan")}", )
                }

                MenuView(model = menuViewBehaviorDirector.createUserHabitMenuView()) {
                    Log.e("TAG", "MainFragment createUserHabitMenuView: ${menuViewBehaviorDirector.createUserHabitMenuView()}", )
                }

                MenuView(model = menuViewBehaviorDirector.createCalendarMenuView()) {
                    Log.e("TAG", "MainFragment createCalendarMenuView: ${menuViewBehaviorDirector.createCalendarMenuView()}", )
                }

            }

            
        }

    }

}