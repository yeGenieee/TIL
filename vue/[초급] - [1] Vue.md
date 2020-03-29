# 기존 웹 개발 방식 (HTML, JavaScript)

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <div id="app">
        <!-- hello world -->
    </div>
    <script>
        var div = document.querySelector('#app');
        console.log(div); // div 태그의 정보를 출력
        var str = 'hello world';
        div.innerHTML = str;

        str = 'hello world!!!';
        div.innerHTML = str;

    </script>
</body>
</html>
```



# Vue의 핵심 : Reactivity

#### Object.defineProperty()

- 객체의 특정 속성을 재정의하는 메서드

```javascript
Object.defineProperty (대상 객체, 객체의 속성, {
   // 문법
});
```



### Reactivity : 반응성

- data의 변화를 라이브러리에서 감지하여 알아서 자동으로 화면을 그려주는 것

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <div id="app">

    </div>
    <script>
        var div = document.querySelector('#app');
        var viewModel = {};

        // Object.defineProperty(대상객체, 객체의 속성 {
          // 정의할 내용  
        // })

        Object.defineProperty(viewModel, 'str', {
            // 속성에 접근했을 때의 동작을 정의
            get: function() {
                console.log('접근');
            },
            // 속성에 값을 할당했을 때의 동작을 정의
            set: function(newValue) {
                console.log('할당', newValue);
                div.innerHTML = newValue;
            }
        });
    </script>
</body>
</html>
```



# Reactivity 라이브러리 만들기

### 즉시 실행 함수

- 정의되자마자 즉시 실행되는 Javascript Function

```javascript
(function () {
    statements
})();
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <div id="app">

    </div>
    <script>
        var div = document.querySelector('#app');
        var viewModel = {};

        // 즉시 실행 함수가 하는 역할 ? : init과 render function이 어플리케이션 로직에 노출되지 않도록 또다른 scope에 넣어주는 역할
        (function() {
            function init() {
            Object.defineProperty(viewModel, 'str', {
            // 속성에 접근했을 때의 동작을 정의
            get: function() {
                console.log('접근');
            },
            // 속성에 값을 할당했을 때의 동작을 정의
            set: function(newValue) {
                console.log('할당', newValue);
                render(newValue);
            }
        });
        }

            function render(newValue) {
                div.innerHTML = newValue;
            }

            init();
        })();
    </script>
</body>
</html>
```





# Vue 인스턴스

### 인스턴스

- 뷰로 개발할 때 필수로 생성해야 하는 코드이자 단위

### 인스턴스 생성

```javascript
new Vue();
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <div id="app"></div>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script>
        var vm = new Vue({
            el: '#app', // element : body 태그 내에서 app이라는 id를 가진 태그를 찾아 인스턴스를 붙이겠다
            data: {
                message: 'hi'
            }
        });
    </script>
</body>
</html>
```

- el 태그에 붙여주는 id는 body 내에 존재하는 id어야 Vue를 쓸 수 있음



# 인스턴스 생성자 함수

JavaScript 내에서 개체를 생성하는 방법

1. 생성자 함수를 작성함으로써 개체를 정의
2. new 키워드를 사용하여 개체의 인스턴스 생성



생성자 함수 (함수 이름이 대문자 - 생성자함수로 암묵적 동의)

생성자 함수의 개체 생성 패턴

- 함수를 이용하여 어떤 정보를 담은 개체를 생성

```javascript
function Person(name, job) {
    this.name = name;
    this.job = job;
}
```

```javascript
var p = new Person('josh', 'developer');
```



모든 Vue 앱은 `Vue` 함수로 새 **Vue 인스턴스**를 만드는 것부터 시작

- Vue를 왜 생성자 함수로 생성할까?

생성자 함수를 이용하여 logText라는 속성의 함수를 넣어놓음

```javascript
function Vue() {
    this.logText = function() {
        console.log('hello');
    }
}
```

