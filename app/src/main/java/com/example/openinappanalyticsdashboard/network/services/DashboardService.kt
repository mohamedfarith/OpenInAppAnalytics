package com.example.openinappanalyticsdashboard.network.services

import android.content.SharedPreferences
import com.example.openinappanalyticsdashboard.OpenInAppConstants
import com.example.openinappanalyticsdashboard.data.models.dashboard.DashboardDataDto
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject

interface DashboardService {
    @GET("/api/v1/dashboardNew")
    suspend fun getDashboardData(): retrofit2.Response<DashboardDataDto>


    companion object {
        fun create(token:String): DashboardService {
            return Retrofit.Builder()
                .baseUrl(OpenInAppConstants.BASE_URL)
                .client(OkHttpClient.Builder().addInterceptor(HttpInterceptor(token)).build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DashboardService::class.java)
        }
    }
}

class HttpInterceptor @Inject constructor(private val token:String) : Interceptor {
    //intercepting and adding headers, here it is API KEY
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder().addHeader(
                OpenInAppConstants.AUTHORIZATION,
                "Bearer $token"
            ).build()
        return chain.proceed(request)
    }

}