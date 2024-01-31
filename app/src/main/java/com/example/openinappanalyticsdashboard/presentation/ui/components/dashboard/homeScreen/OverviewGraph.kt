package com.example.openinappanalyticsdashboard.presentation.ui.components.dashboard.homeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.openinappanalyticsdashboard.Helper
import com.example.openinappanalyticsdashboard.R
import com.example.openinappanalyticsdashboard.ui.theme.CustomTypography
import com.example.openinappanalyticsdashboard.ui.theme.LightGrey
import com.example.openinappanalyticsdashboard.ui.theme.PurpleGrey40
import com.example.openinappanalyticsdashboard.ui.theme.ThemeGray
import com.jaikeerthick.composable_graphs.composables.line.LineGraph
import com.jaikeerthick.composable_graphs.composables.line.model.LineData
import com.jaikeerthick.composable_graphs.composables.line.style.LineGraphStyle
import com.jaikeerthick.composable_graphs.composables.line.style.LineGraphVisibility
import com.jaikeerthick.composable_graphs.style.LabelPosition
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun OverviewGraph(chart: Map<String, Int>?) {
    val coroutineScope = rememberCoroutineScope()
    val dateRange = Helper.findRangeBetweenDates(chart)
    androidx.compose.material.Card(
        modifier = Modifier
            .padding(10.dp)
            .height(250.dp),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.White,
        elevation = 0.dp
    ) {
        Column {
            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(start = 10.dp),
                    text = "Overview",
                    color = ThemeGray,
                    style = CustomTypography.largeFont
                )
                Spacer(
                    modifier = Modifier
                        .wrapContentHeight()
                        .weight(1f)
                )
                OutlinedButton(
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(end = 10.dp),
                    onClick = { },
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, color = LightGrey)
                ) {
                    Row(
                        modifier = Modifier.background(
                            color = Color.White,
                        ), verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = dateRange,
                            modifier = Modifier.padding(end = 5.dp),
                            color = Color.Black,
                            style = CustomTypography.tinyFont
                        )
                        Image(
                            painter = painterResource(id = R.drawable.clock_icon),
                            contentDescription = "Dates between"
                        )
                    }
                }

            }
            StatsLineGraph(coroutineScope = coroutineScope, chart = chart)
        }
    }
}

@Composable
private fun StatsLineGraph(coroutineScope: CoroutineScope, chart: Map<String, Int>?) {
    val lineDataList = chart?.mapNotNull {
        Helper.extractMonthFromDate(it.key)?.let { month -> LineData(month, it.value) }
    }?.filter { it.y != 0 } ?: arrayListOf()
    LineGraph(
        style = LineGraphStyle(
            yAxisLabelPosition = LabelPosition.LEFT,
            visibility = LineGraphVisibility(
                isYAxisLabelVisible = true,
                isGridVisible = true,
                isCrossHairVisible = false
            )
        ),

        modifier = Modifier
            .padding(start = 20.dp, end = 15.dp, top = 10.dp, bottom = 20.dp),
        data = lineDataList,
        onPointClick = { value: LineData ->
            // do something with value
        },
    )
}

@Preview
@Composable
fun preview() {
    OverviewGraph(
        hashMapOf(
            "2023-12-30" to 10,
            "2023-12-31" to 0, "2024-01-01" to 12,
            "2024-01-02" to 4,
        )
    )
}