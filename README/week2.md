##**자바에서 코틀린 사용하기**

* Kotlin코드는 Java에서 쉽게 호출 할 수 있다.
* Property들은 다음과 같이 호출한다.
	*  getter 메소드는 get prefix가 붙는다.
	* setter 메소드는 set prefix가 붙는다.
	*  setter 메소드는 var property에만 허용한다.
	*  is 로 시작하는 property에 한해서만 get prefix가 붙지 않고 is가 유지됩니다.
	*  is 로 시작하는 property setter는 set prefix가 붙습니다.

```java
/* Kotlin */
data class Person(val name:String, val age:Int, var position: Position,
                  private val counter: String? = null)

enum class Position{
    TOP, MID, BOTTOM, SUPPORT, JUNGLE
}

fun main(args: Array<String>) {
    Calling.printPerson()
}


/* java */
public class Calling {
    public static void printPerson(){
        Person person = new Person("ari", 18, Position.MID, "none");

        System.out.println(person.getName()); // ok
        System.out.println(person.getAge());  // ok
        System.out.println(person.getPosition()); // ok
        //person.getCounter();  // Not visible (private)
        //person.setName("adf");  // Error val
        person.setPosition(Position.TOP); // ok
        System.out.println(person.getPosition());
    }
}
```

***

```java
/* Java */
public class Calling {
    public void function(){
        MyUtils.foo();
        MyUtils.bar();   
    }
}	


/* Kotlin */
@file:JvmName("MyUtils")
@file:JvmMultifileClass

fun foo(){

}


/* Kotlin */
@file:JvmName("MyUtils")
@file:JvmMultifileClass

fun bar(){

}
```
두 코틀린 파일의 이름을 MyUtils가 아닌 서로 다르게 지정한 경우에는 @file:JvmMultifileClass
를 선언할 필요 없다.

어노테이션 추가 위치는 패키지 선언보다도 위에 선언되어야함.(최상위에)

다른 파일이 가지고 있는 함수를 파일 이름으로 접근할 수 있음.
-> 컴파일 시 해당 파일이 오브젝트로 만들어지기 때문 (파일이름뒤에 Kt붙은 형태로 생성됨.)

이러한 규칙을 무시하고 싶으면 아래와 같이 어노테이션을 추가해야 한다.

* @file:JvmName("MyUtils") : 컴파일러가 CallKotilnKt object 자동 생성
* @file:JvmMultifileClass : 같은 이름인 것에 상관없이 각각 .kt 파일에 이름을 붙임.

***

```java
/* Kotlin */
class KotlinClass(id: String){
    @JvmField val Id = id
}

/* Java */
KotlinClass value = new KotlinClass("asdf");
value.ID = "AA";
System.out.println(value.ID);
```
* @JvmField annotation을 사용하면 java에서도 kotlin의 property로 접근할 수 있다.
* private, open, override, const 키워드, delegate property에는 사용할 수 없다.
*  lateinit 에는 사용 가능하다.

***

```
class Person(id: String){
    companion object {
        @JvmField var KEY_ID = "id"
    }
}

public static void main(String[] args){
    //System.out.printf(Person.Companion.getKEY_ID));
    System.out.printf(Person.KEY_ID);
}
```
* companion object를 통해 java에서 사용하는 static 필드 및 메서드를 구현할 수 있다.
*  오브젝트.필드.필드 형식을 통해 companion object 안의 필드를 static 처럼 접근 할 수 있다.
*  @JvmField, const, lateinit 키워드를 사용하면, .Companion을 사용하지 않아도 된다.

***

```
/* Kotlin */
class KotlinClass{
    companion object{
        var normal: Int = 1
        const val constValue: Int = 2
        @JvmField var jvmFiledValue: Int = 3
    }
}

/* Java */
public static void main(String[] args){
    int normal value = KotlinClass.Companion.getNormal();
    int constValue = KotlinClass.constValue;
    int jvmFieldValue = KotlinClass.jvmFiledValue;
    
    KotlinClass.Companion.setNormarl(2);
    KotlinClass.constValue = 3;  // error
    KotlinClass.jvmFiledValue = 5;
}
```
|   | |  <center>normal</center> |  <center>const</center> |  <center>@JvmName</center> |
|:--------|:--------:|--------:|
|**companion(prefix)** | <center>O</center> |<center>X</center>|<center>X </center> |
|**read** | <center>O </center> |<center>O</center> |<center>O </center> |
|**write** | <center>O</center> |<center>X</center> |<center>O </center> |
|**get, set(preFix)** | <center>O</center> |<center>X</center> |<center>X</center> |
|**with var** | <center>O</center> |<center>X</center> |<center>O </center> |

***

##**오버로드**

```
/* Kotlin */
@file:JvmName("MyUtils")
fun f(a: String, b: Int, c: Boolean) {}
fun f(a: String, b: Int) { } 
fun f(a: String) { 

/* Java */
MyUtils.f("test", 1, false);
MyUtils.f("test", 1);
MyUtils.f("test")
```
를
```
/* Kotlin */
@file:JvmName("MyUtils")
@JvmOverloads fun f(a: String, b: Int = 0, c: Boolean = false) {
	 TODO() 
 } 

/* Java */
MyUtils.f("test", 1, false);
MyUtils.f("test", 1);
MyUtils.f("test")
```
처럼 표현 가능.
생성자 3개 생성할 필요 없이 인자 3개 해놓으면
3개 알아서 생성해준다.
***
