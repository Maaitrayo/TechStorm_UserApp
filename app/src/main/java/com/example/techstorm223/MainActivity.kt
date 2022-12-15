package com.example.techstorm223

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.End
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*



import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import com.example.techstorm223.R
import androidx.compose.ui.graphics.Shape
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.textInputServiceFactory
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

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
fun ResultsScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Results Screen",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

    }
}
data  class SponcersData(
    val imgUri:Int
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SponcersScreen(){
    val sponcersvals = listOf(
        SponcersData(R.drawable.image_1),
        SponcersData(R.drawable.image_2),
        SponcersData(R.drawable.image_3),
        SponcersData(R.drawable.image_4),
        SponcersData(R.drawable.image_5),
    )
    LazyVerticalGrid(cells = GridCells.Fixed(2)){

        items(sponcersvals) {data->
            SponcerItem(data)

        }
    }
}
@Composable
fun SponcerItem(data : SponcersData){
    Card(
        modifier=Modifier.padding(0.dp,0.dp,0.dp,0.dp)
    ) {
        val imageModifier = Modifier
            .size(250.dp)

        Image(
            painter = painterResource(id = data.imgUri),
            contentDescription = null,
            modifier = imageModifier
        )
    }
    Spacer(modifier = Modifier.size(5.dp))

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

data  class EventDomainData(
    val id:Long,
    val title :String,
    val rating : Float,
    val desc :String,
    val imgUri:Int
)


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DevelopersScreen() {
    val context = LocalContext.current
    val dataFileString = getJsonDataFromAsset(context,"DevList.json")
    val gson = Gson()
    val gridSampleType = object : TypeToken<List<EventDomainData>>(){}.type
    val DevData : List<EventDomainData> = gson.fromJson(dataFileString,gridSampleType)
    /*Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp) */
    LazyVerticalGrid(cells = GridCells.Fixed(2)){


        items(DevData) {data->
            DataItem(data)
            /*Card(

            ) {
                val imageModifier = Modifier
                    .size(250.dp)

                Image(
                    painter = painterResource(id = R.drawable.image_1),
                    contentDescription = null,
                    modifier = imageModifier
                )
                Column(modifier = Modifier.padding(5.dp)) {
                    Text("Maaitrayo Das", fontWeight = FontWeight.W700)
                    Text("+0 12345678")
                    Text("XYZ city", fontWeight = FontWeight.W300)

                }
            }


Card(

) {
 val imageModifier = Modifier
     .size(250.dp)
 Image(
     painter = painterResource(id = R.drawable.image_1),
     contentDescription = null,
     modifier = imageModifier
 )
 Column(modifier = Modifier.padding(5.dp)) {
     Text("Dipnarayan Sen", fontWeight = FontWeight.W700)
     Text("+0 12345678")
     Text("XYZ city", fontWeight = FontWeight.W300)

 }
}



             Card(

             ) {
                 val imageModifier = Modifier
                     .size(250.dp)
                 Image(
                     painter = painterResource(id = R.drawable.image_1),
                     contentDescription = null,
                     modifier = imageModifier
                 )
                 Column(modifier = Modifier.padding(5.dp)) {
                     Text("Anushka Mukherjee", fontWeight = FontWeight.W700)
                     Text("+0 12345678")
                     Text("XYZ city", fontWeight = FontWeight.W300)

                 }
             }
*/
        }
    }
}
@Composable
fun DataItem(data : EventDomainData){
    Card(
        modifier=Modifier.padding(5.dp,5.dp,5.dp,5.dp)
    ) {
        val imageModifier = Modifier
            .size(250.dp)

        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = null,
            modifier = imageModifier
        )
        Column(modifier = Modifier.padding(5.dp)) {
            Box(modifier = Modifier) {
                Text("${data.title}", fontWeight = FontWeight.W300)
                //  Text("${data.desc}")

            }
        }
    }
    Spacer(modifier = Modifier.size(5.dp))

}





//----------------------------------------------------------HOME SCREEN------------------------------------------------------------

data class homedataobject(
    val imgUri: Int,
    val route : String,
    val text : String
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val homedata = listOf(
        homedataobject(R.drawable.image_1, NavigationItem.BrainTeasersList.route, "Brain Teasers"),
        homedataobject(R.drawable.image_2, NavigationItem.IdeaPresentation.route, "Idea Presentation"),
        homedataobject(R.drawable.image_3, NavigationItem.Rovers_List.route, "Rovers"),
        homedataobject(R.drawable.image_4, NavigationItem.GamesList.route, "Games"),
        homedataobject(R.drawable.image_5, NavigationItem.CreativeList.route, "Creative"),
    )
    LazyVerticalGrid(cells = GridCells.Fixed(1)) {

        items(homedata) { data ->
            HomeItem(data,navController)

        }
    }
}

@Composable
fun HomeItem(data : homedataobject,navController: NavHostController) {
    Card(
        modifier = Modifier.padding(10.dp,10.dp,10.dp,10.dp).fillMaxSize(0.7f)
    ) {
        Box(
            modifier = Modifier

                .clip(RoundedCornerShape(30.dp))
                .fillMaxWidth()
                .background(Color.White)
//            .clickable {
//                navController.navigate(data.route)
//            }
        ) {
            Image(modifier = Modifier.clip(RoundedCornerShape(30.dp)),
                painter = painterResource(
                    id = data.imgUri
                ), contentDescription = "Null"
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(color = Color.Gray)
                    .fillMaxWidth()
            ) {

                Text(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    text = data.text,
                    fontSize = 26.sp

                )
                Spacer(Modifier.size(20.dp))

            }
        }
        Spacer(Modifier.size(20.dp))
    }
}



//---------------------------------------------BRAIN TEASERS PART--------------------------------------------------
@Composable
fun Appmania(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Appmania",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
                fontSize = 30.sp
            )
        }

    }

}
@Composable
fun Fantac(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Fantac",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
            )
        }
    }
}
@Composable
fun Omegatrix(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Omegatrix",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
            )
        }
    }
}
@Composable
fun Technomania(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Technomania",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
            )
        }
    }
}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BrainTeasersList(navController: NavHostController) {
    val homedata = listOf(
        homedataobject(R.drawable.image_1, NavigationItem.Appmania.route, "APP MANIA"),
        homedataobject(R.drawable.image_2, NavigationItem.Fantac.route, "FANTA-C"),
        homedataobject(R.drawable.image_3, NavigationItem.Omegatrix.route, "OMEGATRIX"),
        homedataobject(R.drawable.image_4, NavigationItem.Technomania.route, "TECHNOMANIA"),

        )
    LazyVerticalGrid(cells = GridCells.Fixed(1)) {

        items(homedata) { data ->
            HomeItem(data, navController)

        }
    }
}


