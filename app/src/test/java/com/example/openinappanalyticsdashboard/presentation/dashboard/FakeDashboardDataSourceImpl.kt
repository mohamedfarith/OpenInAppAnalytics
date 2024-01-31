package com.example.openinappanalyticsdashboard.presentation.dashboard

import com.example.openinappanalyticsdashboard.OpenInAppConstants
import com.example.openinappanalyticsdashboard.data.models.dashboard.DashboardDataDto
import com.example.openinappanalyticsdashboard.domain.dataSources.dashboard.DashboardDataSource
import com.example.openinappanalyticsdashboard.network.NetworkState
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FakeDashboardDataSourceImpl @Inject constructor() :
    DashboardDataSource {
    override suspend fun getDashboardData(): Flow<NetworkState> =
        flow<NetworkState> {
            emit(NetworkState.Success(fakeData()))
        }.catch { emit(NetworkState.Failure(message = OpenInAppConstants.DEFAULT_API_FAILURE_MESSAGE)) }

    private fun fakeData(): DashboardDataDto? {
        val data = "{\n" +
                "    \"status\": true,\n" +
                "    \"statusCode\": 200,\n" +
                "    \"message\": \"success\",\n" +
                "    \"support_whatsapp_number\": \"6360481897\",\n" +
                "    \"extra_income\": 80.38,\n" +
                "    \"total_links\": 178,\n" +
                "    \"total_clicks\": 1531,\n" +
                "    \"today_clicks\": 2,\n" +
                "    \"top_source\": \"inopenapp\",\n" +
                "    \"top_location\": \"Mumbai\",\n" +
                "    \"startTime\": \"13:00\",\n" +
                "    \"links_created_today\": 0,\n" +
                "    \"applied_campaign\": 0, \n" +
                "    \"data\": {\n" +
                "        \"recent_links\": [\n" +
                "            {\n" +
                "                \"url_id\": 146150,\n" +
                "                \"web_link\": \"https://inopenapp.com/4o5qk\",\n" +
                "                \"smart_link\": \"inopenapp.com/4o5qk\",\n" +
                "                \"title\": \"651   Flats for Rent in Kormangla Bangalore, Bangalore Karnataka Without Brokerage - NoBroker Rental Properties in Kormangla Bangalore Karnataka Without Brokerage\",\n" +
                "                \"total_clicks\": 168,\n" +
                "                \"original_image\": \"https://assets.nobroker.in/nb-new/public/List-Page/ogImage.png\",\n" +
                "                \"thumbnail\": null,\n" +
                "                \"times_ago\": \"10 month ago\",\n" +
                "                \"created_at\": \"2023-03-15T07:33:50.000Z\",\n" +
                "                \"domain_id\": \"inopenapp.com/\",\n" +
                "                \"url_prefix\": null,\n" +
                "                \"url_suffix\": \"4o5qk\",\n" +
                "                \"app\": \"nobroker\",\n" +
                "                \"is_favourite\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"url_id\": 146110,\n" +
                "                \"web_link\": \"https://inopenapp.com/estt3\",\n" +
                "                \"smart_link\": \"inopenapp.com/estt3\",\n" +
                "                \"title\": \"Dailyhunt\",\n" +
                "                \"total_clicks\": 84,\n" +
                "                \"original_image\": \"https://m.dailyhunt.in/assets/img/apple-touch-icon-72x72.png?mode=pwa&ver=2.0.76\",\n" +
                "                \"thumbnail\": null,\n" +
                "                \"times_ago\": \"10 month ago\",\n" +
                "                \"created_at\": \"2023-03-09T08:00:05.000Z\",\n" +
                "                \"domain_id\": \"inopenapp.com/\",\n" +
                "                \"url_prefix\": null,\n" +
                "                \"url_suffix\": \"estt3\",\n" +
                "                \"app\": \"dailyhunt\",\n" +
                "                \"is_favourite\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"url_id\": 146061,\n" +
                "                \"web_link\": \"https://inopenapp.com/7113t\",\n" +
                "                \"smart_link\": \"inopenapp.com/7113t\",\n" +
                "                \"title\": \"MSI Katana GF66 Thin, Intel 12th Gen. i5-12450H, 40CM FHD 144Hz Gaming Laptop (16GB/512GB NVMe SSD/Windows 11 Home/Nvidia RTX3050Ti 4GB GDDR6/Black/2.25Kg), 12UD-640IN : Amazon.in: Computers & Accessories\",\n" +
                "                \"total_clicks\": 59,\n" +
                "                \"original_image\": \"https://m.media-amazon.com/images/I/81c+XOq0b+L._SY450_.jpg\",\n" +
                "                \"thumbnail\": null,\n" +
                "                \"times_ago\": \"11 month ago\",\n" +
                "                \"created_at\": \"2023-02-23T11:45:54.000Z\",\n" +
                "                \"domain_id\": \"inopenapp.com/\",\n" +
                "                \"url_prefix\": null,\n" +
                "                \"url_suffix\": \"7113t\",\n" +
                "                \"app\": \"amazon\",\n" +
                "                \"is_favourite\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"url_id\": 145873,\n" +
                "                \"web_link\": \"https://inopenapp.com/juixo\",\n" +
                "                \"smart_link\": \"inopenapp.com/juixo\",\n" +
                "                \"title\": \"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!\",\n" +
                "                \"total_clicks\": 49,\n" +
                "                \"original_image\": \"https://www.flipkart.com/apple-touch-icon-57x57.png\",\n" +
                "                \"thumbnail\": null,\n" +
                "                \"times_ago\": \"11 month ago\",\n" +
                "                \"created_at\": \"2023-02-20T04:59:00.000Z\",\n" +
                "                \"domain_id\": \"inopenapp.com/\",\n" +
                "                \"url_prefix\": null,\n" +
                "                \"url_suffix\": \"juixo\",\n" +
                "                \"app\": \"flipkart\",\n" +
                "                \"is_favourite\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"url_id\": 144236,\n" +
                "                \"web_link\": \"https://inopenapp.com/h2hok\",\n" +
                "                \"smart_link\": \"inopenapp.com/h2hok\",\n" +
                "                \"title\": \"Programming Jokes & MeMes | The gods have spoken\",\n" +
                "                \"total_clicks\": 50,\n" +
                "                \"original_image\": \"https://scontent-iad3-2.xx.fbcdn.net/v/t39.30808-6/325385014_1393046418172272_8557035725717444936_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=7fc0be&_nc_ohc=YYNdHpdCbiAAX9iHO5V&_nc_ht=scontent-iad3-2.xx&oh=00_AfCk2FYoD4WCCp3bqnjBxcxhQ8MEAxCw9xyInnM5sBO0VA&oe=63CD146D\",\n" +
                "                \"thumbnail\": null,\n" +
                "                \"times_ago\": \"1 yr ago\",\n" +
                "                \"created_at\": \"2023-01-18T05:40:39.000Z\",\n" +
                "                \"domain_id\": \"inopenapp.com/\",\n" +
                "                \"url_prefix\": null,\n" +
                "                \"url_suffix\": \"h2hok\",\n" +
                "                \"app\": \"facebook\",\n" +
                "                \"is_favourite\": false\n" +
                "            }\n" +
                "        ],\n" +
                "        \"top_links\": [\n" +
                "            {\n" +
                "                \"url_id\": 98953,\n" +
                "                \"web_link\": \"https://boyceavenue.inopenapp.com/boyce-avenue\",\n" +
                "                \"smart_link\": \"boyceavenue.inopenapp.com/boyce-avenue\",\n" +
                "                \"title\": \"Can't Help Falling In Love - Elvis Presley (Boyce Avenue acoustic cover) on Spotify & Apple\",\n" +
                "                \"total_clicks\": 369,\n" +
                "                \"original_image\": \"https://i.ytimg.com/vi/G0WTFfZqjz0/maxresdefault.jpg\",\n" +
                "                \"thumbnail\": null,\n" +
                "                \"times_ago\": \"2 yr ago\",\n" +
                "                \"created_at\": \"2022-01-12T13:57:49.000Z\",\n" +
                "                \"domain_id\": \"inopenapp.com/\",\n" +
                "                \"url_prefix\": \"boyceavenue\",\n" +
                "                \"url_suffix\": \"boyce-avenue\",\n" +
                "                \"app\": \"youtube\",\n" +
                "                \"is_favourite\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"url_id\": 146150,\n" +
                "                \"web_link\": \"https://inopenapp.com/4o5qk\",\n" +
                "                \"smart_link\": \"inopenapp.com/4o5qk\",\n" +
                "                \"title\": \"651   Flats for Rent in Kormangla Bangalore, Bangalore Karnataka Without Brokerage - NoBroker Rental Properties in Kormangla Bangalore Karnataka Without Brokerage\",\n" +
                "                \"total_clicks\": 168,\n" +
                "                \"original_image\": \"https://assets.nobroker.in/nb-new/public/List-Page/ogImage.png\",\n" +
                "                \"thumbnail\": null,\n" +
                "                \"times_ago\": \"10 month ago\",\n" +
                "                \"created_at\": \"2023-03-15T07:33:50.000Z\",\n" +
                "                \"domain_id\": \"inopenapp.com/\",\n" +
                "                \"url_prefix\": null,\n" +
                "                \"url_suffix\": \"4o5qk\",\n" +
                "                \"app\": \"nobroker\",\n" +
                "                \"is_favourite\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"url_id\": 140627,\n" +
                "                \"web_link\": \"https://amazon.inopenapp.com/b01n5qh183\",\n" +
                "                \"smart_link\": \"amazon.inopenapp.com/b01n5qh183\",\n" +
                "                \"title\": \"Match Women's Long Sleeve Flannel Plaid Shirt at Amazon Women’s Clothing store\",\n" +
                "                \"total_clicks\": 153,\n" +
                "                \"original_image\": \"https://m.media-amazon.com/images/I/51rE6aQt2fL._AC_.jpg\",\n" +
                "                \"thumbnail\": null,\n" +
                "                \"times_ago\": \"1 yr ago\",\n" +
                "                \"created_at\": \"2022-09-23T19:59:49.000Z\",\n" +
                "                \"domain_id\": \"inopenapp.com/\",\n" +
                "                \"url_prefix\": \"amazon\",\n" +
                "                \"url_suffix\": \"b01n5qh183\",\n" +
                "                \"app\": \"amazon\",\n" +
                "                \"is_favourite\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"url_id\": 81169,\n" +
                "                \"web_link\": \"https://dream.inopenapp.com/vid\",\n" +
                "                \"smart_link\": \"dream.inopenapp.com/vid\",\n" +
                "                \"title\": \"YouTube\",\n" +
                "                \"total_clicks\": 107,\n" +
                "                \"original_image\": \"https://www.youtube.com/img/desktop/yt_1200.png\",\n" +
                "                \"thumbnail\": null,\n" +
                "                \"times_ago\": \"2 yr ago\",\n" +
                "                \"created_at\": \"2021-12-17T10:36:05.000Z\",\n" +
                "                \"domain_id\": \"inopenapp.com/\",\n" +
                "                \"url_prefix\": \"dream\",\n" +
                "                \"url_suffix\": \"vid\",\n" +
                "                \"app\": \"youtube\",\n" +
                "                \"is_favourite\": false\n" +
                "            },\n" +
                "            {\n" +
                "                \"url_id\": 146110,\n" +
                "                \"web_link\": \"https://inopenapp.com/estt3\",\n" +
                "                \"smart_link\": \"inopenapp.com/estt3\",\n" +
                "                \"title\": \"Dailyhunt\",\n" +
                "                \"total_clicks\": 84,\n" +
                "                \"original_image\": \"https://m.dailyhunt.in/assets/img/apple-touch-icon-72x72.png?mode=pwa&ver=2.0.76\",\n" +
                "                \"thumbnail\": null,\n" +
                "                \"times_ago\": \"10 month ago\",\n" +
                "                \"created_at\": \"2023-03-09T08:00:05.000Z\",\n" +
                "                \"domain_id\": \"inopenapp.com/\",\n" +
                "                \"url_prefix\": null,\n" +
                "                \"url_suffix\": \"estt3\",\n" +
                "                \"app\": \"dailyhunt\",\n" +
                "                \"is_favourite\": false\n" +
                "            }\n" +
                "        ],\n" +
                "        \"favourite_links\": [],\n" +
                "        \"overall_url_chart\": {\n" +
                "            \"2023-12-30\": 0,\n" +
                "            \"2023-12-31\": 0,\n" +
                "            \"2024-01-01\": 0,\n" +
                "            \"2024-01-02\": 0,\n" +
                "            \"2024-01-03\": 0,\n" +
                "            \"2024-01-04\": 0,\n" +
                "            \"2024-01-05\": 0,\n" +
                "            \"2024-01-06\": 0,\n" +
                "            \"2024-01-07\": 0,\n" +
                "            \"2024-01-08\": 0,\n" +
                "            \"2024-01-09\": 0,\n" +
                "            \"2024-01-10\": 0,\n" +
                "            \"2024-01-11\": 0,\n" +
                "            \"2024-01-12\": 0,\n" +
                "            \"2024-01-13\": 0,\n" +
                "            \"2024-01-14\": 0,\n" +
                "            \"2024-01-15\": 0,\n" +
                "            \"2024-01-16\": 0,\n" +
                "            \"2024-01-17\": 0,\n" +
                "            \"2024-01-18\": 0,\n" +
                "            \"2024-01-19\": 0,\n" +
                "            \"2024-01-20\": 0,\n" +
                "            \"2024-01-21\": 0,\n" +
                "            \"2024-01-22\": 0,\n" +
                "            \"2024-01-23\": 13,\n" +
                "            \"2024-01-24\": 41,\n" +
                "            \"2024-01-25\": 199,\n" +
                "            \"2024-01-26\": 7,\n" +
                "            \"2024-01-27\": 2,\n" +
                "            \"2024-01-28\": 0,\n" +
                "            \"2024-01-29\": 2\n" +
                "        }\n" +
                "    }\n" +
                "}"
        return Gson().fromJson(data, DashboardDataDto::class.java)
    }
}