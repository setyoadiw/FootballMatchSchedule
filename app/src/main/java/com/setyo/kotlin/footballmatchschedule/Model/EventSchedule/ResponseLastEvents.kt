package com.setyo.kotlin.footballmatchschedule.Model.EventSchedule


import com.google.gson.annotations.SerializedName


data class ResponseLastEvents(

	@field:SerializedName("events")
	val events: List<EventsItem?>? = null
)