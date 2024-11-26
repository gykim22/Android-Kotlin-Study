# 2. Side Effect

## 2-1. Side Effect(공학적인 측면)

Side Effect**란?**

- 프로그래밍에서 어떤 함수나 연산의 수행 결과로 시스템의 상태가 예상치 못하게 변경되는 현상
    - 함수 외부에 존재하는 값이나 상태를 변경시키는 등의 행위

## 2-2. Side Effect (Jetpack Compose)

Jetpack Compose에서 Side Effect

- Compose function 외부에서 발생하는 앱 상태의 변화
    - Composable function은 side-effect에 영향받지 않아야 함.
- Compose 내부의 동작으로 인하여 외부의 상태가 바뀌어야 하는 경우가 있다면?
    - 앱 상태를 변경해야 하는 경우 이러한 부수 효과가 예측 가능한 방식으로 실행되도록 Effect API를 사용해야 함
- Jetpack Compose가 제공하는 함수
    - `SideEffect`, `LaunchedEffect` ,`DisposableEffect`

### 2-2-1. **LaunchedEffect**

- 독립적인 coroutine scope에서 side effect를 실행시키기 위한 컴포저블 함수
    - 즉, Composable에서 비동기 관련된 처리할 때 사용할 수 있는 Effect API 중 하나
- UI 스레드 블락 없이 긴 시간의 작업(네트워크 호출, 애니메이션)을 처리할 때 유용하게 사용
- **컴포지션이 이루어지거나 Composable 함수가 최초로 호출될 때**, 컴포지션의 CoroutineContext로 코루틴 블락을 시작하며, 함수의 인자인 `key` 값이 변경되면, **현재 실행중인 코루틴은 취소되고, 재시작**
    
    ```kotlin
    LaunchedEffect(key1, key2) { 
        // key1 또는 key2가 변경될 때 블록 실행
    }
    ```
    
### 2-2-2.DisposableEffect

- 컴포저블이 **컴포지션을 종료한 후 정리 해야 하는 부수 효과가 있는 경우** 사용
- **컴포저블의 수명주기**에 맞게 정리되어야 할 리스너나 callback이 있거나 처리해야 할 이벤트가 있는 경우 사용
    
    ```kotlin
    DisposableEffect(key) {
        // 컴포저블이 처음 구성될 때 실행될 코드
    
        onDispose {
            // 컴포저블이 화면에서 사라질 때 실행될 정리 코드
        }
    }
    ```  

## 2-3. Side Effect (공학 vs Compose)

- `LanchedEffect`의 경우, key 값의 변화를 인지하여 비동기 작업을 수행하는 구조
    - **→ 외부 시스템과의 상호작용**을 통해 side effect를 일으킴.
    - 네트워크 요청, 애니메이션 등
- `DisposableEffect`는 리소스 해제 시점에서 **외부 상태를 변경**하거나 **외부 시스템에 신호를 보냄**
    - 리스너, 콜백 등
