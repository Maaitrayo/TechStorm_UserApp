package com.example.techstorm_2023.HomeScreenContent

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.techstorm_2023.HomeItem
import com.example.techstorm_2023.navigation.*
//import com.example.techstorm223.NavigationItem
import com.example.techstorm_2023.R
import com.example.techstorm_2023.homedataobject


@Composable
fun Exposcience(navController: NavHostController){

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Exposcience",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp).clip(RoundedCornerShape(30.dp)),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)) {
            Text( text = "Register",
                fontSize = 30.sp
            )
        }
    }
}
@Composable
fun MmLive(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "35mm Live",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp).clip(RoundedCornerShape(30.dp)),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)) {
            Text( text = "Register",
                fontSize = 30.sp
            )
        }
    }
}
@Composable
fun PassionWithReels(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Passion With Reels",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp).clip(
            RoundedCornerShape(30.dp)
        ),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)) {
            Text( text = "Register",
                fontSize = 30.sp
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CreativeList(navController: NavHostController){
    val homedata = listOf(
        homedataobject(R.drawable.image_1, NavigationHomeItems.Exposcience.route, "EXPOSCIENCE"),
        homedataobject(R.drawable.image_2, NavigationHomeItems.MmLive.route, "35MM LIVE"),
        homedataobject(R.drawable.image_3, NavigationHomeItems.PassionWithReels.route, "PASSION WITH REELS"),
    )
    val scrallablestate = rememberScrollState()


    Column(modifier = Modifier.verticalScroll(scrallablestate).fillMaxWidth()) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        for(data in homedata) {
            HomeItem(data,navController, selected = currentRoute == data.route, onItemClick = {
                navController.navigate(data.route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }

//                scope.launch {
//                    scaffoldState.drawerState.close()
//                }
            })
        }
    }
}

