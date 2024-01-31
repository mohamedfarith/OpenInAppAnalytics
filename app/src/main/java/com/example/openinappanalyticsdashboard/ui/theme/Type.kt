package com.example.openinappanalyticsdashboard.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.openinappanalyticsdashboard.R

// Set of Material typography styles to start with
object CustomTypography {
    val bigFont: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.figtree_normal)),
        fontSize = 24.sp
    )
    val bigFontBold: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.figtree_normal)),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold

    )
    val largeFont: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.figtree_normal)),
        fontSize = 20.sp
    )
    val largeFontBold: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.figtree_normal)),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold

    )

    val mediumFont: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.figtree_normal)),
        fontSize = 18.sp
    )
    val mediumFontBold: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.figtree_normal)),
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )

    val smallFont: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.figtree_normal)),
        fontSize = 16.sp
    )
    val smallFontBold: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.figtree_normal)),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
    val tinyFont: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.figtree_normal)),
        fontSize = 14.sp
    )
    val tinyFontBold: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.figtree_normal)),
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )
}
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)


