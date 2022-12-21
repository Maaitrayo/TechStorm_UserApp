package com.example.techstorm223.ResultScreenContents

import com.example.techstorm223.R


sealed class ResultList(var route: String, var icon: Int, var title: String)
{
    object BrainTeasersResult: ResultList("BrainTeasersResult", R.drawable.ic_new, "Need for Speed Result")
    object IdeaPresentationResult : ResultList("ideaPresentation", R.drawable.ic_new, "Knet Result")
    object RoversResult : ResultList("RoversListResult", R.drawable.ic_new, "Clash of Clans Result")
    object GamesResult : ResultList("GamesResult", R.drawable.ic_new, "Fifa Result")
    object CreativeResult : ResultList("CreativeResult", R.drawable.ic_new, "Creative Result")

}
