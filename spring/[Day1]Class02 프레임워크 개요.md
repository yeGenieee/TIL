# DAY 01 - CLASS 02 프레임워크 개요

[TOC]

# 학습 목표

### 1. 프레임워크는 무엇인가?

### 2. 프레임워크를 사용했을 때 얻는 장점



# 2.1 프레임워크 개념

### 프레임워크 : 아키텍처에 해당하는 골격 코드

- 개발에서 기본이 되는 뼈대나 틀을 제공
- 애플리케이션의 기본 아키텍쳐는 프레임워크가 제공, 뼈대에 살을 붙이는 작업만 개발자가 진행

# 2.1.2 프레임워크의 장점

### 재사용성의 증가

1. **빠른 구현시간** : 개발자는 비즈니스 로직만 구현하면 되므로
2. **쉬운 관리** : 같은 프레임워크가 적용된 애플리케이션은 아키텍처가 같으므로
3. **개발자들의 역량 획일화** : 고급 개발자와 초급 개발자가 생성한 코드가 비슷해지며 → 개발 리소스를 더 효율적으로 구성 가능
4. **검증된 아키텍처의 재사용과 일관성 유지** : 아키텍처에 대한 별다른 고민이나 검증 없이 SW 개발 가능 & 유지 보수 시, 아키텍처가 왜곡되거나 변형되지 않음

# 2.2 스프링 프레임워크

## 2.2.1 스프링 탄생 배경

- 로드 존슨이 2004년에 만든 오픈소스 프레임워크
- 기존은 EJB 를 이용, but 문제가 많음
  - EJB 는 스펙이 너무 복잡, 러닝 커브가 높음
  - EJB 컴포넌트를 배치하고 실행하기 위한 WAS (Web Application Server)가 매우 고가의 장비들
  - EJB 를 제대로 사용하려면, EJB의 성능을 유지해주고, 유지보수의 편의성을 향상해주는 다양한 디자인 패턴을 이해하고 적용할 수 있어야 함

**스프링**

- 평범한 POJO (Plain Old Java Object)를 사용하면서도 EJB에서만 가능했던 많은 일을 가능하도록 지원

- 이미 많은 디자인 패턴이 적용되어 배포되므로 스프링을 사용하는 것 자체가 디자인 패턴을 사용하는 것

  POJO (Plain Old Java Object)

  - 평범한 옛날 자바 객체
  - Not POJO ? - Servlet 클래스 - 우리 마음대로 만들 수 없고, 반드시 Servlet에서 **요구하는 규칙에 맞게 클래스를 만들어야 실행 가능**

## 2.2.2 스프링 프레임워크 특징

### IoC와 AOP를 지원하는 경량의 컨테이너 프레임워크

### 1. 경량 (LightWeight)

- 스프링은 여러 개의 모듈로 구성되어 있으며, 각 모듈은 하나 이상의 **JAR 파일로 구성**됨

- **몇 개의 JAR만 있으면 개발과 실행이 모두 가능 →** 배포도 빠르고 쉽다

- 스프링 프레임워크가 

  POJO 형태의 객체를 관리

  하기 때문에 경량

  - POJO는 클래스를 구현하는 데 특별한 규칙이 없는 단순하고 가벼운 객체 → POJO를 관리하는 것은 기존의 EJB 객체를 관리하는 것보다 훨씬 가볍고 빠름

### 2. 제어의 역행 (Inversion of Control)

- 객체 간의 낮은 결합도와 높은 응집도를 가능케 함

- IoC가 적용되면, 객체 생성을 자바 코드로 직접 처리하는 것이 아닌 

  컨테이너가 대신 처리

  - 소스에 의존 관계가 명시되지 않으므로 결합도 down → 유지보수 easy

### 3. 관점지향 프로그래밍 (Aspect Oriented Programming, AOP)

- 비즈니스 메소드를 개발할 때, 핵심 비즈니슷 로직과 각 비즈니스 메소드마다 반복해서 등장하는 공통 로직을 분리함으로써 응집도가 높에 개발할 수 있도록 지원
- 공통으로 사용하는 기능을 외부의 독립된 클래스로 분리 & 해당 기능을 프로그램 코드에 직접 명시하지 않고 선언적으로 처리하여 적용

### 4. 컨테이너 (Container)

- 컨테이너는 특정 객체의 생성과 관리를 담당하며 객체 운용에 필요한 다양한 기능을 제공

