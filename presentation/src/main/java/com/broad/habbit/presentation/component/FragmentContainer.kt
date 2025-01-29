package com.broad.habbit.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.broad.habbit.presentation.R
import com.broad.habbit.presentation.theme.backgroundColor

@Composable
fun FragmentContainer(
    topBar: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(backgroundColor)
                    .weight(1f),
                contentAlignment = Alignment.Center,
            ) {
                Box(modifier = Modifier.fillMaxSize(MAX_SCREEN_USAGE), contentAlignment = Alignment.Center) {
                    topBar()
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(9f),
                contentAlignment = Alignment.Center,
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(MAX_SCREEN_USAGE),
                    contentAlignment = Alignment.Center
                ) {
                    content()
                }
            }
        }
    }

}