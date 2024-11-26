package com.example.studyAndroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyAndroid.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Profile("Kim Giyun")
                }
            }
        }
    }
}

@Composable
fun Profile(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize() // 컬럼 내 전체 채움
            .padding(16.dp) // 모든 방향에 16dp의 여백
    ) {
        Row( // 프로필, 텍스트 가로 정렬
            verticalAlignment = Alignment.CenterVertically, // 세로 방향으로 중앙 정렬
            modifier = Modifier.padding(bottom = 16.dp) // Row 하단에 16dp 여백
        ) {
            Image(
                painter = painterResource(id = R.drawable.kimgiyun), // 이미지 로딩 함수
                contentDescription = "프로필", // 이미지 설명
                modifier = Modifier
                    .size(50.dp) // 이미지 크기 50dp
                    .clip(CircleShape), // 원형 쉐이핑
                contentScale = ContentScale.Crop // 원형 프레임에 맞게 이미지 삽입
            )

            Spacer(modifier = Modifier.width(8.dp)) // 프로필 사진, 텍스트 간 가로 여백 8dp

            Column { //  프로필 사진 옆에 이름, 포스팅 시간 세로 배치
                Text(
                    text = name, // name 파라미터 사용
                    fontWeight = FontWeight.Bold, // 볼드체
                    fontSize = 18.sp // 18sp.
                )
                Text(
                    text = "3 minutes ago",
                    fontSize = 14.sp
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "피드 사진",
            modifier = Modifier
                .fillMaxWidth() // 컬럼 하단에 전체 채움
                .height(200.dp) // 높이 200dp
                .clip(MaterialTheme.shapes.medium), // 모서리 부드럽게 컷팅
            contentScale = ContentScale.Crop // 프레임에 이미지 맞추기
        )

        Text(
            text = "hi everyone",
            fontWeight = FontWeight.Thin,
            fontSize = 16.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    MyApplicationTheme {
        Profile("Kim Giyun")
    }
}
