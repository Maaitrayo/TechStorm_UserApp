package com.example.techstorm223.HomeScreenContent

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
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
import com.example.techstorm223.NavigationHomeItems
import com.example.techstorm223.NavigationItem
import com.example.techstorm223.R

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

    LazyVerticalGrid(cells = GridCells.Fixed(1)) {
        items(homedata) { data ->
            HomeItem(data,navController)
        }
    }
}

@Composable
fun HomeItem(data : homedataobject,navController: NavHostController) {
    Card(
        modifier = Modifier.padding(10.dp,10.dp,10.dp,10.dp)
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

