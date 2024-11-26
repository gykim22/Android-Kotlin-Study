package com.example.studyAndroid.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.studyAndroid.ui.theme._studyAndroidTheme

@Composable
fun login(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column() {
            Icon(imageVector = Icons.Default.AccountBox, contentDescription = "")
            Button(onClick = { navController.navigate("splashScreen") },
                modifier = Modifier
                    .padding(0.dp, 10.dp)) {
                Text("로그인")
            }
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun loginPreview() {
    val navController = rememberNavController()
    _studyAndroidTheme {
        login(navController)
    }
}
