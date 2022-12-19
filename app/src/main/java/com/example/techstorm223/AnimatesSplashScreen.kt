package com.example.techstorm223

import android.window.SplashScreenView
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navController: NavHostController){
    var startAnimation by remember{
        mutableStateOf(false)
    }
    val alphaAnim = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis= 3000
        )
    )
    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(NavigationItem.Home.route)
    }
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha : Float){
    Box(modifier = Modifier
        .background(if (isSystemInDarkTheme()) Color.Blue else Color.Black)
        .fillMaxSize(),
        contentAlignment = Alignment.Center


    )

    {
//        Text(
//            text = "Welcome To"
//        )
//        Spacer(modifier = Modifier.size(10.dp))
//        Text(
//            text = "Techstorm 2.23"
//        )
//        Spacer(modifier = Modifier.size(10.dp))
        Icon(
            modifier = Modifier.size(12.dp)
                .alpha(alpha=alpha),
            imageVector = Icons.Default.Email,
            contentDescription = "Logo Icon",
            tint = Color.White
        )
    }
}




//
//@Composable
//@Preview
//fun SplashScreenPreview()
//{
//    Splash(alpha = 1f)
//}








