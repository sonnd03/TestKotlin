package com.example.test.tasks.task2
// Function
    /// function default
    fun name(a: Int) {
        return println(a)
    }

    /// function return
    fun name1(a: Int): String {
        return println(a).toString()
    }

    /// function Unit
    fun message(message: String): Unit{
        println(message)
    }

    /// function one line
    fun name2(a: Int, b: Int = 0): Int = a + b
    fun name3(a: Int, b: Int): String = (a + b).toString()
    fun name4(a: Int) = println(a)

    /// function can change
    fun functionChange(vararg a: Int){
        for(i in a) println("stt: $i");
    }

    /// lambda function
    val name5 = {a: Int, b: String -> println("a: $a  b: $b") }

    /// anonymous function
    val name6 = fun(a: Int, b: Int): Int {
        return a + b
    }

    /// extension function
    fun String.lastChar(): Char = this[this.length - 1]

    fun String.repeatChar(n: Int): String{
        return repeat(n)
    }

    fun String.link(a: String = "nguyendacson"): String = a + this

    fun Int.sumInt(a: Int, b: Int) : Int = a + this + b;

// higher order function
    /// higher return function
    fun high(a: Int, b:Int, sum : (Int, Int) -> Int) : Int {
        return sum(a, b)
    }

    /// higher when
    fun checkOrder(type: String) : (Int, Int) -> Int {
        return when(type){
            "plus" -> {a,b -> a + b}
            "minus" -> {a,b -> a - b}
            else -> {_,_ -> 0}
        }
    }

    /// void
    fun voi(a: String, b: String , void: (String, String) -> String) : String {
        return void(a, b)
    }

    /// function Initializer Blocks
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
    name(12) // 12
    name1(12) // 12
    functionChange(1,2,3,4,5,6,7,8,9,10)

// extension function
    val name = "NguyenDacSon"
    val lastChar = name.lastChar() // n
    val repeatChar = name.repeatChar(2) //NguyenDacSonNguyenDacSon
    val fullLink = name.link() // nguyendacsonNguyenDacSon

// higher order function
    val height = high(18, 2){a,b -> a + b } // 20
    val heightWhen = checkOrder("plus")(12,2) // 14
    val char = voi("A","B"){a,b -> a + "plus" + b} // AplusB

// init
    val rectangle = Rectangle(1,2)
    println(rectangle.area)
}