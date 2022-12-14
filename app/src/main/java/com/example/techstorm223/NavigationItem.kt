package com.example.techstorm223

sealed class NavigationItem(var route: String, var icon: Int, var title: String)
{
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")

    object Schedule : NavigationItem("schedule", R.drawable.ic_schedule, "Schedule")

    object Settings : NavigationItem("settings", R.drawable.ic_settings, "Settings")
    object Share : NavigationItem("share", R.drawable.ic_share, "Share")
    object Contact : NavigationItem("contact", R.drawable.ic_contact, "Contact")
    object Developers : NavigationItem("developers", R.drawable.ic_new, "Developers")
    object Rovers_List : NavigationItem("Rovers List", R.drawable.ic_new, "Rovers_List")
    object Rovers_List2 : NavigationItem("Rovers List2", R.drawable.ic_new, "Rovers_List2")
}