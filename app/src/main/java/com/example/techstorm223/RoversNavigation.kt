package com.example.techstorm223

sealed class  RoversNavigation(var route: String, var icon: Int, var title: String){
    object RoCombat : RoversNavigation("roCombat", R.drawable.ic_new, "RoCombat")
    object RoNavigator : RoversNavigation("roNavigator", R.drawable.ic_new, "RoNavigator")
    object RoPicker : RoversNavigation("roPicker", R.drawable.ic_new, "RoPicker")
    object RoSoccer : RoversNavigation("roSoccer", R.drawable.ic_new, "RoSoccer")
    object RoTerrance : RoversNavigation("roTerrance", R.drawable.ic_new, "RoTerrance")
    object RoWings : RoversNavigation("roWings", R.drawable.ic_new, "RoWings")
    object RoCarrom : RoversNavigation("roCarrom", R.drawable.ic_new, "RoCarrom")
}