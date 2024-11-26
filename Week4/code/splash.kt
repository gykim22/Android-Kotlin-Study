package com.example.studyAndroid.template

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studyAndroid.ui.theme._studyAndroidTheme

enum class Position {
    LEFT, CENTER, RIGHT
}

@Composable
fun splashScreen(navController: NavController) {
    // 다음의 변수를 활용하여 애니메이션을 줄 수 있습니다.
    var position by remember { mutableStateOf(Position.CENTER) }
    var isIconVisible by remember { mutableStateOf(false) }
    var isIconClicked by remember { mutableStateOf(false) }
    val alpha by animateFloatAsState(
        targetValue = if (isIconVisible) 0f else 1f,
        animationSpec = tween(durationMillis = 1500),
        label = ""
    )
    val offsetAnimation by animateDpAsState(
        targetValue = when (position) {
            Position.LEFT -> -100.dp
            Position.RIGHT -> 100.dp
            else -> 0.dp
        },
        animationSpec = tween(durationMillis = 1500)
    )

    SplashBackground {
        Box(
            modifier = Modifier
                .offset(x = offsetAnimation)
                .align(Alignment.Center)
                .alpha(alpha)
        ) {

            //Icons.Default.Home
            Text(
                text = "🏠",
                fontSize = 100.sp
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(0.dp, 20.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(){ // 동일 로직 버튼이 여러 개면 따로 함수로 묶어줌.
                /*
                Button(onClick = { position = if (position == Position.LEFT) Position.CENTER else Position.LEFT },
                    modifier = Modifier.width(120.dp)) {
                    Text("왼쪽 이동")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { position = if (position == Position.RIGHT) Position.CENTER else Position.RIGHT },
                    modifier = Modifier.width(120.dp)) {
                    Text("오른쪽 이동")
                }

                 */
                sampleButton( onClick = { position = if (position == Position.LEFT) Position.CENTER else Position.LEFT },"왼쪽 이동")
                sampleButton( onClick = { position = if (position == Position.RIGHT) Position.CENTER else Position.RIGHT },"오른쪽 이동")
            }

            Row(){
                /*
                Button(onClick = { isIconVisible = false },
                    modifier = Modifier.width(120.dp)) {
                    Text("나타나기")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = { isIconVisible = true },
                    modifier = Modifier.width(120.dp)) {
                    Text("사라지기")
                }
                 */
                sampleButton( onClick= {isIconVisible = false},"나타나기")
                sampleButton( onClick= {isIconVisible = true},"사라지기")

            }
            Row(){
                sampleButton( onClick = { navController.navigate("loginScreen") },"화면 전환")
            }
        }

    }
}

@Composable
fun sampleButton(onClick:()->Unit,text:String){
    Button(onClick = onClick,
        modifier = Modifier.width(120.dp)) {
        Text(text)
    }
}

@Composable
private fun SplashBackground(content: @Composable BoxScope.() -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        content = content
    )
}
