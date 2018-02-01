## **Kotlin**

###**�Լ�**

```
  Ű����  �̸�    �Ķ����     ��ȯŸ��
	fun add (x:Int, y:Int) : Int{
		return x+y // �ٵ�
	}
```
==
```
fun add(x:Int, y:Int) : Int = x+y
```

* fun Ű���� ���
*  �Լ��� ��ȯ Ÿ�� ���� �Ұ�. ���� ������ ���� ��ȯŸ���� Unit �� ���
	* Unit(�ڹ��� void �� ��� ) , Unit�� ������ Singleton��ü
	* ����Ÿ���� �����ϸ� default�� ��ȯŸ���� Unit�� �ȴ�.
* Body �� �� ���� ��� {...} ��� = ���� ��� �� �� ����.
* class �� object ���ο� �������� �ʰ� ���� ������ ������ �� ����.

```java
fun min(left:Int, right:Int) : Int{
	return if(left < right) left else right
}
```
�� �� ��� �� ���� ����.
```
fun min(left:Int, right:Int) = 
					if(left < right) left else right
```
��Ʋ������ if�� ��ɹ� ���ٴ� ǥ�������� �����ϹǷ�,
return���̳� ���Թ� � �ٷ� �߰��� �� �ִ�.

��ȯŸ���� �����Ǿ ���� X
ifǥ������ ����� Int Ÿ���̹Ƿ�, �Լ��� ��ȯ Ÿ���� Int��� ���� �����Ϸ��� �߷��� �ֱ� ����.

* �Ű������� �����̸� : Ÿ�� ���·� ����
* �ΰ� �̻��� ���� ��ǥ�� ����
* ���� ���� ����.(�Ű������� ���� �����ϴ� ���� �ƴϰ� �Ű����� �̸��� ���� ���� ������ �� �ִٴ� �ǹ�)

ex) min �Լ��� ȣ�� ���� ����
```java
fun min(left:Int = 0, right:Int = 0) = 
			if(left < right) left else right
```

```
min(100, 50)
min(100)   // rigth �Ű� ������ �⺻���� 0�� �ȴ�.
min()      // �� �Ű� ���� ��� �⺻���� 0�̵�
min(left=50, right = 100)  // �������ڸ� ����ؼ� �� ����
min(right=100, left = 50)  // ������ �����ϰ� �� ���� ����
min(left=50)    // �������� & �⺻�� ��� ����Ͽ� ȣ��
```

***

**�ϱް�ü(First-class citizen)**

* ��ü�� ���ڷ� ���� �� �� �־�� �Ѵ�.
*  ��ü�� ��ȯ������ ��ȯ�� �� �־�� �Ѵ�.
*  �ڷᱸ���� ���� �� �־�� �Ѵ�.
*  ��Ʋ���� �Լ��� 1�� ��ü.
*  �ڹ��� �Լ��� �� ������ �������� ���ϹǷ� 1�� ��ü�� �ƴ�.
* java�� Ŭ������ 1�� ��ü��� ���� �� �ִ�.

***

**Pure Function**

* ȣ���� �� ���� �׻� ���� ���� ������ �Լ�
* ���¸� �ٲٰų� �ܺ��� ���� �����Ѵٸ� -> ���� �Լ��� �ƴ� ���ɼ��� ����.
*  �׻� ���� ���� ���;� sideEffect�� ����.

***

**High-order-function(�����Լ�)**

High-order-function�̶� 2���� �� �ϳ��̻��� �����ϴ� �Լ��� ���Ѵ�.
* �Լ��� �Ķ���ͷ� ���� �޴� �Լ�
* �Լ��� �����ϴ� �Լ�

```
object Main { 
     fun main(args: Array<String>) { 
         println(simpleHighOrderFunction({ x, y -> x + y }, 10, 20)) 
         //30 
     } 
 
     fun simpleHighOrderFunction(sum: (Int, Int) -> Int, a Int, b: Int): Int = sum(a, b) 
 } 
```
simpleHighOrderFunction�� �Ķ���� :  sum �̶�� �Լ� �ϳ��� Int �� 2��
sum�Ķ���ʹ� Int �� 2���� ���޹޾� Int���� ��ȯ�ϴ� �Լ�.

simpleHighOrderFunction �� �Լ��� �Ķ���ͷ� ���� �޾����Ƿ� High-order-function �̶�� �� �� �� �ִ�.

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
funA()�� callByValue�� �Ķ���ͷ� ���޵�. -> �ٷ� �Լ��� ����ǰ� ���� ��ȯ ���� true�� ���޵ǰ���?

���� ���� ����ϴ� Ÿ�̹��� callByValue �޼ҵ� ���ο��� println(��callByValue��)�� ȣ��� ����

callByValue ������ �Լ��� argument�� ���� �� ��, �򰡵ǰ� �򰡵� ���� �޼ҵ��� �Ķ���ͷ� ���޵ȴ�. 
�׷��� ������ ��funA�� �� ���� print �ǰ� ��callByName���� ���Ŀ� ��µ�.

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
callByName�� funA�� �Ķ���ͷ� ������ ������ �ƴ� f()�� call�Ǵ� ������ ���� �򰡵ȴ�.

��Ȳ�� ���� Ư�� �Լ��� ȣ�� �� ���� �ְ� ȣ�� ���� ���� �� �ִٸ� �Լ��� �򰡸� Lazy �ϰ�  ȿ��������ó�� �� �� �ֽ��ϴ�.
