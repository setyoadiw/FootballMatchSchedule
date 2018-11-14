package com.setyo.kotlin.footballmatchschedule


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.setyo.kotlin.footballmatchschedule.Model.EventSchedule.EventsItem
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
        // Inflate the layout for this fragment

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


    override fun berhasil(data: ArrayList<EventsItem>) {

    }

    override fun berhasilNextEvent(data: ArrayList<EventsItem>) {

        //masukkan ke adapter
        var NextEventAdapter = FootballAdapter(requireContext(),data)
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
