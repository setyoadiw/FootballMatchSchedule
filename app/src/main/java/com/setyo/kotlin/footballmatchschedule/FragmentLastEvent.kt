package com.setyo.kotlin.footballmatchschedule


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.setyo.kotlin.footballmatchschedule.Model.EventSchedule.EventsItem
import kotlinx.android.synthetic.main.fragment_last_event.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.support.v4.intentFor


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentMain : Fragment() , MainView{


    lateinit var presenter : FootballPresenterImp

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val fragmentView : View = inflater.inflate(R.layout.fragment_last_event, container, false)

        initPresenter()
        initView()

        return fragmentView
    }

    private fun initPresenter() {
        presenter =  FootballPresenterImp(this)
    }

    private fun initView() {
        presenter.getDataLastEvents()

    }

    private fun partItemClicked(partItem : EventsItem) {

        val intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra("date",partItem.dateEvent)
        intent.putExtra("hometeam",partItem.strHomeTeam)
        intent.putExtra("awayteam",partItem.strAwayTeam)
        intent.putExtra("homescore",partItem.intHomeScore)
        intent.putExtra("awayscore",partItem.intAwayScore)
        intent.putExtra("idhome",partItem.idHomeTeam)
        intent.putExtra("idaway",partItem.idAwayTeam)
        intent.putExtra("homegk",partItem.strHomeLineupGoalkeeper)
        intent.putExtra("homedf",partItem.strHomeLineupDefense)
        intent.putExtra("homemf",partItem.strHomeLineupMidfield)
        intent.putExtra("homefw",partItem.strHomeLineupForward)
        intent.putExtra("awaygk",partItem.strAwayLineupGoalkeeper)
        intent.putExtra("awaydf",partItem.strAwayLineupDefense)
        intent.putExtra("awaymf",partItem.strAwayLineupMidfield)
        intent.putExtra("awayfw",partItem.strAwayLineupForward)
        startActivity(intent)

    }

    override fun berhasil(data: ArrayList<EventsItem>) {
        //masukkan ke adapter
//        var LastEventAdapter = FootballAdapter(requireContext(),data)
        //adapter masukkan ke recyclerview

        recyclerview.layoutManager = LinearLayoutManager(requireContext())
//        recyclerview.adapter = LastEventAdapter

        recyclerview.adapter = FootballAdapter(requireContext(),data, { partItem : EventsItem -> partItemClicked(partItem) } )

    }

    override fun berhasilNextEvent(data: ArrayList<EventsItem>) {

    }

    override fun gagal(pesan: String) {

    }


    companion object {
        fun newInstance(): FragmentMain{
            val fragment = FragmentMain()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }



}
