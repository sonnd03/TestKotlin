package com.example.test.tasks.task2

// Function

// function default
fun name(a: Int) {
    return println(a)
}

// function return
fun name1(a: Int): String {
    return println(a).toString()
}

// function Unit
fun message(message: String): Unit{
    println(message)
}

// function on line
fun name2(a: Int, b: Int = 0): Int = a + b
fun name3(a: Int, b: Int): String = (a + b).toString()
fun name4(a: Int) = println(a)

//function can change
fun functionChange(vararg a: Int){
    for(i in a) println("stt: $i");
}
// lambda function
val name5 = {a: Int, b: String -> println("a: $a  b: $b") }

// anonymous function
val name6 = fun(a: Int, b: Int): Int {
    return a + b
}

// extension function
fun String.lasChar(): Char = this[this.length - 1]

fun String.repeatChar(n: Int): String{
    return repeat(n)
}

fun String.link(a: String = "nguyendacson"): String = a+this

fun Int.sumInt(a: Int, b: Int) : Int = a + this + b;

// higher order function
fun high(a: Int, b:Int, sum : (Int, Int) -> Int) : Int {
    return sum(a, b)
}

fun high1(a: Int, b: Int,  sum: (Int,Int) -> Int): Int{
    return sum(a,b)
}

fun checkOrder(type: String) : (Int, Int) -> Int {
    return when(type){
        "plus" -> {a,b -> a + b}
        "minus" -> {a,b -> a - b}
        else -> {_,_ -> 0}
    }
}

fun voi(a: String, b: String , void: (String, String) -> String) : String {
    return void(a, b)
}

class Rectangle(val width: Int, val height: Int) {
    val area: Int

    init {
        area = width * height
    }
    init {
        println("Init 2: x*2 ")
    }
}




fun main() {
//    voi("nguyendacson","nguyendacson1"){a,b -> println(a + b).toString()}
//
//    high1(1,2){a,b -> a+b}

    val rectangle = Rectangle(1,2)
    println(rectangle.area)



//    val sum: Int = checkOrder("plus")(12,2)
//    println(sum)
//
//    var sum1 = high(1,2){a,b -> a + b}
//    println(name3(1,2))
//    name1(12)
//    name4(18)
//    message("nguyendacson")
//    println(name3(b = 12, a = 1))
//    functionChange(1,2,3,4,5,6,7,8,9,10)
//    name5(12, "nguyendacson")
//    val name:String = "Hi"
//    println(name.lasChar())
//    println(name.repeatChar(5))

//    val a = 10;
//    println(a.sumInt(1,2))
//    var linkDefault = "nguyendacson.hhtp"
//    val fullLink = linkDefault.link("link1")
//    val fullLink1 = linkDefault.link()
//
//    println(fullLink)
//    println(fullLink1)

}