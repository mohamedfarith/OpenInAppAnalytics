package com.example.openinappanalyticsdashboard.presentation.ui.components.dashboard.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.openinappanalyticsdashboard.Helper.nonNullString
import com.example.openinappanalyticsdashboard.R
import com.example.openinappanalyticsdashboard.data.models.dashboard.DashboardDataDto
import com.example.openinappanalyticsdashboard.ui.theme.CustomTypography
import com.example.openinappanalyticsdashboard.ui.theme.ThemeGray

data class ClickCard(val image: Int, val title: String, val subtitle: String)

fun DashboardDataDto.toTrendingContent(): List<ClickCard> {
    return listOf(
        ClickCard(
            image = R.drawable.click_count_icon,
            title = "Today's Clicks",
            subtitle = this.todayClicks.nonNullString()
        ),
        ClickCard(
            image = R.drawable.location_icon,
            title = "Top Location",
            subtitle = this.topLocation.nonNullString()
        ),
        ClickCard(
            image = R.drawable.web_source_icon,
            title = "Top Source",
            subtitle = this.topSource.nonNullString()
        )
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TrendingInfoCards(trendingCards: List<ClickCard>, onCardClick: (ClickCard) -> Unit) {
    LazyRow(modifier = Modifier.padding(start = 3.dp, top = 5.dp)) {
        itemsIndexed(trendingCards) { index, item ->
            Card(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentHeight()
                    .padding(horizontal = 9.dp, vertical = 10.dp),
                onClick = { onCardClick(trendingCards[index]) },
                shape = RoundedCornerShape(10.dp),
                elevation = 0.dp
            ) {
                Column(modifier = Modifier.padding(start = 20.dp,end  = 20.dp,top = 20.dp, bottom = 20.dp),Arrangement.Bottom) {
                    Image(painter = painterResource(id = item.image), contentDescription = "")
                    Text(
                        modifier = Modifier.padding(start = 5.dp, top = 12.dp),
                        text = item.subtitle,
                        color = Color.Black,
                        style = CustomTypography.largeFontBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = Modifier.padding(start = 5.dp, top = 5.dp),
                        text = item.title,
                        color = ThemeGray,
                        style = CustomTypography.mediumFont,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                }

            }
        }
    }


}

@Preview
@Composable
fun prev() {
    TrendingInfoCards(DashboardDataDto().toTrendingContent()) {}
}