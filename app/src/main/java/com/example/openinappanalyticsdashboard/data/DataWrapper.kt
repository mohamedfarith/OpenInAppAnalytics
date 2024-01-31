package com.example.openinappanalyticsdashboard.data

import android.util.Log
import com.example.openinappanalyticsdashboard.OpenInAppConstants
import com.example.openinappanalyticsdashboard.data.models.dashboard.GenericDataModel
import com.google.gson.Gson
import retrofit2.Response

object DataWrapper {
    fun <T> invoke(response: Response<T>): NetworkState {
        return if (response.isSuccessful) {
            //success case from Http side
            try {
                val data = Gson().fromJson(Gson().toJson(response.body()), GenericDataModel::class.java)
                if (data.status == true) {
                    NetworkState.Success(data = response.body())
                } else NetworkState.Failure(
                    message = data.message ?: OpenInAppConstants.DEFAULT_API_FAILURE_MESSAGE
                )

            } catch (e: Exception) {
                Log.d("Exception", "invoke: $e")
                NetworkState.Failure(message = OpenInAppConstants.DEFAULT_API_FAILURE_MESSAGE)
            }

        } else {
            NetworkState.Failure(message = OpenInAppConstants.DEFAULT_API_FAILURE_MESSAGE)

        }
    }
}