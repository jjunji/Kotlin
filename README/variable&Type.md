## **Kotlin**

###**변수**

```java
keyword name   type  value 
  var testInt : Int = 32**
```

**var & val**

* var 
	* variable
	* read/write
	* Java normal variable

* val
	* value
	* read only
	* Java final variable

```java
val immutable : String = "immutable"
var mutable : String = "mutable"

immutable = "test" -> 에러
mutable = "test" 


val value : Int 
// 처음 초기화하는 것은 괜찮음.
value = 3; -> OK
value = 4; -> Error
```
* 함수형 프로그래밍을 해보고 싶거나, SideEffect를 피하고 싶다면 var 보다는 val
*  타입 생략 가능.(컴파일러가 추론)
	* 가독성이나 유지보수 측면에서 명시적으로 선언해주는 것이 좋음.
* 세미콜론 생략 가능.

코틀린 변수는 지역변수이며, 전역 변수의 개념이 없다.

***

**타입**

* 자바와 다르게 코틀린에서는 숫자 타입 간의 변환을 자동으로 해주지 않음.
* 변환 함수를 호출해서 해결해야 한다.
*  숫자 리터럴 값이 표현식에 포함되어 있을 때는 컴파일러가 자동으로 변환해줌.
* String 타입 변수 값은 변경되지 않는다.
```
var s : String = "변경 전"
println(s)
s = "변경 후"
println(s)
```
보는 관점에서는 변경됨.
내부적으로는 변경된 값을 갖는 String 객체가 메모리의 다른곳에 생성된 것.
-> 이것은 자바와 동일하며 메모리 낭비가 생길 수 있으니 주의.

<br>

**문자열 리터럴**

```
val s = "가나다 \n 라마바사 \n"

val s = """
	가나다라마
	바사아자차
	카타파하
	"""
```
여백 줄바꿈 모두 반영됨.

변수 이름 앞에 $ 기호를 붙여 문자열 템플릿을 만들어 문자열 접합에 사용할 수 있다.

***
