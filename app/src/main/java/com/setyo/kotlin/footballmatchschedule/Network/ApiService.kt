package com.setyo.kotlin.footballmatchschedule.Network

import com.setyo.kotlin.footballmatchschedule.Model.EventSchedule.ResponseLastEvents
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("eventspastleague.php?id=4328")
    fun getLastSchedule(): Observable<ResponseLastEvents>

    @GET("eventsnextleague.php?id=4328")
    fun getNextSchedule(): Observable<ResponseLastEvents>
}