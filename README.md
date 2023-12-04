# Android Template <br> <a href="https://github.com/deepfine/mob_android_template/actions"><img alt="Build Status" src="https://github.com/deepfine/mob_android_template/actions/workflows/build.yml/badge.svg"/></a><br>
Android Template based on [MVI](https://github.com/orbit-mvi/orbit-mvi) & [Jetpack compose](https://developer.android.com/jetpack/compose)


<details>
    <summary><b>Environment Setup</b></summary>
      <ol>
        <li>Android Studio Hedgehog</li>
        <li>Java version 17</li>
      </ol>
</details>

<br>
<br>

## MVI (Model - View - Intent)
<img width="744" alt="image" src="https://github.com/deepfine/mob_android_template/assets/58277725/1d606f96-c0ac-479f-b689-37115e6d9003">


기존 MVVM 패턴의 <b>상태(State)</b>와 <b>부수효과(Side effect)</b> 문제로<br>
함수가 어떤 결과를 반환할지 예측하기 힘들어지고, 이에 따라 상태 변경에 있어 어려움을 겪으므로 등장하게된 패턴
<br>
### Model
- 앱의 유일한 상태와 데이터를 갖고 있는 **불변 객체**
- 따라서, 모델을 업데이트 시키기 위해서는 새로운 객체를 만들어야 한다.

### View
- Model로 받은 데이터가 사용자에게 보여지는 **화면**을 의미한다.

### Intent
- ```android.content.Intent```와는 관련 없음.
- 앱의 상태를 바꾸라는 **요청**을 의미한다.
<br>
<br>

## Jetpack Compose
<img src="https://github.com/deepfine/mob_android_template/assets/58277725/9c13bb8e-b0b7-49da-a23f-5965ca42e00c" width="70%" height="70%"/>

- 네이티브 안드로이드 UI를 작성하기 위한 모던 라이브러리
- UI개발을 단순화하며 직관적인 Kotlin API를 사용한다.
- Declaractive UI로 **State**라는 개념을 통해 View를 업데이트 한다.



