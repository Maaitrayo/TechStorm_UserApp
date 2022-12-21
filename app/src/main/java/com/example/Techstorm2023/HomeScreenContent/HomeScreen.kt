package com.example.Techstorm2023.HomeScreenContent

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.Techstorm2023.NavigationHomeItems
import com.example.Techstorm2023.R

data class homedataobject(
    val imgUri: Int,
    val route : String,
    val text : String
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val homedata = listOf(
        homedataobject(R.drawable.image_1, NavigationHomeItems.BrainTeasersList.route, "Brain Teasers"),
        homedataobject(R.drawable.image_2, NavigationHomeItems.IdeaPresentation.route, "Idea Presentation"),
        homedataobject(R.drawable.image_3, NavigationHomeItems.Rovers_List.route, "Rovers"),
        homedataobject(R.drawable.image_4, NavigationHomeItems.GamesList.route, "Games"),
        homedataobject(R.drawable.image_5, NavigationHomeItems.CreativeList.route, "Creative"),
    )

    val scrallablestate = rememberScrollState()


    Column(modifier = Modifier.verticalScroll(scrallablestate).fillMaxWidth()) {
        for(data in homedata) {
            HomeItem(data,navController)
        }
    }
}

@Composable
fun HomeItem(data : homedataobject,navController: NavHostController) {
    Card(
        modifier = Modifier.padding(10.dp,10.dp,10.dp,10.dp)
            .fillMaxWidth()
            .fillMaxSize(0.7f)
            .background(Color.Black)
            .clip(RoundedCornerShape(30.dp)),
        backgroundColor = Color.Black
    ) {
        Box(
            modifier = Modifier

                .clip(RoundedCornerShape(30.dp))
                .fillMaxWidth()
                .background(Color.Black)
                .clickable {
                    navController.navigate(data.route)
                }
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

