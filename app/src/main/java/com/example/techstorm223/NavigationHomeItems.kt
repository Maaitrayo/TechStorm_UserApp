package com.example.techstorm223

sealed class NavigationHomeItems(var route: String, var icon: Int, var title: String) {
    object BrainTeasersList : NavigationHomeItems("brainTeasersList List2", R.drawable.ic_new, "BrainTeasersList")
    object IdeaPresentation : NavigationHomeItems("ideaPresentation", R.drawable.ic_new, "IdeaPresentation")
    object Rovers_List : NavigationHomeItems("Rovers List", R.drawable.ic_new, "Rovers_List")
    object GamesList : NavigationHomeItems("gamesList", R.drawable.ic_new, "GamesList")
    object CreativeList : NavigationHomeItems("creativeList", R.drawable.ic_new, "CreativeList")
    object Exposcience : NavigationHomeItems("exposcience", R.drawable.ic_new, "Exposcience")
    object PassionWithReels : NavigationHomeItems("passionWithReels", R.drawable.ic_new, "PassionWithReels")
    object MmLive : NavigationHomeItems("mmLive", R.drawable.ic_new, "MmLive")
}