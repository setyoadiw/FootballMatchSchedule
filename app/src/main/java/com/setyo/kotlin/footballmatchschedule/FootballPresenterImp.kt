package com.setyo.kotlin.footballmatchschedule

import android.util.Log
import com.setyo.kotlin.footballmatchschedule.Model.EventSchedule.EventsItem
import com.setyo.kotlin.footballmatchschedule.Model.EventSchedule.ResponseLastEvents
import com.setyo.kotlin.footballmatchschedule.Network.Network
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FootballPresenterImp : FootballPresenter{


    var MainView : MainView? = null

    var data : ArrayList<EventsItem>? = null

    constructor(MainView : MainView?){
        this.MainView = MainView
        this.data = data
    }



    override fun getDataLastEvents() {

        Network.service.getLastSchedule()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    t: ResponseLastEvents? ->

                    MainView?.berhasil(t?.events as ArrayList<EventsItem>)

                    Log.d("dataserverlast",t?.events.toString())
                },{
                    e ->
                    Log.d("error:",e.localizedMessage)

                    MainView?.gagal(e.localizedMessage.toString())
                })


    }

    override fun getDataNextEvents() {

        Network.service.getNextSchedule()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    t: ResponseLastEvents? ->

                    MainView?.berhasilNextEvent(t?.events as ArrayList<EventsItem>)

                    Log.d("dataservernext",t?.events.toString())
                },{
                    e ->
                    Log.d("error:",e.localizedMessage)

                    MainView?.gagal(e.localizedMessage.toString())
                })


    }


}