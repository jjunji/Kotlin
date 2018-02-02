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