```javascript
var vm = new Vue();
```

이렇게 미리 생성자 함수로 개체를 만들 때마다 그 개체 안에는 미리 정의해놓은 logText라는 함수가 정의되어 있을것 ==> 함수를 매번 정의할 필요가 없어짐

**생성자 함수를 이용하여 Vue에서 API나 속성을 미리 정의해놓고, 이후에 갖다 쓰는 형태로 손쉽게 이용할 수 있다.**



# 인스턴스 옵션 속성

Vue 인스턴스를 인스턴스화 할 때는 데이터, 템플릿, 마운트할 엘리먼트, 메소드, 라이프사이클 콜백 등의 옵션을 포함 할 수있는 **options 객체**를 전달 해야한다.

- 인스턴스에서 사용할 수 있는 속성과 API

```javascript
new Vue({
    el: ,
    template: ,
    data: ,
    methods: ,
    created: ,
    watch: ,
});
```

```javascript
 var vm = new Vue({
            el: '#app',
            data: {
                message: 'hi'
            },
            methods: {

            },
            created: function() {

            }
        });
```

- 객체 리터럴을 Vue 인스턴스 옵션으로 넣어줌



# 뷰 컴포넌트

컴포넌트는 화면의 영역을 구분하여 개발할 수 있는 뷰의 기능

컴포넌트 기반으로 화면을 개발하게 되면 코드의 **재사용성**이 올라가고 빠르게 화면을 제작할 수 있음

![1569500454621](../image/1_vue_component)



### 컴포넌트 등록

1. **전역 컴포넌트**로 등록 : Vue.component() 이용

```javascript
Vue.component('컴포넌트 이름', 컴포넌트 내용);
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <div id="app">
        <app-header></app-header>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script>
        // Vue.component('컴포넌트 이름', 컴포넌트 내용); // 전역 컴포넌트로 등록
        Vue.component('app-header', {
            template: '<h1>Header</h1>'
        });

        new Vue({
            el: '#app'
        });
    </script>
</body>
</html>
```

![1569502197013](../image/2_vue_component_result)



2. **지역 컴포넌트** 등록 : 인스턴스 속성 이용

```javascript
new Vue({
    el: '#app',
    components: {
        '컴포넌트 이름' : 컴포넌트 내용
    }
})
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <div id="app">
        <app-header></app-header>
        <app-content></app-content>
        <app-footer></app-footer>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script>
        // Vue.component('컴포넌트 이름', 컴포넌트 내용); // 전역 컴포넌트로 등록
        Vue.component('app-header', {
            template: '<h1>Header</h1>'
        });

        Vue.component('app-content', {
            template: '<div>content</div>' // 정의된 템플릿 태그
        })

        new Vue({
            el: '#app',
            // 지역 컴포넌트 등록
            components: {
                // '컴포넌트 이름' : '컴포넌트 내용'
                'app-footer' : {
                    template: '<footer>footer</footer>'
                }
            }
        });
    </script>
</body>
</html>
```



![1569502528341](../image/3_vue_component_result_local)



# 전역 컴포넌트와 지역 컴포넌트의 차이

- 지역 컴포넌트는 하단에 어떤 컴포넌트들이 등록되는지 components 속성만으로도 알 수 있다. (서비스 개발 시 많이 사용)

- 전역 컴포넌트는 플러그인이나 라이브러리 형태로 사용 (전역으로 사용해야 하는 경우에만)



전역 컴포넌트는 인스턴스를 생성하지 않아도 기본적으로 인스턴스에 등록되어 있지만, 지역 컴포넌트는 인스턴스마다 새로 생성해주어야 한다



# 컴포넌트와 인스턴스의 관계

전역 컴포넌트는 인스턴스를 생성하지 않아도 기본적으로 인스턴스에 등록되어 있지만, 지역 컴포넌트는 인스턴스마다 새로 생성해주어야 한다
