fun main(args: Array<String>) {
    println("Hello Kotliin")
    println(sum(1, 2, 3, { a, b, c -> a + b + c }))
    println(sum(2, 3, 4, { x, y, z -> x * y * z }))
    println(check());

    val value = "test"
    val parsedInt: Int? = try {
        value.toInt()
    } catch (e: NumberFormatException) {
        -1
    }
    println(parsedInt)  //-1
}

// function 메서드의 반환 타입을 Int라고 명시 했는데 sum 함수의 반환타입 Int 를 또 써줘야하는건가
fun sum(a: Int, b: Int, c: Int, function: (Int, Int, Int) -> Int): Int {
    return function(a, b, c)
}


val x = 129
val validNumbers = 100..120

fun check(): Unit {
    when (x) {
        in 1..10 -> print("x is in the range");
        in validNumbers -> print("x is valid");
        !in 10..20 -> print("x is outside the range");
        else -> print("none of the above");
    }
}

fun test(x: Any): Any = when (x) {
    is String -> x.startsWith("prefix")
    is Int -> x + 3
//is Person -> x.name
    else -> false
}