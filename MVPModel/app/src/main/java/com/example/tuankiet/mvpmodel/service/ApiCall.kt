package com.example.tuankiet.mvpmodel.service

import com.example.tuankiet.mvpmodel.model.DataModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall{
    @GET("edc/rest/aboutus")
    fun getAboutUs(@Query("version") version:Double=1.0): Observable<DataModel>
}