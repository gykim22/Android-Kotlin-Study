package com.example.studyAndroid.template

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "loginScreen" ){
        composable("loginScreen"){login(navController)}
        composable("splashScreen"){splashScreen(navController)}
    }
}
