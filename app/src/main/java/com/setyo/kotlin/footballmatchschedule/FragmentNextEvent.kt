package com.setyo.kotlin.footballmatchschedule


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.setyo.kotlin.footballmatchschedule.Model.EventSchedule.EventsItem
import com.setyo.kotlin.footballmatchschedule.Model.EventSchedule.ResponseLastEvents
import com.setyo.kotlin.footballmatchschedule.Model.TeamDetail.ResponseTeamDetail
import com.setyo.kotlin.footballmatchschedule.Model.TeamDetail.TeamsItem
import com.setyo.kotlin.footballmatchschedule.Network.Network
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_next_event.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentNextEvent : Fragment() , MainView{


    lateinit var presenter : FootballPresenterImp

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        initPresenter()
        initView()

        return inflater.inflate(R.layout.fragment_next_event, container, false)
    }

    private fun initPresenter() {
        presenter =  FootballPresenterImp(this)

    }

    private fun initView() {
        presenter.getDataNextEvents()

    }

    private fun partItemClicked(partItem : EventsItem) {

        //        startActivity<DetailActivity>(
        //                "id" to "${it.eventId}",
        //                "idhome" to "${it.idHome}",
        //                "idaway" to "${it.idAway}"
        //        )

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

    }

    override fun berhasilNextEvent(data: ArrayList<EventsItem>) {

        //masukkan ke adapter
        var NextEventAdapter = FootballAdapter(requireContext(),data,{ partItem : EventsItem -> partItemClicked(partItem) } )
        //adapter masukkan ke recyclerview
        recyclerview2.adapter = NextEventAdapter
        recyclerview2.layoutManager = LinearLayoutManager(requireContext())

    }

    override fun gagal(pesan: String) {

    }

    companion object {
        fun newInstance(): FragmentNextEvent{
            val fragment = FragmentNextEvent()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }


}
