<h1>Android</h1>

View.SYSTEM_UI_FLAG_

- FULLSCREEN : 상태 표시줄 바를 숨기기 위한 flag이다.
- HIDE_NAVIGATION : 네비게이션 바를 숨기기 위한 flag이다.
- IMMERSIVE_STICKY : 상태 바와 네비게이션 바를 투명하게 만드는 flag이다.
- IMMERSIVE : UI를 전체화면 모드로 설정해주는 flag이다.

이러한 flag들은 getWindow().getDecorView().setSystemUiVisibility 의 인자로 원하는 flag들을 or 연산으로 묶어서 전달하여 적용시킨다.



getSystemService(INPUT_METHOD_SERVICE)를 InputMethodManager 타입으로 받아와서 hideSoftInputFromWindow 기능을 통해 키보드를 숨기는 작업을 할 수 있다.



Activity에서 Fragment로 데이터를 전달할 때에는 Bundle을 활용해야 한다.

bundle.putString(Key, Value)

fragment.setArguments(bundle) 로 fragment에 전달하는 방식이다.

이후 fragment에서는 

if(getArguments() != null)

​	String data = getArguments().getString( key 값 ) 과 같은 형식으로 받아온다.



안드로이드에서 vector 이미지를 사용하기 위해서는 아래를 gradle에 추가해준다.

```groovy
android {
      defaultConfig {
        vectorDrawables.useSupportLibrary = true
      }
    }

    dependencies {
      compile 'com.android.support:appcompat-v7:23.2.0'
    }
```

의존성을 추가해주지 않으면 out of memory 에러가 나오면서 build를 실패하여 앱을 실행시키지도 못한다.