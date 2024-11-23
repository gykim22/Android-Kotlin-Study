
# JetPack Compose Column/Row/Box
![image (2)](https://github.com/user-attachments/assets/3e2c60ee-be65-401c-9c96-6827eca2393b)

- Box: 위젯을 다른 항목의 위에 배치. FrameLayout과 동일
- Column: 위젯을 화면에 수직(vertical) 순서로 배치. LinearLayout(orientation=vertical)과 동일
- Row: 위젯을 화면에 수평(horizontal) 순서로 배치. LinearLayout(orientation=horizontal)과 동일
- BoxWithConstraints : Box의 기능을 확장하여 레이아웃 Constraint(최대 크기, 최소 크기)에 접근할 수 있도록 만든 레이아웃
- ConstraintLayout: 위젯을 다른 위젯의 위치에 상대적으로 배치. 기존 ConstraintLayout과 동일

## Column

```kotlin
@Preview
@Composable
fun ColumnComposable(
	modifier = Modifier.fillMaxWidth()
){
    Column() {  // C 대문자. 괄호 붙이고 그 다음 중괄호 형식.
        Text(text = "Hello")
        Text(text = "World")
    }
} // 화면에 수직(vertical) 순서로 배치하는 레이아웃
```

- Column은 총 4가지 변수를 인자로 받음
    - modifier : composable의 크기, 동작, 모양을 변경하거나 사용자의 입력을 처리(클릭, 스크롤 등)할 수 있도록 만드는 변수
    - verticalArrangement(Arrangement.Vertical 타입) : 수직 배치(Arrangement)를 설정하는 변수
    - horizontalAlignment(Alignment.Horizontal 타입) : 수평 정렬(Alignment)을 설정하는 변수
    - content :  [Layout](https://www.notion.so/Column-Row-Box-146f39afe33880ab9340c577708addb0?pvs=21) 안에 들어갈 위젯을 설정하는 변수

## Row

```kotlin
@Preview(
@Composable
fun RowComposable() {
    Row() {
        Text(text = "Hello")
        Text(text = "World")
    }
}
```

```
modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    content: @Composable RowScope.() -> Unit
```

- Row는 총 4가지 변수를 인자로 받음
    - modifier : composable의 크기, 동작, 모양을 변경하거나 사용자의 입력을 처리(클릭, 스크롤 등)할 수 있도록 만드는 변수
    - horizontalArrangement(Arrangement.Horizontal) : 수평 배치를 설정하는 변수
        - Arrangement.Start, Center, End, SpaceBetween, SpaceAround, SpaceEvenly
            - Arrangement.SpaceBetween : 컴포넌트들 간의 간격은 동일(x), 양쪽 끝과 컴포넌트 사이의 빈 공간이 0
            - Arrangement.SpaceAround : 컴포넌트들 간의 간격은 동일(x), 양쪽 끝과 컴포넌트 사이의 빈 공간이 (x/2)
            - Arrangement.SpaceEvenly : 컴포넌트들 간의 간격은 동일(x), 양쪽 끝과 컴포넌트 사이의 빈 공간이 컴포넌트 사이의 공간과 동일(x)
    - verticalAlignment(Alignment.Vertical) : 수직 정렬을 설정하는 변수
        - Alignment.Top, Bottom, CenterVertically
    - content : Layout 안에 들어갈 위젯을 설정하는 변수
- 주의
    - Row Layout은 Column Layout과 비슷한 변수를 인자로 받는다.
    - 다른 점은 Column Layout의 Arrangement.Vertical, Alignment.Horizontal 대신
    Row는 Arrangement.Horizontal, Alignment.Vertical을 인자로 받는다는 것

# Box

```kotlin
@Preview(showBackground = true, widthDp = 120, heightDp = 200)
@Composable
fun BoxComposable() {
    Box {
        Text(modifier = Modifier.align(Alignment.TopStart), text = "Kotlin")
        Text(modifier = Modifier.align(Alignment.Center), text = "World")
        Text(modifier = Modifier.align(Alignment.BottomEnd), text = "Blog")
    }
}

```
- 여러 위젯를 겹쳐서 놓을 수 있는 레이아웃
    - Box 내부의 Child Compose들은 Modifier.align에 자신의 위치를 지정함으로써 Box 내부의 어떤 공간에 보여질 지 결정할 수 있음.
    - 두 개의 위젯을 같은 위치로 설정하면  위젯 위에 다른 위젯 겹쳐 지는 것 또한 가능
- Box는 총 4가지 변수를 인자로 받음
    - modifier(수정자) : 박스의 크기, 클릭 이벤트 등을 정의 가능
    - contentAlignment : 자식의 기본 정렬 방식을 결정
    - propagateMinConstraints : 최소 제약 조건을 전파시키는지 여부
    - content : Box 레이아웃에 들어갈 레이아웃과 위젯이 람다식으로 들어가는 부분
