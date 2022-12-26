package com.example.techstorm_2023


//NEW

import com.example.techstorm_2023.NavBarContents.*
import com.example.techstorm_2023.HomeScreenContent.*


import android.content.Context

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
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
import com.example.techstorm_2023.navigation.*



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Navigation(navController = navController,NavigationItem.AnimatedSplashScreen.route)
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
        backgroundColor = Color.Black,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState) },
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        }
    )
    {
        Navigation(navController = navController, startDestination = NavigationItem.Home.route)
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
        NavigationItem.ResultScreen,
        NavigationItem.Sponcers,
        NavigationItem.Developers,
        NavigationItem.Aboutus,
        NavigationItem.PhotoGallery,
        NavigationItem.Announcement
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
            color = Color.White,
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
            text = "About Us Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Gray,
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
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

    }
}@Composable
fun AnnouncementScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Announcement Screen",
            fontWeight = FontWeight.Bold,
            color = Color.White,
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
        modifier=Modifier.padding(2.dp,2.dp,2.dp,2.dp),
        backgroundColor = Color.Black
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
fun Navigation(navController: NavHostController,startDestination : String){
    NavHost(navController, startDestination = startDestination){
        composable(NavigationItem.AnimatedSplashScreen.route){
            AnimatedSplashScreen(navController)
        }
        composable(NavigationItem.MainScreen.route){
            MainScreen()
        }
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
        composable(NavigationHomeItems.Rovers_List.route){
            RoversList(navController)
        }
        composable(RoversNavigation.RoCombat.route){
            RoCombat(navController)
        }
        composable(RoversNavigation.RoNavigator.route){
            RoNavigator(navController)
        }
        composable(RoversNavigation.RoPicker.route){
            RoPicker(navController)
        }
        composable(RoversNavigation.RoSoccer.route){
            RoSoccer(navController)
        }
        composable(RoversNavigation.RoTerrance.route){
            RoTerrance(navController)
        }
        composable(RoversNavigation.RoWings.route){
            RoWings(navController)
        }
        composable(RoversNavigation.RoCarrom.route){
            RoCarrom(navController)
        }




        //Brain Teasers Section
        composable(NavigationHomeItems.BrainTeasersList.route){
            BrainTeasersList(navController)
        }

        composable(BrainTeasersNavigation.Appmania.route){
            Appmania(navController)
        }
        composable(BrainTeasersNavigation.Fantac.route){
            Fantac(navController)
        }
        composable(BrainTeasersNavigation.Omegatrix.route){
            Omegatrix(navController)
        }
        composable(BrainTeasersNavigation.Technomania.route){
            Technomania(navController)
        }


        //GamesSection
        composable(NavigationHomeItems.GamesList.route){
            GamesList(navController)
        }

        composable(GamesNavigattion.NeedForSpeed.route){
            NeedForSpeed(navController)
        }
        composable(GamesNavigattion.Knet.route){
            Knet(navController)
        }
        composable(GamesNavigattion.Coc.route){
            Coc(navController)
        }
        composable(GamesNavigattion.Fifa.route){
            Fifa(navController)
        }





        //Idea Presentation Section
        composable(NavigationItem.IdeaPresentation.route){
            IdeaPresentation(navController)
        }



        //Creative
        composable(NavigationHomeItems.CreativeList.route){
            CreativeList(navController)
        }
        composable(NavigationHomeItems.PassionWithReels.route){
            PassionWithReels(navController)
        }
        composable(NavigationHomeItems.MmLive.route){
            MmLive(navController)
        }
        composable(NavigationHomeItems.Exposcience.route){
            Exposcience(navController)
        }

        composable(NavigationItem.Sponcers.route){

            val scrallablestate = rememberScrollState()
            Column(modifier = Modifier
                .verticalScroll(scrallablestate)
                .fillMaxWidth()) {
                    SponcerItem(SponcersData(R.drawable.image_1))
                    SponcerItem(SponcersData(R.drawable.image_2))
                    SponcerItem(SponcersData(R.drawable.image_3))
                    SponcerItem(SponcersData(R.drawable.image_4))
                    SponcerItem(SponcersData(R.drawable.image_5))
            }
        }
        //Result
        composable(NavigationItem.ResultScreen.route){
            ResultsScreen()
        }
        composable(NavigationItem.Announcement.route){
            AnnouncementScreen()
        }

        composable(NavigationItem.Developers.route){
            DevelopersScreen()
        }
        composable(NavigationItem.Aboutus.route){
            AboutusScreen()
        }

    }

}