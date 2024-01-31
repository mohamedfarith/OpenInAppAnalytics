package com.example.openinappanalyticsdashboard.data.models.dashboard

import com.google.gson.annotations.SerializedName

data class GenericDataModel(
    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("statusCode") var statusCode: Int? = null,
    @SerializedName("message") var message: String? = null,
)
