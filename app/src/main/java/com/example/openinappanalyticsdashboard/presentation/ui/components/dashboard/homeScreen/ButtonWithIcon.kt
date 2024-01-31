package com.example.openinappanalyticsdashboard.presentation.ui.components.dashboard.homeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.openinappanalyticsdashboard.R
import com.example.openinappanalyticsdashboard.ui.theme.CustomTypography

@Composable
fun ButtonWithIcon(
    content: Any? = null,
    textColor: Color = Color.Black,
    backgroundColor: Color = Color.White,
    text: String,
    image: Int,
    arrangement: Arrangement.Horizontal = Arrangement.Center,
    borderColor: Color = Color.Black,
    onButtonClick: (Any?) -> Unit
) {
    androidx.compose.material.Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 9.dp),
        onClick = { onButtonClick.invoke(content) },
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, color = borderColor),
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        elevation = ButtonDefaults.elevation(0.dp)
    ) {
        val mPadding = if (arrangement == Arrangement.Start) PaddingValues(
            vertical = 12.dp, horizontal = 10.dp
        ) else PaddingValues(vertical = 5.dp, horizontal = 10.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues = mPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = arrangement
        ) {
            Image(
                modifier = Modifier.size(30.dp),
                painter = painterResource(id = image),
                contentDescription = text
            )
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = text,
                color = textColor,
                style = CustomTypography.mediumFontBold
            )
        }
    }
}

@Preview
@Composable
fun ButtonWithIconAtStartPrev() {
    ButtonWithIcon(
        backgroundColor = Color.White,
        text = "Whatsapp",
        image = R.drawable.link_icon,
        arrangement = Arrangement.Center,
        borderColor = Color.Black
    ){}
}
