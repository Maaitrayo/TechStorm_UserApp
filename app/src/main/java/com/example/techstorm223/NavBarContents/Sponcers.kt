package com.example.techstorm223.NavBarContents

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.techstorm223.R

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
        modifier= Modifier.padding(5.dp,0.dp,0.dp,0.dp),
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
    Spacer(modifier = Modifier.size(5.dp))

}
