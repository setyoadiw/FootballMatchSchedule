package com.setyo.kotlin.footballmatchschedule.Model.TeamDetail


import com.google.gson.annotations.SerializedName


data class ResponseTeamDetail(

	@field:SerializedName("teams")
	val teams: List<TeamsItem?>? = null
)