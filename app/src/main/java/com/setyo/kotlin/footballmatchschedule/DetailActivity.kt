package com.setyo.kotlin.footballmatchschedule

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.setyo.kotlin.footballmatchschedule.Model.EventSchedule.EventsItem
import com.setyo.kotlin.footballmatchschedule.Model.TeamDetail.ResponseTeamDetail
import com.setyo.kotlin.footballmatchschedule.Model.TeamDetail.TeamsItem
import com.setyo.kotlin.footballmatchschedule.Network.Network
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail.*
import org.jetbrains.anko.ctx
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.R.attr.bitmap
import android.support.v7.graphics.Palette
import android.R.attr.bitmap
import android.support.design.widget.CollapsingToolbarLayout


class DetailActivity : AppCompatActivity() {

    lateinit var dataTeamDetail : java.util.ArrayList<TeamsItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        initView()

//        val bundle = intent.getBundleExtra("myBundle")
//        var dataEvent  = bundle.getParcelable("dataParcel") as EventsItem
        val homeTeam = intent.getStringExtra("hometeam")
        val homeScore = intent.getStringExtra("homescore")
        val awayTeam = intent.getStringExtra("awayteam")
        val awayScore = intent.getStringExtra("awayscore")
        val dateEvent = intent.getStringExtra("date")
        val idHome = intent.getStringExtra("idhome")
        val idAway = intent.getStringExtra("idaway")

        tvHomeTeam.text=homeTeam
        tvAwayTeam.text=awayTeam
        tvHomeScore.text=homeScore
        tvAwayScore.text=awayScore
        tvDate.text=dateEvent

        gkHome.text = explode(intent.getStringExtra("homegk"))
        gkAway.text = explode(intent.getStringExtra("awaygk"))
        dfHome.text = explode(intent.getStringExtra("homedf"))
        dfAway.text = explode(intent.getStringExtra("awaydf"))
        mfHome.text = explode(intent.getStringExtra("homemf"))
        mfAway.text = explode(intent.getStringExtra("awaymf"))
        fwHome.text = explode(intent.getStringExtra("homefw"))
        fwAway.text = explode(intent.getStringExtra("awayfw"))




        Network.service.getTeamDetail(idHome)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    t: ResponseTeamDetail? ->

                    dataTeamDetail = t?.teams as java.util.ArrayList<TeamsItem>

                    Log.d("cekdata",t?.teams.get(0).strTeamBadge.toString())

                    Picasso.with(ctx).load(t.teams.get(0).strTeamBadge).into(imgHome)

                    Picasso.with(ctx).load(t.teams.get(0).strStadiumThumb).into(img_header)

                },{
                    e ->
                    Log.d("error:",e.localizedMessage)

                })

        Network.service.getTeamDetail(idAway)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    t: ResponseTeamDetail? ->

                    dataTeamDetail = t?.teams as java.util.ArrayList<TeamsItem>

                    Log.d("cekdata",t?.teams.get(0).strTeamBadge.toString())

                    Picasso.with(ctx).load(t.teams.get(0).strTeamBadge).into(imgAway)

                },{
                    e ->
                    Log.d("error:",e.localizedMessage)

                })



    }

    private fun initView() {

        val collapsingToolbar = findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)
        collapsingToolbar.title = "Match Detail"

    }

    private fun explode(pemain: String?): String? {
        return pemain?.replace("; ", "\n")
    }
}
