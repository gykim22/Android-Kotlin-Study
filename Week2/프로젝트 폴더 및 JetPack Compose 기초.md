### 1. **프로젝트 폴더 구조**

- **AndroidManifest.xml**
    - 앱의 구성 정보(권한, 액티비티, 서비스 등)를 정의하는 파일로, 앱이 설치될 때 시스템에 알려줌.
    - 모든 앱 프로젝트는 [프로젝트 소스 세트](https://developer.android.com/studio/build?hl=ko#sourcesets)의 루트에 `AndroidManifest.xml` 파일(정확히 이 이름이어야 함)이 있어야 함.
    - 예시
        
        ```kotlin
        <?xml version="1.0" encoding="utf-8"?>
        <manifest
            xmlns:android="http://schemas.android.com/apk/res/android"
            android:versionCode="1"
            android:versionName="1.0">
        
            <!-- Beware that these values are overridden by the build.gradle file -->
            <uses-sdk android:minSdkVersion="15" android:targetSdkVersion="26" />
        
            <application
                android:allowBackup="true"
                android:icon="@mipmap/ic_launcher"
                android:roundIcon="@mipmap/ic_launcher_round"
                android:label="@string/app_name"
                android:supportsRtl="true"
                android:theme="@style/AppTheme">
        
                <!-- This name is resolved to com.example.myapp.MainActivity
                     based on the namespace property in the build.gradle file -->
                <activity android:name=".MainActivity">
                    <intent-filter>
                        <action android:name="android.intent.action.MAIN" />
                        <category android:name="android.intent.category.LAUNCHER" />
                    </intent-filter>
                </activity>
        
                <activity
                    android:name=".DisplayMessageActivity"
                    android:parentActivityName=".MainActivity" />
            </application>
        </manifest>
        ```
        
- **Gradle**
    - **안드로이드 스튜디오가 선택한 빌드 배포 도구**로, 의존성 관리, 빌드 구성을 자동화.
    - Gradle 스크립트를 통해 앱의 컴파일 방법, 빌드 타입 등을 설정 가능.
    - project와 module 두 가지 형태의 build.gradle 존재.
        - Project gradle : 프로젝트의 모든 모듈에 공통으로 적용되는 빌드의 구성을 정의
        - Module gradle : 각 모듈마다 독립된 build.gradle 파일
        ![image](https://github.com/user-attachments/assets/7e076958-90f7-4217-a343-68b398639959)
    - **plugins{}** : 안드로이드 전용 빌드 옵션
    - **android{}** : 모든 안드로이드 관련 설정
    - compileSdk : Android API 레벨. (해달 레벨 이하 이용 가능)
    - minSdk : 최소 API 레벨.
    - targetSdk : 테스트에 사용하는 API 레벨
    - **buildTypes{}** : 빌드 타입 종류 지정 (release, develoption, staging 등)
    - **dependencies{}** : 특정 버전을 선택해서 라이브러리 추가
- **res 폴더**
    - **Resources의 줄임말**로, 프로젝트에서 사용되는 이미지나 테마, 색상 등을 정의할 수 있음.
    - 리소스 파일(레이아웃, 이미지, 문자열 등)을 보관하며, 앱의 UI와 언어 설정 등에 사용.
    - 자동 생성된 파일 중 하나.
### 2. **안드로이드 구성요소**
  - **Activity**: 사용자와 상호작용하는 화면을 나타내는 컴포넌트로, 앱의 화면을 구성하는 기본 단위.
  - **Content Provider**: 데이터 공유를 위한 컴포넌트로, 앱 간 데이터 접근과 공유를 가능하게 해줌.
### 3. **Jetpack Compose**
  - 안드로이드 UI를 선언적으로 작성할 수 있게 해주는 최신 UI 툴킷. XML이 아닌 Kotlin 코드로 UI를 구성.
  - **Row, Column, Box**: 레이아웃 요소로, Row는 수평, Column은 수직, Box는 중첩된 구조를 지원하여 자유로운 레이아웃 구성이 가능.
    ![image (1)](https://github.com/user-attachments/assets/e7c10845-b075-4290-8080-7c7d728ef35a)
