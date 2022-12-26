package com.example.techstorm_2023.navigation

import com.example.techstorm_2023.R

sealed class BrainTeasersNavigation(var route: String, var icon: Int, var title: String) {

    object Appmania : BrainTeasersNavigation("appmania", R.drawable.ic_new, "Appmania")
    object Fantac : BrainTeasersNavigation("fantac", R.drawable.ic_new, "Fantac")
    object Omegatrix : BrainTeasersNavigation("omegatrix", R.drawable.ic_new, "Omegatrix")
    object Technomania : BrainTeasersNavigation("echnomania", R.drawable.ic_new, "Technomania")
}