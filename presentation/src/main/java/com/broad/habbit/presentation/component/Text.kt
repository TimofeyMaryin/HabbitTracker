package com.broad.habbit.presentation.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.broad.habbit.presentation.R
import com.broad.habbit.presentation.theme.white



private val fontFamily = FontFamily(
    listOf(
        Font(R.font.ff_regular),
        Font(R.font.ff_bold, weight = FontWeight.Bold),
        Font(R.font.ff_italic, style = FontStyle.Italic),
        Font(R.font.ff_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic)
    )
)

enum class TextSize {
    TITLE_LARGE, TITLE_REGULAR,
    BODY_LARGE, BODY_REGULAR
}

@Composable
fun AppText(
    value: String,
    size: TextSize,
) {
    Text(
        text = value,
        color = white,
        fontSize = when (size) {
            TextSize.TITLE_LARGE -> 48.sp
            TextSize.TITLE_REGULAR -> 40.sp
            TextSize.BODY_LARGE -> 25.sp
            TextSize.BODY_REGULAR -> 20.sp
        }
    )

}