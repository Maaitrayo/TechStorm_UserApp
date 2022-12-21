package com.example.techstorm223

sealed class
NavigationItem(var route: String, var icon: Int, var title: String)
{

    object AnimatedSplashScreen : NavigationItem("animatedSplashScreen",R.drawable.ic_home, "AnimatedSplashScreen")
    object MainScreen : NavigationItem("mainScreen",R.drawable.ic_home, "MainScreen")
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object Schedule : NavigationItem("schedule", R.drawable.ic_schedule, "Schedule")
    object ResultScreen: NavigationItem("ResultScreen", R.drawable.ic_results, "Results")
    object Team : NavigationItem("team", R.drawable.ic_team, "Team")
    object Sponcers : NavigationItem("sponcers", R.drawable.ic_sponcers, "Sponcers")
    object Aboutus : NavigationItem("aboutus", R.drawable.ic_aboutus, "About Us")
    object Announcement : NavigationItem("Announcement", R.drawable.ic_announcement, " Anouncement")

    object Share : NavigationItem("share", R.drawable.ic_share, "Share")
    object Contact : NavigationItem("contact", R.drawable.ic_contact, "Contact")
    object Developers : NavigationItem("developers", R.drawable.ic_dev, "Developers")

    object IdeaPresentation : NavigationItem("ideaPresentation", R.drawable.ic_new, "IdeaPresentation")
    object Gallery : NavigationItem("gallery", R.drawable.ic_gallery, "Gallery")
    object PhotoGallery : NavigationItem("photoGallery", R.drawable.ic_gallery, "PhotoGallery")

}