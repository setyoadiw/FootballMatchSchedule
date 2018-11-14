package com.setyo.kotlin.footballmatchschedule


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.setyo.kotlin.footballmatchschedule.Model.EventSchedule.EventsItem
import kotlinx.android.synthetic.main.fragment_last_event.*


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

    override fun berhasil(data: ArrayList<EventsItem>) {
        //masukkan ke adapter
        var LastEventAdapter = FootballAdapter(requireContext(),data)
        //adapter masukkan ke recyclerview
        recyclerview.adapter = LastEventAdapter
        recyclerview.layoutManager = LinearLayoutManager(requireContext())

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
