package com.example.techstorm223

sealed class GamesNavigattion(var route: String, var icon: Int, var title: String) {
    object Coc : GamesNavigattion("coc", R.drawable.ic_new, "Coc")
    object Fifa : GamesNavigattion("fifa", R.drawable.ic_new, "Fifa")
    object Knet : GamesNavigattion("knet", R.drawable.ic_new, "Knet")
    object NeedForSpeed : GamesNavigattion("needForSpeed", R.drawable.ic_new, "NeedForSpeed")
}