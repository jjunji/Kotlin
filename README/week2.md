##**�ڹٿ��� ��Ʋ�� ����ϱ�**

* Kotlin�ڵ�� Java���� ���� ȣ�� �� �� �ִ�.
* Property���� ������ ���� ȣ���Ѵ�.
	*  getter �޼ҵ�� get prefix�� �ٴ´�.
	* setter �޼ҵ�� set prefix�� �ٴ´�.
	*  setter �޼ҵ�� var property���� ����Ѵ�.
	*  is �� �����ϴ� property�� ���ؼ��� get prefix�� ���� �ʰ� is�� �����˴ϴ�.
	*  is �� �����ϴ� property setter�� set prefix�� �ٽ��ϴ�.

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
�� ��Ʋ�� ������ �̸��� MyUtils�� �ƴ� ���� �ٸ��� ������ ��쿡�� @file:JvmMultifileClass
�� ������ �ʿ� ����.

������̼� �߰� ��ġ�� ��Ű�� ���𺸴ٵ� ���� ����Ǿ����.(�ֻ�����)

�ٸ� ������ ������ �ִ� �Լ��� ���� �̸����� ������ �� ����.
-> ������ �� �ش� ������ ������Ʈ�� ��������� ���� (�����̸��ڿ� Kt���� ���·� ������.)

�̷��� ��Ģ�� �����ϰ� ������ �Ʒ��� ���� ������̼��� �߰��ؾ� �Ѵ�.

* @file:JvmName("MyUtils") : �����Ϸ��� CallKotilnKt object �ڵ� ����
* @file:JvmMultifileClass : ���� �̸��� �Ϳ� ������� ���� .kt ���Ͽ� �̸��� ����.

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
* @JvmField annotation�� ����ϸ� java������ kotlin�� property�� ������ �� �ִ�.
* private, open, override, const Ű����, delegate property���� ����� �� ����.
*  lateinit ���� ��� �����ϴ�.

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
* companion object�� ���� java���� ����ϴ� static �ʵ� �� �޼��带 ������ �� �ִ�.
*  ������Ʈ.�ʵ�.�ʵ� ������ ���� companion object ���� �ʵ带 static ó�� ���� �� �� �ִ�.
*  @JvmField, const, lateinit Ű���带 ����ϸ�, .Companion�� ������� �ʾƵ� �ȴ�.

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

##**�����ε�**

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
��
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
ó�� ǥ�� ����.
������ 3�� ������ �ʿ� ���� ���� 3�� �س�����
3�� �˾Ƽ� �������ش�.
***
