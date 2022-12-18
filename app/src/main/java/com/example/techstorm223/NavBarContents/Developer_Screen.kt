package com.example.techstorm223.NavBarContents

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.techstorm223.R
import com.example.techstorm223.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


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

        }
    }
}
@Composable
fun DataItem(data : EventDomainData){
    Card(
        modifier= Modifier.padding(5.dp,5.dp,5.dp,5.dp).background(Color.Black),
        backgroundColor = Color.Black
    ) {
        val imageModifier = Modifier
            .size(250.dp)

        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = null,
            modifier = imageModifier

        )
        Column(modifier = Modifier.padding(5.dp).background(Color.Black)) {
            Box(modifier = Modifier.background(Color.Black)) {
                Text("${data.title}", fontWeight = FontWeight.W300, color = Color.White)
                //  Text("${data.desc}")

            }
        }
    }
//    Spacer(modifier = Modifier.size(5.dp))

}

