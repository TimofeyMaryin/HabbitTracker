package com.broad.habbit.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppTextField(
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AppText(value = placeholder, size = TextSize.BODY_REGULAR, fontWeight = FontWeight.Bold)
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(
                fontFamily = fontFamily,
            ),

        )
    }

}


@Preview
@Composable
private fun AppTextFieldPreview() {
    AppTextField(
        placeholder = "Add New Habit",
        value = "Hello WOrld",
        onValueChange = {  }
    )
}