# 2.3 IoC (Inversion of Control) 컨테이너

- 서블릿 클래스 `HelloServlet.java`

  ```java
  public class HelloServlet extends HttpServlet {
  		public HelloServlet() {
  				System.out.println("===> HelloServlet 객체 생성");
  		}
  
  		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  				System.out.println("doGet() 메소드 호출");
  		}
  }
  ```

  - 작성된 서블릿 클래스는 `web.xml` 파일에 자동으로 등록됨

    ```xml
    <web-app>
    	<servlet>
    		<servlet-name>hello</servlet-name>
    		<servlet-class>hello.HelloServlet</servlet-class>
    	</sevlet>
    	<servlet-mapping>
    		<servlet-name>hello</servlet-name>
    		<url-pattern>/hello.do</url-pattern>
    	</servlet-mapping>
    </web-app>
    ```

    - 브라우저에서 `/hello.do` 라는 URL 요청을 전송하면, hello 라는 이름으로 등록된 hello.HelloServlet 클래스를 찾아 **객체를 생성**하고 실행함

  - 서블릿 : 자바로 만들어진 클래스

    - 반드시 객체 생성을 해야 객체가 가지고 있는 메소드도 호출 가능

    → 누가 서블릿 객체를 생성하고 doGet() 메소드를 호출??? 어디에도 객체 생성 코드가 없는데?

    **서블릿 컨테이너**

    1. `WEB-INF/web.xml` 파일을 로딩하여 구동
    2. 브라우저로부터 `/hello.do` 요청 수신
    3. hello.HelloServlet 클래스를 찾아 객체를 생성하고 doGet() 메소드 호출
    4. doGet() 메소드 실행 결과를 클라이언트 브라우저로 전송

    → 컨테이너 : 자신이 관리할 클래스들이 등록된 **XML 설정 파일을 로딩하여 구동**

    ```
             클라이언트의 요청이 들어오는 순간 XML 설정 파일을 참조하여 **객체를 생성 & 객체의 생명주기를 관리**
    ```

### IoC : 결합도와 관련된 개념

- 기존 자바 기반으로 애플리케이션을 개발할 때, 객체를 생성하고 객체들 사이의 의존관계를 처리하는 것에 대한 책임 : 전적으로 개발자 책임

- 제어의 역행 : 이런 객체 생성 , 의존 관계 처리를 

  컨테이너가 한다

  - 결론 : IoC를 통해 소스에서 객체 생성과 의존 관계에 대한 코드가 사라짐
  - **낮은 결합도**의 컴포넌트 구현 가능

# 2.3.1 결합도 (Coupling)가 높은 프로그램

### 결합도

- **하나의 클래스**가 다른 클래스와 **얼마나 많이 연결되어 있는지**를 나타내는 표현
- 결합도가 높은 프로그램 → 유지보수 hard

## 결합도와 유지보수 관계를 이해하기 위한 예제

- ```
  SamsungTV
  ```

  클래스

  - TV 시청에 필요한 기능인 4개의 메소드가 있음

```java
package com.springbook.polymorphism;

public class SamsungTV {
	public void powerOn() {
		System.out.println("SamsungTV --- 전원 킨다.");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV --- 전원 끈다.");
	}
	
	public void volumeUp() {
		System.out.println("SamsungTV --- 볼륨 올린다.");
	}
	
	public void volumeDown() {
		System.out.println("SamsungTV --- 볼륨 내린다.");
	}
}
```

- SamsungTV와 같은 역할을 하는  `LgTV` 클래스

```java
package com.springbook.polymorphism;

public class LgTV {
	public void turnOn() {
		System.out.println("LgTV --- 전원 킨다.");
	}
	
	public void turnOff() {
		System.out.println("LgTV --- 전원 끈다.");
	}
	
	public void soundUp() {
		System.out.println("LgTV --- 볼륨 올린다.");
	}
	
	public void soundDown() {
		System.out.println("LgTV --- 볼륨 내린다.");
	}
}
```

### SamsungTV와 LgTV 클래스에는 같은 기능을 수행하는 메소드가 있지만, 서로 메소드의 이름이 다르다.

- 여기서, 이 두 TV 클래스를 번갈아 사용하는 `TVUser`클래스를 보자

```java
package com.springbook.polymorphism;

public class TVUser {
	public static void main(String[] args) {
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
	}

}
```

