fun main(args: Array<String>) {
    println(youngChamp)
}

data class Person(val name: String, val age:Int, var position : Position)

enum class Position{
    TOP, MID, BOTTOM, SUPPORT, JUNGLE
}

val list = listOf(
    Person("Ari", 19, Position.MID),
    Person("Kass", 50, Position.MID),
    Person("Lux", 24, Position.MID),
    Person("Zac", 40, Position.JUNGLE),
    Person("Victor", 34, Position.TOP)
)

val youngChamp = list.filter { it.position == Position.MID }.minBy { it.age }

val midList = list.groupBy {  }
