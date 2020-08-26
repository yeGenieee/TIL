##  스프링 부트 소개

### Spring Boot 란?

- 스프링 개발시 폭 넓은 사용성을 제공, 빠르고 쉽게 만들 수 있음
- opinionated view : 사용자가 일일이 설정하지 않아도 제공 (convention 제공)
- Tomcat에 대한 설정을 기본적으로 제공



### Spring Boot 시작하기

- SpringBoot Application 만들기

```java
package me.whiteship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

- Spring MVC가 동작하기 위한 수많은 dependency가 어떻게 들어왔는가??



## SpringBoot Project를 만드는 또 다른 방법

[Spring Initializer]https://start.spring.io/ 이용





## SpringBoot 프로젝트 구조

메이븐 기본 프로젝트 구조와 동일

- 소스 코드 (src\main\java)
- 소스 리소스 (src\main\resource)
- 테스트 코드 (src\test\java)
- 테스트 리소스 (src\test\resource)



**메인 애플리케이션 위치 **(@SpringBootApplication)

- 추천 위치 : 기본 패키지 (default package)
  - 이유?
    - 컴포넌트 스캔을 하기 때문!
    - 메인 애플리케이션이 위치한 패키지 하위를 다 스캔하여 Bean으로 등록하기 때문