- 실행 결과

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/82f5c49c-2580-4db5-989f-60c17e334c10/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/82f5c49c-2580-4db5-989f-60c17e334c10/Untitled.png)

- SamsungTV를 시청하는 TVUser 프로그램을 `LgTV`를 시청하는 프로그램으로 **수정**해보자

```java
package com.springbook.polymorphism;

public class TVUser {
	public static void main(String[] args) {
		LgTV tv = new LgTV();
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();
	}

}
```

- 두 클래스 간 

  메소드 시그니처가 다르므로

  , TVUser 코드 대부분을 수정해야 TV를 교체할 수 있음

  - **유지보수가 너무 어렵다**

# 2.3.2 다형성 이용하기

### 결합도를 낮추기 위해 다형성 (polymorphism) 을 이용

### 다형성 이용하기

1. 상속 (Inheritence)
2. 메소드 재정의 (Method Overriding)
3. 형변환

### 1. 최상위 부모로 사용할 TV 인터페이스 선언 & 모든 TV가 공통으로 가져야 할 메소드들을 추상 메소드로 선언 `TV.java`

```java
package com.springbook.polymorphism;

public interface TV {
	public void powerOn();
	public void powerOff();
	public void volumeUp();
	public void volumeDown();
}
```

### 2. TV 인터페이스를 구현 (`SamsungTV.java` & `LgTV.java`)

```java
package com.springbook.polymorphism;

public class SamsungTV **implements TV** {
	@Override
	public void powerOn() {
		System.out.println("SamsungTV --- 전원 킨다.");
	}
	
	@Override
	public void powerOff() {
		System.out.println("SamsungTV --- 전원 끈다.");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SamsungTV --- 볼륨 올린다.");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("SamsungTV --- 볼륨 내린다.");
	}

}
package com.springbook.polymorphism;

public class LgTV **implements TV** {
	@Override
	public void powerOn() {
		System.out.println("LgTV --- 전원 킨다.");
	}
	
	@Override
	public void powerOff() {
		System.out.println("LgTV --- 전원 끈다.");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("LgTV --- 볼륨 올린다.");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("LgTV --- 볼륨 내린다.");
	}

}
package com.springbook.polymorphism;

public class TVUser {
	public static void main(String[] args) {
		TV tv = new SamsungTV(); // 묵시적 형변환을 통해 객체를 참조
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
	}

}
```

- 묵시적 형변환을 통해 객체를 참조하면 SamsungTV를 LgTV로 변경할 때, **참조하는 객체만 변경**하면 객체를 **쉽게 교체**할 수 있다.
- 다형성을 이용하여, 최소한의 수정으로 **유지보수 가능**

# 2.3.3 디자인 패턴 이용 → 결합도 낮추기

- TV 교체할 때, 클라이언트 소스를 수정하지 않고 TV를 교체 할 수 있으면 → 유지보수가 쉬워질 것

  - **Factory 패턴**

  Factory 패턴

  - 클라이언트에서 사용할 **객체 생성**을 **캡슐화**하여 느슨한 결합 상태를 만드는 패턴

## 1. BeanFactory 클래스 작성 (`BeanFactory.java`)

```java
package com.springbook.polymorphism;

public class BeanFactory {
	public Object getBean(String beanName) {
		if (beanName.equals("samsung")) {
			return new SamsungTV();
		} else if (beanName.equals("lg")) {
			return new LgTV();
		}
		
		return null;
	}

}
```

- ```
  getBean()
  ```

   메소드

  - 매개변수로 받은 **beanName에 해당하는 객체**를 **생성**하여 리턴

## 2. BeanFactory 클래스를 이용하여 사용할 객체를 획득하도록 TVUser 클래스 수정

```java
package com.springbook.polymorphism;

public class TVUser {
	public static void main(String[] args) {
		BeanFactory fatory = new BeanFactory();
		Tv tv = (TV)factory.getBean(args[0]); // getBean("lg")
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
	}

}
```

- 클라이언트에 해당하는 `TVUser` 는 **자신이 필요한 객체를 직접 생성하지 않음**

- ```
  TVUser
  ```

   클래스는 단지 객체가 필요하다는 것을 

  ```
  BeanFactory
  ```

   에 요청하고,

  - `BeanFactory` 가 클라이언트가 **사용할 TV 객체를 생성하여 넘겨줌**
  - TV가 변경될 때 마다 소스를 수정할 필요가 없음