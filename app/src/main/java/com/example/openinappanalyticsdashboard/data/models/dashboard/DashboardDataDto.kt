package com.example.openinappanalyticsdashboard.data.models.dashboard

import com.google.gson.annotations.SerializedName

data class DashboardDataDto(
    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("statusCode") var statusCode: Int? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("support_whatsapp_number") var supportWhatsappNumber: String? = null,
    @SerializedName("extra_income") var extraIncome: Double? = null,
    @SerializedName("total_links") var totalLinks: Int? = null,
    @SerializedName("total_clicks") var totalClicks: Int? = null,
    @SerializedName("today_clicks") var todayClicks: Int? = null,
    @SerializedName("top_source") var topSource: String? = null,
    @SerializedName("top_location") var topLocation: String? = null,
    @SerializedName("startTime") var startTime: String? = null,
    @SerializedName("links_created_today") var linksCreatedToday: Int? = null,
    @SerializedName("applied_campaign") var appliedCampaign: Int? = null,
    @SerializedName("data") var data: Data? = Data()
)


data class LinksDataDto(

    @SerializedName("url_id") var urlId: Int? = null,
    @SerializedName("web_link") var webLink: String? = null,
    @SerializedName("smart_link") var smartLink: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("total_clicks") var totalClicks: Int? = null,
    @SerializedName("original_image") var originalImage: String? = null,
    @SerializedName("thumbnail") var thumbnail: String? = null,
    @SerializedName("times_ago") var timesAgo: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("domain_id") var domainId: String? = null,
    @SerializedName("url_prefix") var urlPrefix: String? = null,
    @SerializedName("url_suffix") var urlSuffix: String? = null,
    @SerializedName("app") var app: String? = null,
    @SerializedName("is_favourite") var isFavourite: Boolean? = null

)

data class Data(

    @SerializedName("recent_links") var recentLinks: ArrayList<LinksDataDto> = arrayListOf(),
    @SerializedName("top_links") var topLinks: ArrayList<LinksDataDto> = arrayListOf(),
    @SerializedName("favourite_links") var favouriteLinks: ArrayList<String> = arrayListOf(),
    @SerializedName("overall_url_chart") var overallUrlChart: Map<String, Int>? = null

)
