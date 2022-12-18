package com.example.techstorm223.HomeScreenContent

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.example.techstorm223.R
import com.example.techstorm223.RoversNavigation
import com.example.techstorm223.ui.theme.Purple700

@Composable
fun RoCombat(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "RoCombat",
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
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
@Composable
fun RoNavigator(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "RoNavigator",
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
fun RoPicker(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "RoPicker",
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
fun RoSoccer(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "RoSoccer",
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
fun RoTerrance(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Ro-Terrance",
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
fun RoWings(navController: NavHostController){

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Ro-Wings",
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
fun RoCarrom(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Ro-Carrom",
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RoversList(navController: NavHostController){
    val homedata = listOf(
        homedataobject(R.drawable.image_1, RoversNavigation.RoCombat.route, "RO-COMBAT"),
        homedataobject(R.drawable.image_2, RoversNavigation.RoNavigator.route, "RO-NAVIGATOR"),
        homedataobject(R.drawable.image_3, RoversNavigation.RoPicker.route, "RO-PICKER"),
        homedataobject(R.drawable.image_4, RoversNavigation.RoSoccer.route, "RO-SOCCER"),
        homedataobject(R.drawable.image_5, RoversNavigation.RoTerrance.route, "RO-TERRANCE"),
        homedataobject(R.drawable.image_1, RoversNavigation.RoTerrance.route, "RO-WINGS"),
        homedataobject(R.drawable.image_2, RoversNavigation.RoCarrom.route, "RO-CARROM"),

        )
    LazyVerticalGrid(cells = GridCells.Fixed(1)) {

        items(homedata) { data ->
            HomeItem(data, navController)

        }
    }
}
