package com.broad.habbit.presentation.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.broad.habbit.presentation.R
import com.broad.habbit.presentation.theme.white



val fontFamily = FontFamily(
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
    color: Color = white,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Start,
    fontStyle: FontStyle = FontStyle.Normal,
) {
    Text(
        text = value,
        color = color,
        fontSize = when (size) {
            TextSize.TITLE_LARGE -> 48.sp
            TextSize.TITLE_REGULAR -> 40.sp
            TextSize.BODY_LARGE -> 25.sp
            TextSize.BODY_REGULAR -> 20.sp
        },
        textAlign = textAlign,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontStyle = fontStyle
    )

}