/*--------------------------------------------IDEA PRESENTATION PART---------------------------------------------------*/


@Composable
fun IdeaPresentation(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Idea Presentation",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
            )
        }

    }
}




//-----------------------------------------------ROVERS ---------------------------------------------------------------------------
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
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
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
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
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
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
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
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
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
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
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
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
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
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RoversList(navController: NavHostController){
    val homedata = listOf(
        homedataobject(R.drawable.image_1, NavigationItem.RoCombat.route, "RO-COMBAT"),
        homedataobject(R.drawable.image_2, NavigationItem.RoNavigator.route, "RO-NAVIGATOR"),
        homedataobject(R.drawable.image_3, NavigationItem.RoPicker.route, "RO-PICKER"),
        homedataobject(R.drawable.image_4, NavigationItem.RoSoccer.route, "RO-SOCCER"),
        homedataobject(R.drawable.image_5, NavigationItem.RoTerrance.route, "RO-TERRANCE"),
        homedataobject(R.drawable.image_1, NavigationItem.RoTerrance.route, "RO-WINGS"),
        homedataobject(R.drawable.image_2, NavigationItem.RoCarrom.route, "RO-CARROM"),

        )
    LazyVerticalGrid(cells = GridCells.Fixed(1)) {

        items(homedata) { data ->
            HomeItem(data, navController)

        }
    }
}


//--------------------------------------------------------Games-------------------------------------------------------
@Composable
fun NeedForSpeed(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Need For Speed",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
            )
        }
    }
}
@Composable
fun Knet(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Knet",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
            )
        }
    }
}
@Composable
fun Coc(navController: NavHostController){

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Coc",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
            )
        }
    }
}
@Composable
fun Fifa(navController: NavHostController){

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Fifa",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GamesList(navController: NavHostController){
    val homedata = listOf(
        homedataobject(R.drawable.image_1, NavigationItem.NeedForSpeed.route, "NEED FOR SPEED"),
        homedataobject(R.drawable.image_2, NavigationItem.Knet.route, "KNET"),
        homedataobject(R.drawable.image_3, NavigationItem.Coc.route, "CLASH OF CLANS"),
        homedataobject(R.drawable.image_4, NavigationItem.Fifa.route, "FIFA"),
    )
    LazyVerticalGrid(cells = GridCells.Fixed(1)) {

        items(homedata) { data ->
            HomeItem(data, navController)

        }
    }
}


//----------------------------------------------------Creative---------------------------------------------
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
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
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
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register",
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
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        val context = LocalContext.current
        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))

        OutlinedButton(onClick = { context.startActivity(webIntent) }, modifier = Modifier.padding(8.dp)) {
            Text( text = "Register"
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CreativeList(navController: NavHostController){
    val homedata = listOf(
        homedataobject(R.drawable.image_1, NavigationItem.Exposcience.route, "EXPOSCIENCE"),
        homedataobject(R.drawable.image_2, NavigationItem.MmLive.route, "35MM LIVE"),
        homedataobject(R.drawable.image_3, NavigationItem.PassionWithReels.route, "PASSION WITH REELS"),
    )
    LazyVerticalGrid(cells = GridCells.Fixed(1)) {

        items(homedata) { data ->
            HomeItem(data, navController)

        }
    }
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