package com.example.openinappanalyticsdashboard.presentation.ui.components.dashboard.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.openinappanalyticsdashboard.Helper.nonNullToString
import com.example.openinappanalyticsdashboard.R
import com.example.openinappanalyticsdashboard.data.models.dashboard.LinksDataDto
import com.example.openinappanalyticsdashboard.ui.theme.CustomTypography
import com.example.openinappanalyticsdashboard.ui.theme.DarkBlue
import com.example.openinappanalyticsdashboard.ui.theme.LightBlue
import com.example.openinappanalyticsdashboard.ui.theme.ThemeGray
import com.example.openinappanalyticsdashboard.ui.theme.TransparentWhite
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

data class LinksUiData(
    var urlId: Int,
    var webLink: String,
    var smartLink: String,
    var title: String,
    var totalClicks: String,
    var originalImage: String,
    var thumbnail: String,
    var timesAgo: String,
    var createdAt: String,
    var domainId: String,
    var urlPrefix: String,
    var urlSuffix: String,
    var app: String,
    var isFavourite: Boolean
)


fun LinksDataDto.toUiData(): LinksUiData {
    return LinksUiData(
        urlId = this.urlId ?: -1,
        webLink = this.webLink ?: "",
        smartLink = this.smartLink.nonNullToString(),
        title = this.title.nonNullToString(),
        totalClicks = this.totalClicks.nonNullToString(),
        originalImage = this.originalImage.nonNullToString(),
        thumbnail = this.thumbnail.nonNullToString(),
        timesAgo = this.timesAgo.nonNullToString(),
        createdAt = this.createdAt.nonNullToString(),
        domainId = this.domainId.nonNullToString(),
        urlPrefix = this.urlPrefix.nonNullToString(),
        urlSuffix = this.urlSuffix.nonNullToString(),
        isFavourite = this.isFavourite ?: false,
        app = this.app.nonNullToString()
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLinks(pages: List<String>, content: HashMap<String, List<LinksDataDto>>) {

    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp)
            .background(TransparentWhite)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TabRow(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(10.dp),
                selectedTabIndex = pagerState.currentPage, divider = {}, indicator = {}
            ) {
                // Add tabs for all of our pages
                pages.forEachIndexed { index, title ->
                    Tab(
                        text = {
                            Text(
                                text = title,
                                style = CustomTypography.mediumFontBold,
                                color = if (pagerState.currentPage == index) Color.White else Color.Gray
                            )
                        },
                        selected = pagerState.currentPage == index,
                        modifier = Modifier
                            .clip(if (pagerState.currentPage == index) RoundedCornerShape(30.dp) else RectangleShape)
                            .background(color = if (pagerState.currentPage == index) DarkBlue else TransparentWhite),
                        onClick = {
                            scope.launch {
                                pagerState.scrollToPage(index)
                            }
                        },
                    )
                }
            }
            Image(
                modifier = Modifier.padding(end = 10.dp),
                painter = painterResource(id = R.drawable.search_icon),
                contentDescription = "Search"
            )
        }

        HorizontalPager(
            count = pages.size,
            state = pagerState,
        ) { page ->
            LoadCards(links = content[pages[page]] ?: emptyList())
        }
    }
}

@Composable
fun LoadCards(links: List<LinksDataDto>) {
    Column(modifier = Modifier.padding(10.dp)) {
        links.forEach { item ->
            LinkCard(link = item.toUiData())
        }
    }
}

@Composable
fun LinkCard(link: LinksUiData) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(TransparentWhite)
            .padding(top = 10.dp, bottom = 13.dp)
    ) {
        Card(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .clickable {},
            elevation = 0.dp,
            shape = RoundedCornerShape(10.dp),
            backgroundColor = Color.White
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .padding(5.dp), verticalAlignment = Alignment.CenterVertically
                ) {

                    AsyncImage(
                        model = link.originalImage,
                        modifier = Modifier
                            .fillMaxWidth(0.25f)
                            .height(80.dp),
                        contentScale = ContentScale.Fit,
                        contentDescription = "some icon"
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.75f)
                            .padding(start = 10.dp)
                    ) {
                        androidx.compose.material.Text(
                            text = link.title ?: "",
                            style = CustomTypography.smallFontBold,
                            color = Color.Black, maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        androidx.compose.material.Text(
                            modifier = Modifier.padding(top = 5.dp),
                            text = link.timesAgo ?: "",
                            style = CustomTypography.tinyFont,
                            color = ThemeGray,
                        )
                    }

                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp)
                    ) {
                        Text(link.totalClicks, style = CustomTypography.mediumFontBold)
                        Text(
                            modifier = Modifier.padding(top = 5.dp),
                            text = "Clicks",
                            color = ThemeGray,
                            style = CustomTypography.tinyFont
                        )
                    }
                }
                val stroke = Stroke(
                    width = 2f,
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                )
                Row(
                    Modifier
                        .fillMaxWidth()
                        .background(color = LightBlue)
                        .padding(1.dp)
                        .drawBehind {
                            drawRoundRect(
                                color = DarkBlue,
                                style = stroke,
                            )
                        }, verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .padding(horizontal = 10.dp, vertical = 15.dp),
                        textAlign = TextAlign.Start,
                        style = CustomTypography.tinyFont,
                        color = DarkBlue,
                        text = link.webLink ?: "",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Image(
                        modifier = Modifier.padding(5.dp),
                        painter = painterResource(id = R.drawable.file_icon),
                        contentDescription = ""
                    )
                }
            }


        }


    }

}