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
�Ǵ�
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
* Java�� �ٸ��� Kotlin������ if, else�� ǥ����. ���� ��ȯ���� �׻� �ִ�.
*  { } ������ ���� ��쿡�� ������ ���� ���� ��ȯ�Ѵ�.
*  if, else �� ǥ�������� ����� ��쿡�� if�� ������ else�� �׻� �־�� �Ѵ�.

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
when ����
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
* switch - case �� ���
*  ǥ�������� Ȱ���� �� �־� ���� �Ҵ��� �� �ִ�.
* when ���� type�� �б� �ϸ� ������ casting ���� �ʾƵ� �ȴ�.
*  when�� ǥ�������� ����� ��� else �� �׻� �־�� �Ѵ�.


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
����Ʈ ĳ����
```
fun test(x: Any) : Any = when(x) {
    is String -> x.startsWith("prefix")
    is Int -> x + 3
    is Person -> x.name
    else -> false
}
```
��Ʋ�������� ��ü�� �ش� Ŭ���� Ÿ������ Ȯ���� �� is ���.
Any : �ֻ��� ��ü�� (�ڹ��� Object�� ����)


test
```
fun main(args: Array<String>) {
    checkString("testggg")
}

fun checkString(x : Any) : Unit{
    when(x) {
        is String -> if(x.startsWith("test")){
            print("test�� ������")
        }
//        is String -> println("String")
//        is String -> if(x.length>3){
//            println("���� 3���� ŭ")
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
* Java�� try-catch�� ���.
*  ǥ�������� Ȱ���� �� �־� ���� �Ҵ��� �� �ִ�.
*  �������� case���� try����, exception �߻��ϸ� catch ���� �Ҵ�ȴ�.
*  finally�� ����, optional��.
