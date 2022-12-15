package com.example.techstorm223
import com.example.techstorm223.NavBarContents.*
import com.example.techstorm223.HomeScreenContent.*
import android.content.Context

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*


import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.material.Text

import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.items


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState) },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        }
    ) {
        Navigation(navController = navController)
    }

}

@Composable
fun TopBar(scope: CoroutineScope, scaffoldState: ScaffoldState){

    TopAppBar(
        title = { Text(text = "Tech Storm 2.23", fontSize = 18.sp) },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(Icons.Filled.Menu, "")
            }
        },
        backgroundColor = Color.Black,
        contentColor = Color.White
    )

}

@Composable
fun Drawer(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController){

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Schedule,
        NavigationItem.Results,
        NavigationItem.Sponcers,
        NavigationItem.Team,
        NavigationItem.Developers,
        NavigationItem.Aboutus,
        NavigationItem.PhotoGallery
    )

    Column(
        modifier = Modifier
            .background(color = Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color.Black),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(10.dp)
            )

        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
        )

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { items ->
            DrawerItem(item = items, selected = currentRoute == items.route, onItemClick = {

                navController.navigate(items.route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }

                scope.launch {
                    scaffoldState.drawerState.close()
                }

            })
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Tech Storm 2.23",
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally)
        )

    }

}

@Composable
fun DrawerItem(item: NavigationItem, selected: Boolean, onItemClick: (NavigationItem) -> Unit){
    val background = if(selected) R.color.grey else android.R.color.transparent
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(item) }
            .height(45.dp)
            .background(colorResource(id = background))
            .padding(start = 10.dp)
    ) {

        Image(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            colorFilter = ColorFilter.tint(Color.Black),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = item.title,
            fontSize = 16.sp,
            color = Color.Black
        )

    }

}


@Composable
fun ShareScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Share Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

    }
}
@Composable
fun ScheduleScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Schedule Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

    }
}
@Composable
fun AboutusScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Schedule Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

    }
}

@Composable
fun ContactScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Contact Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

    }
}
@Composable
fun TeamScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Team Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

    }
}

data  class GalleryData(
    val imgUri:Int
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PhotoGallery(){
    val galerry = listOf(
        GalleryData(R.drawable.img_gal_1),
        GalleryData(R.drawable.img_gal_2),
        GalleryData(R.drawable.img_gal_3),
        GalleryData(R.drawable.img_gal_4),
        GalleryData(R.drawable.img_gal_5),
        GalleryData(R.drawable.img_gal_6),
        GalleryData(R.drawable.img_gal_7),
        GalleryData(R.drawable.img_gal_8),
        GalleryData(R.drawable.img_gal_9),
        GalleryData(R.drawable.img_gal_10),
        GalleryData(R.drawable.img_gal_11),
        GalleryData(R.drawable.img_gal_12),
        GalleryData(R.drawable.img_gal_13),
        GalleryData(R.drawable.img_gal_14),
        GalleryData(R.drawable.img_gal_16),
        GalleryData(R.drawable.img_gal_17),
        GalleryData(R.drawable.img_gal_18),
        GalleryData(R.drawable.img_gal_19),
        GalleryData(R.drawable.img_gal_20),


        )
    LazyVerticalGrid(cells = GridCells.Fixed(2)){

        items(galerry) {data->
            PhotoItem(data)

        }
    }
}
@Composable
fun PhotoItem(data : GalleryData){
    Card(
        modifier=Modifier.padding(2.dp,2.dp,2.dp,2.dp)
    ) {
        val imageModifier = Modifier
            .size(250.dp)

        Image(
            painter = painterResource(id = data.imgUri),
            contentDescription = null,
            modifier = imageModifier
        )
    }

}

fun getJsonDataFromAsset(context: Context, data: String):String {
    return context.assets.open(data).bufferedReader().use { it.readText() }

}


@Composable
fun Navigation(navController: NavHostController){

    NavHost(navController, startDestination = NavigationItem.Home.route){

        composable(NavigationItem.Home.route){
            HomeScreen(navController)
        }
        composable(NavigationItem.Schedule.route){
            ScheduleScreen()
        }
        composable(NavigationItem.PhotoGallery.route){
            PhotoGallery()
        }



        //Rovers List Section
        composable(NavigationItem.Rovers_List.route){
            RoversList(navController)
        }
        composable(NavigationItem.RoCombat.route){
            RoCombat(navController)
        }
        composable(NavigationItem.RoNavigator.route){
            RoNavigator(navController)
        }
        composable(NavigationItem.RoPicker.route){
            RoPicker(navController)
        }
        composable(NavigationItem.RoSoccer.route){
            RoSoccer(navController)
        }
        composable(NavigationItem.RoTerrance.route){
            RoTerrance(navController)
        }
        composable(NavigationItem.RoWings.route){
            RoWings(navController)
        }
        composable(NavigationItem.RoCarrom.route){
            RoCarrom(navController)
        }




        //Brain Teasers Section
        composable(NavigationItem.BrainTeasersList.route){
            BrainTeasersList(navController)
        }

        composable(NavigationItem.Appmania.route){
            Appmania(navController)
        }
        composable(NavigationItem.Fantac.route){
            Fantac(navController)
        }
        composable(NavigationItem.Omegatrix.route){
            Omegatrix(navController)
        }
        composable(NavigationItem.Technomania.route){
            Technomania(navController)
        }


        //GamesSection
        composable(NavigationItem.GamesList.route){
            GamesList(navController)
        }

        composable(NavigationItem.NeedForSpeed.route){
            NeedForSpeed(navController)
        }
        composable(NavigationItem.Knet.route){
            Knet(navController)
        }
        composable(NavigationItem.Coc.route){
            Coc(navController)
        }
        composable(NavigationItem.Fifa.route){
            Fifa(navController)
        }





        //Idea Presentation Section
        composable(NavigationItem.IdeaPresentation.route){
            IdeaPresentation(navController)
        }



        //Creative
        composable(NavigationItem.CreativeList.route){
            CreativeList(navController)
        }
        composable(NavigationItem.PassionWithReels.route){
            PassionWithReels(navController)
        }
        composable(NavigationItem.MmLive.route){
            MmLive(navController)
        }
        composable(NavigationItem.Exposcience.route){
            Exposcience(navController)
        }


        composable(NavigationItem.Share.route){
            ShareScreen()
        }
        composable(NavigationItem.Team.route){
            TeamScreen()
        }

        composable(NavigationItem.Contact.route){
            ContactScreen()
        }
        composable(NavigationItem.Sponcers.route){
            SponcersScreen()
        }
        composable(NavigationItem.Results.route){
            ResultsScreen()
        }

        composable(NavigationItem.Developers.route){
            DevelopersScreen()
        }
        composable(NavigationItem.Aboutus.route){
            AboutusScreen()
        }

    }

}