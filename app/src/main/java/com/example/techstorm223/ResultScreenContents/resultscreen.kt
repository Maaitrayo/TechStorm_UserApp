package com.example.techstorm223.ResultScreenContents

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
import com.example.techstorm223.R

data class resultobject(
    val imgUri: Int,
    val route : String,
    val text : String
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ResultScreen(navController: NavHostController) {
    val resultdata = listOf(
        resultobject(R.drawable.image_1, ResultList.BrainTeasersResult.route, "Brain Teasers Result"),
        resultobject(R.drawable.image_2, ResultList.IdeaPresentationResult.route, "Idea Presentation Result"),
        resultobject(R.drawable.image_3, ResultList.RoversResult.route, "Rovers Result"),
        resultobject(R.drawable.image_4, ResultList.GamesResult.route, "Games Result"),
        resultobject(R.drawable.image_5, ResultList.CreativeResult.route, "Creative Result")
    )

    LazyVerticalGrid(cells = GridCells.Fixed(1)) {
        items(resultdata) { data ->
            ResultItem(data,navController)
        }
    }
}

@Composable
fun ResultItem(data : resultobject, navController: NavHostController) {
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

