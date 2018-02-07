@file:JvmName("MyUtils")
@file:JvmMultifileClass

fun foo(){

}

data class Person(val name:String, val age:Int, var position: Position,
                  private val counter: String? = null)

enum class Position{
    TOP, MID, BOTTOM, SUPPORT, JUNGLE
}
