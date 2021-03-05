# Array

  배열은 다수의 비슷한 아이템을 저장하는데 적합한 간단한 자료구조이다. 모든 프로그래밍 언어에서 지원하는 데이터 타입이며, 거의 모든 자료구조들이 배열을 사용하여 구현된다.

## 학습 목표

1. 배열이란 무엇인지에 대해 안다
2. 배열의 기본 특성에 대해 안다
3. 기초 배열 연산을 구현한다
4. 배열을 이용한 간단한 프로그래밍 기술을 안다

## What is an Array?

  배열은 여러 개의 동일한 데이터 타입의 데이터를 한 번에 만들 때 사용된다. 배열은 연속된 공간을 할당받기 때문에 데이터 처리 속도가 빠르다는 장점을 가지고 있다.



### Creating an Array

  컴퓨터에서 배열은 `N` 개의 아이템을 저장할 수 있는데, 여기서의 `N` 은 프로그래머가 배열 생성 시점에 결정한다. 또한, 배열을 생성할 때는 배열에 담길 아이템의 타입을 지정해주어야 한다.

```
타입 배열의이름[N];
```

```java
int arr[6];
```



#### DVD 클래스와 15개의 DVD를 담을 수 있는 DVD 배열 생성 예제

```java
// DVD를 담을 배열 생성
DVD[] dvdCollection = new DVD[15];
```

#### DVD 클래스

```java
public class DVD {
    public String name;
    public int releaseYear;
    public String director;

    public DVD(String name, int releaseYear, String director) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.director = director;
    }

    public String toString() {
        return (this.name + " , directed by " + this.director + " , released in " + this.releaseYear);
    }
}
```

- 배열의 크기가 15인 `dvdCollection` 배열을 선언 후 생성하였다
  - 각 공간에 하나씩의 DVD를 가지고 있을 수 있고, 배열이 생성된 직후에는 배열 안에 DVD가 당연히 없다
  - 개발자가 직접 배열에 DVD를 넣어주어야 한다
  - 크기가 15이기 때문에, 15개의 DVD까지만 저장할 수 있고, 만약 16번째 DVD를 저장하고자 한다면, 새로운 배열을 생성해야 한다
- 배열의 공간을 모두 사용한 경우에 어떻게 다뤄야 하는지는 이후에 살펴보자

> 처음 배열의 크기를 굉장히 크게 주면 어떨까?
>
> - 적은 수의 요소들을 저장하기 위해 배열의 크기를 처음부터 너무 크게 주는 것은 컴퓨터 메모리 사용에 있어서 굉장히 비효율적이다
> - 따라서, 터무니없이 배열의 크기를 크게 주지 않는다



## Accessing Elements in Arrays

  배열의 대표적인 두 가지 연산은 아래와 같다. 배열의 다른 연산들은 이 두 가지 기초적인 연산을 바탕으로 이루어진다.

1. 배열에 요소를 저장한다
2. 배열에 저장된 요소를 읽어온다



### 1. Writing Items into an Array

  배열 안에 요소를 저장하기 위해서는, 배열의 어디에 저장할지를 결정해야 한다. 배열의 각 공간은 `0` 부터 `N-1` 의 범위를 가지는 숫자를 이용하여 특정할 수 있다. 첫번째 공간은 `0`, 두번째 공간은 `1` ... 이렇게 나아가며, 마지막 15번째 공간은 `14` 라는 숫자를 이용하여 접근할 수 있다. 여기서 사용되는 배열의 공간을 특정하는 이 숫자를 우리는 `index` 라고 부른다.

**DVDCollection 배열의 8번째 공간에 아이템을 저장해보자**

```java
DVD avengersDVD = new DVD("The Avengers", 2012, "Joss Whedon"); // DVD 객체 생성

dvdCollection[7] = avengersDVD; // 8번째 공간에 avengers 저장
```

- index를 가지고 배열에 아이템을 저장할 수 있다
- 배열에 다른 DVD를 더 저장해보자

```java
DVD incrediblesDVD = new DVD("The Incredibles", 2004, "Brad Bird");
DVD findingDoryDVD = new DVD("Finding Dory", 2016, "Andrew Stanton");
DVD lionKingDVD = new DVD("The Lion King", 2019, "Jon Favreau");

dvdCollection[3] = incrediblesDVD;
dvdCollection[9] = findingDoryDVD;
dvdCollection[2] = lionKingDVD;
```



- 만약, 이미 `incrediblesDVD` 가 저장된 4번째 공간에 다른 DVD를 저장하면 어떻게 될까?

  ```java
  DVD starWarsDVD = new DVD("Star Wars", 1977, "George Lucas");
  dvdCollection[3] = starWarsDVD;
  ```

  - `dvdCollection` 배열의 4번째 공간에 `starWarsDVD` 를 저장하였기 때문에 이제 더 이상 `incrediblesDVD` 는 해당 배열에 저장되어있지 않게 된다 (덮어쓰여지게 됨)

### 2. Reading Items from an Array

  배열의 특정 인덱스에 어떤 아이템이 들어있을까?

```java
System.out.println(dvdCollections[7]);
System.out.println(dvdCollections[10]);
System.out.println(dvdCollections[3]);

/*
The Avengers, directed by Joss Whedon, released in 2012
null
Star Wars, directed by George Lucas, released in 1977
*/
```

- 특정 index 를 통해서 배열 내 아이템에 접근할 수 있다
- Java에서는 항상 배열을 선언 시, 아래와 같은 값으로 초기화한다
  - 객체 배열인 경우 : null로 초기화
  - primitive type : 해당 타입의 default 값으로 초기화



### 3. Writing Items into an Array with a Loop

  배열에 다수의 값을 저장할 때는 흔히 반복문을 이용한다. 아래 예제를 통해 반복문을 이용하여 배열에 값을 저장하는 방법을 살펴보자

```java
int squareNumbers = new int[10];

for (int i=0; i<10; i++) {
		int square = (i + 1) * (i + 1);
		squareNumbers[i] = square;
}
```

- 반복문을 통해 i 번째 인덱스에 값을 저장하는 것을 확인할 수 있다



### 4. Reading Items from an Array with a Loop

  반복문을 이용하여 배열에 값을 저장했던 것처럼, 값을 읽어올 수도 있다.

```java
for (int i=0; i<10; i++) {
		System.out.print(squareNumbers[i] + " ");
}

/*
1 4 9 16 25 36 49 64 81 100
*/
```

```java
for (int square : squareNumbers) {
		System.out.print(square);
}
```



## Array Capacity VS Length

















