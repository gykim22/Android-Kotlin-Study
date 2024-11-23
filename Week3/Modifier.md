# Modifier
- Modifier은 composable의 크기, 동작, 모양을 변경하거나 사용자의 입력을 처리(클릭, 스크롤 등)할 수 있도록 만드는 변수
- modifier = Modifier로 작성.
## Width/Height
- Modifier.width(200.dp) : 너비를 width.dp로 설정. ~.dp로 씀.
- Modifier.height(200.dp) : 높이를 height.dp로 설정
## fillMax
- Modifier.fillMaxWidth(0.6f) : 너비(가로) 60% 채우기
    - 기본은 모두 채우는 것(fraction = 1f)이며 전체 대비 채우는 비율을 설정하는 것도 가능
- Modifier.fillMaxHeight(fraction: Float = 1f) : 높이(세로) 전체 채우기
    - 기본은 모두 채우는 것(fraction = 1f)이며 전체 대비 채우는 비율을 설정하는 것도 가능
- Modifier.fillMaxSize(fraction: Float = 1f) : 너비, 높이 모두 전체 채우기
    - 기본은 모두 채우는 것(fraction = 1f)이며 전체 대비 채우는 비율을 설정하는 것도 가능
## padding
- Modifier.padding
    - padding은 자신을 기준으로 안쪽으로 얼만큼 공간을 비워놓을 건지 결정하는 값
    - Modifier.padding(start: Dp = 0.dp, top: Dp = 0.dp, end: Dp = 0.dp, bottom: Dp = 0.dp)
    - Modifier.padding(horizontal: Dp = 0.dp, vertical: Dp = 0.dp)
    - Modifier.padding(30.dp) ← 전부 줌.
## background
- Modifier.background → 2가지 응용이 존재
    - color과 shape -> 배경색 및 모양 제작
    - brush와 shape, alpha -> 그라데이션 처리
      
