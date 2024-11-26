# 1. Navigation

## 1-1. Defendencies

### 1-1-1. 전통적인 방식의 의존성 추가

```kotlin
// build.gradle.kts(Module: app)
...
dependencies {
	implementation("androidx.navigation:navigation-compose:2.7.7")
}
```

### 1-1-2. Gradle Version Catlog 방식의 의존성 추가
**Grade Version Catalog란?**

- 멀티 모듈 프로젝트에서 **의존성을 쉽게 공유하고 쉽게 관리할 수 있는 Gradle의 기능** 중 하나

**지원 버전**

- ≥ Gradle 7

**사용 이유**

1. 중앙 집중화
    1. 의존성 업데이트 시 각 프로젝트의 build.gradle에 하드코딩하던 기존 방식.
    2. 모든 의존성을 gradle/**`libs.versions.toml`** 에서 관리 가능한 catalog 방식.
2. 유지 보수성 향상
    1. 프로젝트 전체의 의존성을 **`libs.versions.toml`** 에서 한 눈에 확인
    2. 버전 변경 시 해당 파일에서 쉽게 수정
3. 의존성 중복 방지
    1. 여러 모듈에서 동일 라이브러리 사용 시 의존성 중복 방지

**→ 협업 효율 향상.**

</aside>

**Gradle Version Catalog 방식의 의존성 추가 및 관리 코드**

```kotlin

// 파일명: build.gradle.kts(Module: app)
...
dependencies {
	implementation(libs.androidx.navigation.compose)
}

// 파일명: libs.versions.toml
[versions]
navigationCompose = "2.7.7" // 2.8.4 available
// 버전만 변경해줄 시, 여러 모듈에 일괄 적용.
// lower Camel Case로 작성 권장

[libraries]
androidx-navigation-compose = { module = "androidx.navigation:navigation-compose", version.ref = "navigationCompose" }
// 모듈 이름과 버전을 분리.
// kebab case로 작성 권장
```

### 1-1-3. Gradle Version Catalog 권장 작성 규칙

- **Version 선언법**
    - 버전은 기본적으로 단일 문자열로 정의
    - 버전 별칭 네이밍 시 Camel Case로 작성하는 것을 추천
    - 규칙 설정 시(특정 버전 제외 등) Lich versions 문법 사용.
    
- **Libraries 선언법**
    - maven 라이브러리 규칙에 따라 {**groupId}:{artifactId}{version}** 형태로 정의
        - group, name, version  |  Module, version으로 작성해도 무방.
    - 라이브러리 네이밍 시 Kebab Case로 작성 추천
        - kebab 케이스로 정의할 경우 대부분 IDE의 Code completion 기능을 통해 자동 완성.
    - version.ref를 통해 [versions]에서 정의한 버전을 별칭으로 가져올 수 있음.

### 1-1-4. 추가 사항

- **모듈 이름 / 버전 분리 이유**
    - `navigation-ui` 라이브러리를 추가로 사용한다고 가정합시다.
        
        ```kotlin
        androidx-navigation-ui = { module = "androidx.navigation:navigation-ui", version.ref = "navigationCompose" }
        ```
        
    - version.ref를 똑같이 `navigationCompose` 로 맞춰주면?
        - `navigationCompose` 버전을 변경할 때 한 곳에서만 수정하면 편합니다.
            
            ![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/20af6bb7-f708-4c94-afaf-30e2ec2a87b9/61f32ec1-bb1d-45bf-9272-8fc69e1fb6db/image.png)
            

## 1-2. Navigation component

### 1-2-1. Navigation Library

<aside>
💡

**Navigation Library란?**

- **Google**이 제공하는 **jetpack Navigation** 라이브러리
- 유저가 앱 내에서 탐색하거나 탐색 후 다시 되돌아오는 상호작용을 구현
- https://developer.android.com/guide/navigation?hl=ko
</aside>

### 1-2-2. NavHost

- 사용자가 앱을 사용하는 동안 현재 방문 중인 Navigation Destination(목적지)을 담고 있는 **UI 요소**
- 앱에서 화면이 전환될 때마다 현재 화면을 Host UI 요소 안에서 교체하여 보여줌.
    - 사용자가 A 화면 →B 화면 이동 시, A 화면 제거 → B 화면 새로 표시
- Compose의 경우 NavHost 사용, (Fragment: NavHostFragment)

### 1-2-3. Navigation Graph

- 앱 내 모든 네비게이션 목적지와  해당 목적지 간에 어떻게 연결되는지를 정의하는 **데이터 구조**
- Node : 각 화면(목적지)
- Edge : 한 화면에서 다른 화면으로 넘어갈 수 있는 경로(엣지)
- 앱 전체 네비게이션 구조를 쉽게 설정하고, 관리할 수 있음.
- 생성방법
    - NavHost Composable을 사용
    - NavHost 컴포저블은 NavController와 시작 목적지를 인자로 받음.
    - startDestination에 home이라는 route 문자열을 설정 시.
        - 앱 시작 시 목적지 home의 화면이 먼저 보여짐
    
    ```kotlin
    NavHost(
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) {
            ...
            }
            composable(Screen.Detail.route) {
            ...
            }
            composable(Screen.PlayGround.route) {
            ...
            }
        }
        
     sealed class Screen(val route: String) {
        data object Home : Screen("home")
        data object Detail : Screen("detail")
        data object PlayGround : Screen("playground")
    }
    ```
    

### 1-2-4. NavController

- 목적지 간의 네비게이션을 총괄하는 역할을 하는 **컴포넌트**
    - 앱 내에서 사용자의 위치를 파악, 필요에 따라 적절한 화면(목적지)으로 이동시키는 역할
- 사용자가 한 화면에서 다른 화면으로 넘어갈 수 있도록 도와줌.
    - 딥 링크 처리, 뒤로 가기 스택 관리 등의 기능을 제공
- 생성 방법
    
    ```kotlin
    val navController = rememberNavController()
    ```
    

### 1-2-5. 장점/특징

- **애니메이션 및 전환:** 애니메이션 및 전환에 표준화 된 리소스를 제공
- **백스택 관리 자동화:** 시스템의 **백 스택**과 통합되어, 뒤로가기 버튼과 같은 내비게이션 동작을 자동으로 처리
- **딥 링크:**  딥 링크 구현 및 처리
    - 딥 링크 : URL을 통해 특정 화면으로 직접 이동하는 기능
- **UI 패턴:** **Navigation Drawables**, **BottomNavigation**과의 통합을 간편하게 지원
- **Safe Args**: 데이터를 탐색하고 전달할 때 유형 안전성을 제공하는 Safe Args Gradle 플러그인 포함
- **ViewModel 지원:** ViewModel을 특정 Navigation 경로(그래프)와 연결하는 기능 지원
    - 해당 경로에 있는 여러 화면(목적지)에서 같은 데이터를 공유하고 접근할 수 있게 함

## 1-3. Sealed Class

### 1-3-1. Sealed Class란?

- **추상 클래스**처럼 동작하며, 상속을 통해 추가적인 상태와 동작을 정의할 수 있음.
    - 즉, 객체화될 수 없는 자신과, 자신을 상속 받는 서브클래스/interface로 구성
- 외부의 다른 클래스는 해당 클래스를 상속받을 수 없게 **봉인** 되어 있음.
- 하위 클래스에 추가 데이터 포함하거나, object, data 등 다양한 class 추가 가능
    
    ```kotlin
    // Splash, Login을 나열하는 sealed class
    sealed class Screen {
    	object Splash : Screen()
    	object Login : Screen()
    	data class Details(val id: Int) : Screen()
    }
    
    // Splash, Login을 나열하는 enum class
    enum class Screen {
    	Splash, Login
    }
    ```
    

### 1-3-2. Sealed Class 특징

- 하위 클래스에 메서드를 정의하는 등, 확장성이 좋음
    
    ```kotlin
    sealed class Shape {
        data class Circle(val radius: Double) : Shape()
        data class Rectangle(val width: Double, val height: Double) : Shape()
        
        fun area(): Double = when (this) {
            is Circle -> Math.PI * radius * radius
            is Rectangle -> width * height
        }
    }
    // 출처 : kotlin world
    ```
    
- When과 함께 사용 시 효과가 좋음.
    - Android Studio에서 자동 완성 활용 가능
      ![image](https://github.com/user-attachments/assets/ed386006-0bba-451d-9044-2b66c82e4d2a)
      ![image (1)](https://github.com/user-attachments/assets/78afb898-737b-4a23-a247-34e368f4bb8d)
### 1-3-3. Sealed Class Vs. Enum Class

|  | sealed class | enum class |
| --- | --- | --- |
| 확장성 | 하위 클래스를 추가하여 다양한 상태, 데이터 표현 가능 | 상수만 정의 가능. 상태나 데이터 추가 시 구조 변경 필요 |
| 데이터 포함 가능 여부 | 하위 클래스에서 데이터를 포함할 수 있음 | 추가 데이터를 포함하려면 별도로 값을 정의하거나 인터페이스를 구현해야 함. |
| 동작 정의 | 하위 클래스마다 고유한 메서드나 동작을 정의 가능 | enum에 공통 메서드를 정의할 수 있지만, 복잡한 동작은 어려움. |
| 사용 사례 | 복잡한 상태나 추가 데이터가 필요한 경우 | 단순히 제한된 값의 집합을 나타낼 때 적합. |
- 둘 다 타입을 제한적으로 사용하고자 할 때 많이 사용하게 됨.
    - `Enum`에서는 특정 값을 single instance로서 하나의 객체만 제한적으로 사용할 수 있음.
        - 생성자의 형태도 동일해야만함.
    - `Sealed`에서는 state을 포함하고 있는 여러 개의 instance를 가질 수 있음
    - 생성자도 각각의 특징에 따라서 다르게 가져갈 수 있음.
        - 다양한 state를 사용할 수 있음.
