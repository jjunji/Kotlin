## **Kotlin**

###**함수**

```
  키워드  이름    파라미터     반환타입
	fun add (x:Int, y:Int) : Int{
		return x+y // 바디
	}
```
==
```
fun add(x:Int, y:Int) : Int = x+y
```

* fun 키워드 사용
*  함수의 반환 타입 생략 불가. 생략 가능한 경우는 반환타입이 Unit 인 경우
	* Unit(자바의 void 와 비슷 ) , Unit은 실제로 Singleton객체
	* 리턴타입을 생략하면 default로 반환타입은 Unit이 된다.
* Body 가 한 줄인 경우 {...} 대신 = 으로 대신 할 수 있음.
* class 나 object 내부에 선언하지 않고 파일 레벨에 선언할 수 있음.

```java
fun min(left:Int, right:Int) : Int{
	return if(left < right) left else right
}
```
를 더 축약 할 수도 있음.
```
fun min(left:Int, right:Int) = 
					if(left < right) left else right
```
코틀린에서 if를 명령문 보다는 표현식으로 간주하므로,
return문이나 대입문 등에 바로 추가할 수 있다.

반환타입이 생략되어도 에러 X
if표현식의 결과가 Int 타입이므로, 함수의 반환 타입이 Int라는 것을 컴파일러가 추론해 주기 때문.

* 매개변수는 변수이름 : 타입 형태로 지정
* 두개 이상일 때는 쉼표로 구분
* 지명 인자 지원.(매개변수의 값만 전달하는 것이 아니고 매개변수 이름과 값을 같이 지정할 수 있다는 의미)

ex) min 함수의 호출 가능 형태
```java
fun min(left:Int = 0, right:Int = 0) = 
			if(left < right) left else right
```

```
min(100, 50)
min(100)   // rigth 매개 변수는 기본값인 0이 된다.
min()      // 두 매개 변수 모두 기본값인 0이됨
min(left=50, right = 100)  // 지명인자를 사용해서 값 전달
min(right=100, left = 50)  // 순서와 무관하게 값 전달 가능
min(left=50)    // 지명인자 & 기본값 모두 사용하여 호출
```

***

**일급객체(First-class citizen)**

* 객체의 인자로 전달 할 수 있어야 한다.
*  객체의 반환값으로 반환할 수 있어야 한다.
*  자료구조에 넣을 수 있어야 한다.
*  코틀린의 함수는 1급 객체.
*  자바의 함수는 위 조건을 만족하지 못하므로 1급 객체가 아님.
* java의 클래스는 1급 객체라고 말할 수 있다.

***

**Pure Function**

* 호출할 때 마다 항상 같은 값이 나오는 함수
* 상태를 바꾸거나 외부의 값을 참조한다면 -> 순수 함수가 아닐 가능성이 높다.
*  항상 같은 값이 나와야 sideEffect가 없음.

***

**High-order-function(고차함수)**

High-order-function이란 2가지 중 하나이상을 만족하는 함수를 말한다.
* 함수를 파라미터로 전달 받는 함수
* 함수를 리턴하는 함수

```
object Main { 
     fun main(args: Array<String>) { 
         println(simpleHighOrderFunction({ x, y -> x + y }, 10, 20)) 
         //30 
     } 
 
     fun simpleHighOrderFunction(sum: (Int, Int) -> Int, a Int, b: Int): Int = sum(a, b) 
 } 
```
simpleHighOrderFunction의 파라미터 :  sum 이라는 함수 하나와 Int 값 2개
sum파라미터는 Int 값 2개를 전달받아 Int값을 반환하는 함수.

simpleHighOrderFunction 은 함수를 파라미터로 전달 받았으므로 High-order-function 이라고 말 할 수 있다.

***

###**CallByValue & CallByName**

**CallByValue**

```
object Main { 
     @JvmStatic 
     fun main(args: Array<String>) { 
         callByValue(funA()) 
         // funA 
         // callByValue 
     } 
 
 
     fun callByValue(b: Boolean): Boolean { 
         println("callByValue") 
         return b 
     } 
 
     val funA: () -> Boolean = { 
         println("funA") 
         true 
     } 
 } 
```
funA()는 callByValue의 파라미터로 전달됨. -> 바로 함수가 실행되고 그의 반환 값인 true가 전달되겠지?

실제 값을 사용하는 타이밍은 callByValue 메소드 내부에서 println(“callByValue”)가 호출된 이후

callByValue 개념은 함수가 argument로 전달 될 때, 평가되고 평가된 값이 메소드의 파라미터로 전달된다. 
그렇기 때문에 “funA” 가 먼저 print 되고 “callByName”이 이후에 출력됨.

**CallByName**
```
object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        callByName(funA)
        // callByName
        // funA
    }

    fun callByName(f: () -> Boolean): Boolean {
        println("callByName")
        return f()
    }

    val funA: () -> Boolean = {
        println("funA")
        true
    }
}
```
callByName은 funA를 파라미터로 전달한 시점이 아닌 f()가 call되는 시점에 값이 평가된다.

상황에 따라 특정 함수를 호출 할 수도 있고 호출 하지 않을 수 있다면 함수의 평가를 Lazy 하게  효율적으로처리 할 수 있습니다.
