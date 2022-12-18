package com.example.techstorm223.HomeScreenContent

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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

