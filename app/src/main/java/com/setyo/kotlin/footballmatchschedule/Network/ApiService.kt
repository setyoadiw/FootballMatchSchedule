package com.setyo.kotlin.footballmatchschedule.Network

import com.setyo.kotlin.footballmatchschedule.Model.EventSchedule.ResponseLastEvents
import com.setyo.kotlin.footballmatchschedule.Model.TeamDetail.ResponseTeamDetail
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("eventspastleague.php?id=4328")
    fun getLastSchedule(): Observable<ResponseLastEvents>

    @GET("eventsnextleague.php?id=4328")
    fun getNextSchedule(): Observable<ResponseLastEvents>

    @GET("lookupteam.php?")
    fun getTeamDetail(@Query("id") id: String): Observable<ResponseTeamDetail>





}