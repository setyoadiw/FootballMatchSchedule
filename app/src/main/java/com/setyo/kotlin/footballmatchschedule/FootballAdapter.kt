package com.setyo.kotlin.footballmatchschedule

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.setyo.kotlin.footballmatchschedule.Model.EventSchedule.EventsItem
import kotlinx.android.synthetic.main.recycler_event_item.view.*
import java.util.ArrayList

class FootballAdapter(mContext : Context , data : ArrayList<EventsItem>) : RecyclerView.Adapter<FootballAdapter.MyHolder>() {

    var eventData : ArrayList<EventsItem>
    lateinit var mcontext : Context

    init {
        eventData = data
        this.mcontext = mContext
    }

    class MyHolder(itemView : View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener{

        override fun onClick(v: View?) {

        }

        fun bind(get: EventsItem) {

            itemView.tvteam1.text = get.strHomeTeam
            itemView.tvscore1.text = get.intHomeScore
            itemView.tvteam2.text = get.strAwayTeam
            itemView.tvscore2.text = get.intAwayScore
            itemView.tvDate.text = get.dateEvent
        }

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var view = LayoutInflater.from(p0?.context).inflate(R.layout.recycler_event_item,p0,false)

        return MyHolder(view)

    }

    override fun getItemCount(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return eventData.count()
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder?.bind(eventData.get(position))


    }



}