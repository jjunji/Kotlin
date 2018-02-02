## **Kotlin**

###**Expression**

**if-else**

java
```java
int a = 5;
int b = 10;

int maxValue = a;

if (a > b) {
     maxValue = a;
} else {
	maxValue = b;
}
```

kotlin
```
var max: Int

if (a > b) {
     max = a
} else {
     max = b
}
```
또는
```
val max = if (a > b) a else b
```

```
val max = if (a > b) {
     print("Choose a")
     a
} else {
     print("Choose b")
     b
}
```
* Java와 다르게 Kotlin에서는 if, else도 표현식. 따라서 반환값이 항상 있다.
*  { } 블럭으로 있을 경우에는 마지막 줄의 값을 반환한다.
*  if, else 를 표현식으로 사용할 경우에는 if가 있으면 else도 항상 있어야 한다.

***

**when**

java
```java
int x = 1;
switch (x) {
     case 1: {
         System.out.println("1");
         break;
     }
     case 2: {
         System.out.println("2");
         break;
     }
     default: {
         System.out.println("default");
         break;
     }
}
```
kotlin 
when 사용법
```
val x = 1

// 1.
when {
	x == 1 -> print("x == 1")
	x == 2 -> print("x == 2")
	else -> { // Note the block
	    print("x is neither 1 nor 2")
	}
}

// 2.
when (x){
	1 -> print("x == 1")
	2 -> print("x == 2")
	else -> { // Note the block
	    print("x is neither 1 nor 2")
	}
}


// 3.
when (x) {
	0, 1 -> print("x == 0 or x==1")
	else -> print("otherwise")
}


// 4.
val s = "1"
val x = 1

when (x) {
     parseInt(s) -> print("s encodes x")
     else -> print("s does not encode x")
    }
}

fun parseInt(value : String) : Int {
    return 1
}


// 5.
val x = 129
val validNumbers = 100..120

fun check (): Unit{
    when (x) {
        in 1..10 -> print("x is in the range");
        in validNumbers -> print("x is valid");
        !in 10..20 -> print("x is outside the range");
        else -> print("none of the above");
    }
}

```
* switch - case 와 비슷
*  표현식으로 활용할 수 있어 값을 할당할 수 있다.
* when 으로 type을 분기 하면 별도로 casting 하지 않아도 된다.
*  when을 표현식으로 사용할 경우 else 도 항상 있어야 한다.


java
```java
public void test(Object obj) {
     if (obj instanceof String) {
         System.out.println(((String)obj).startsWith("preFix"));
     } else if (obj instanceof Integer){
         Integer.valueOf(String.valueOf(obj));
     } else if (obj instanceof JavaPerson) {
         ((JavaPerson) obj).getName();
     } 
}
```
kotlin
스마트 캐스팅
```
fun test(x: Any) : Any = when(x) {
    is String -> x.startsWith("prefix")
    is Int -> x + 3
    is Person -> x.name
    else -> false
}
```
코틀린에서는 객체가 해당 클래스 타입인지 확인할 때 is 사용.
Any : 최상위 객체로 (자바의 Object와 같음)


test
```
fun main(args: Array<String>) {
    checkString("testggg")
}

fun checkString(x : Any) : Unit{
    when(x) {
        is String -> if(x.startsWith("test")){
            print("test로 시작함")
        }
//        is String -> println("String")
//        is String -> if(x.length>3){
//            println("길이 3보다 큼")
//        }
    }
}
```

***

**try-catch**

java
```java
String value = "test";
int parsedInt;

try {
     parsedInt = Integer.parseInt(value);
} catch (NumberFormatException e) {
     e.printStackTrace();
     parsedInt = -1;
}

System.out.println(parsedInt); // -1
```
Kotlin
```
val value = "test"
val parsedInt: Int? = try {
	value.toInt()
} catch (e: NumberFormatException) {
    -1
}
println(parsedInt)  //-1
```
* Java의 try-catch와 비슷.
*  표현식으로 활용할 수 있어 값을 할당할 수 있다.
*  정상적인 case에는 try값이, exception 발생하면 catch 값이 할당된다.
*  finally도 제공, optional임.
