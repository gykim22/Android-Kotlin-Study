# 1회차 스터디

# 1. 안드로이드 스튜디오

<aside>
💡Android **전용** 애플리케이션 제작을 위한 **공식 통합 개발환경 (IDE)**
</aside>

- **IntelliJ IDEA** 기반 제작 (CLion, Pycharm 등 IntelliJ IDE와 흡사)
- **Kotlin**, Java, C++ 프로그래밍 언어 지원

## 1-1. Iguana 버전(2023.2.1) 다운로드

- 링크 (**즉시** 다운로드) : https://redirector.gvt1.com/edgedl/android/studio/install/2023.2.1.24/android-studio-2023.2.1.24-windows.exe

## 1-2. 설치

- **standard** 설치 진행 → UI thema [Dark/Light 중 택 1] → 라이센스 동의
- 설치된 버전 확인 : 상단바 → Help 탭 → About  
 ![image](https://github.com/user-attachments/assets/c444cfe3-0a8f-4e25-ba63-d4dab6b6da8b)

## 1-3. 프로젝트 생성

- **New Project** → 일반적으로 **Empty Activity** 생성  
    ![image 1](https://github.com/user-attachments/assets/06ce9a8d-dd91-4c11-9acd-0d9c78964510)
- **Name** : 프로젝트 명(영문 권장)
- **Package name** : 프로젝트 명에 따라 자동 설정됨
- **Minimum SDK** : 앱을 실행하는데 필요한 최소 API 레벨 설정. 하단 설명 기반 적절히 선택
- Build language : Kotlin DSL 선택  
 ![image 2](https://github.com/user-attachments/assets/5def9829-e443-4997-9a95-dd227ee5b353)


## 1-3. SDK 설치

- **상단바 → Tools → SDK Manager**
    - **SDK Platforms**에서 Android 14.0[UpsideDownCake] (API Level 34) 선택
    - **SDK Tools**에서 Android SDK Build-Tools 35, Android Emulator, Android Emulator hypervisor driver(선택사항), Android SDK Platform-Tools 설치

![image 3](https://github.com/user-attachments/assets/6b5a5c5d-3a0f-470f-ab7f-1476b7c917d6)


![image 4](https://github.com/user-attachments/assets/82ba5056-f22c-4e7f-bbf0-b06a5e808ef1)


## 1-4. Virutal Device 설정

- 우측바 → **Device Manager** → Create Device (또는 + 버튼) → Pixel N 시리즈 중 선택
    
![image 5](https://github.com/user-attachments/assets/d307af82-0d7a-43f8-b1a4-ce75227c8256)

    

## 1-5. Github 연동

- [https://velog.io/@xlddy02/Android-Studio-Git-안드로이드-스튜디오-Github-연동법](https://velog.io/@xlddy02/Android-Studio-Git-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%8A%A4%ED%8A%9C%EB%94%94%EC%98%A4-Github-%EC%97%B0%EB%8F%99%EB%B2%95) 참고

## 참고문헌
- 안드로이드 스튜디오 공식 레퍼런스 : 안드로이드 만나보기
  - https://developer.android.com/studio/intro?hl=ko
