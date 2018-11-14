package com.setyo.kotlin.footballmatchschedule

import com.setyo.kotlin.footballmatchschedule.Model.EventSchedule.EventsItem

interface MainView {

    fun berhasil(data: ArrayList<EventsItem>)
    fun berhasilNextEvent(data: ArrayList<EventsItem>)
    fun gagal(pesan : String)

}