package com.example.test.tasks.task2

import com.example.test.tasks.task2.FunDefault.Companion.lastChar
import com.example.test.tasks.task2.FunDefault.Companion.repeatChar
import com.example.test.tasks.task2.FunDefault.Companion.sumInt

private class FunDefault() {
    // function default
    fun funDefault(a: Int) {
        return println(a)               // Hello
    }

    // function return type + Default parameter
    fun funReturnType(a: Int = 12): String {
        return a.toString()             // 18
    }

    // function Unit
    fun funUnit(message: String): Unit {
        println(message)                // Nguyen Dac Son
    }

    // function one line
    fun funOneLine(a: Int, b: Int = 0): Int = a + b
    fun funOneLine1(a: Int, b: Int): String = (a + b).toString()
    fun funOneLine2(a: Int) = println("value a: $a")

    // lambda function
    val funLamda = { a: Int, b: String -> println("a: $a  b: $b") } // a: 18  b: NguyenDacSon

    // function can change parameter
    fun functionChange(vararg a: Int) {
        for (i in a) print("stt: $i");                              // stt: 18 stt: 2 stt: 2003
    }

    // anonymous function
    val funAnonymous = fun(a: Int, b: Int): Int {
        return a + b
    }

    // extension function
    companion object {
        fun String.lastChar(): Char = this[this.length - 1]

        fun String.repeatChar(n: Int): String {
            return repeat(n)
        }

        fun String.link(a: String = "link: "): String = a + this

        fun Int.sumInt(a: Int, b: Int): Int = a + this + b;
    }

    // fun Void
    fun funVoid(a: String, b: String, void: (String, String) -> String): String {
        return void(a, b)
    }
}

// function Initializer Blocks
class Rectangle(val width: Int, val height: Int) {
    var area: Int

    // fun init
    init {
        area = width * height
    }

    init {
        println("Hello")
    }
}

private class HeightOrderFunction() {
    fun high(a: Int, b: Int, sum: (Int, Int) -> Int): Int {
        return sum(a, b)
    }

    /// when
    fun checkOrder(type: String): (Int, Int) -> Int {
        return when (type) {
            "plus" -> { a, b -> a + b }
            "minus" -> { a, b -> a - b }
            else -> { _, _ -> 0 }
        }
    }
}

fun main() {
    val myfunDefault = FunDefault()
    val myFunOnBlock = Rectangle(18, 2)
    val highOrderFunction = HeightOrderFunction()
    val name = "NguyenDacSon"
    val a = 18

    // function default
    myfunDefault.funDefault(18)

    // function return type
    myfunDefault.funReturnType(18)

    // function Unit
    myfunDefault.funUnit("Nguyen Dac Son")

    // function one line + Named Argument
    println("sum a,b = ${myfunDefault.funOneLine(b = 2, a = 18)}")              // sum a,b = 20
    println("sum (a,b).toString = ${myfunDefault.funOneLine1(18, 2)}")  // sum (a,b).toString = 20
    myfunDefault.funOneLine2(2003)                                          // value a: 2003

    // lambda function
    myfunDefault.funLamda(18, "NguyenDacSon")

    // function can change
    myfunDefault.functionChange(18, 2, 2003)

    // anonymous function
    println("value funAnonymous: ${myfunDefault.funAnonymous(2, 2003)}")        // value funAnonymous: 2005

    // extension function
    println("Use extension Fun get last: ${name.lastChar()}")                  // User extension Fun get last: n
    println("Use extension Fun repeatChar: ${name.repeatChar(3)}")         // User extension Fun repeatChar: NguyenDacSonNguyenDacSonNguyenDacSon
    println("Use extension Fun sumOtherList: ${a.sumInt(18, 2)}")       // User extension Fun sumOtherList: 38

    // fun void
    println(
        "fun void: ${
            myfunDefault.funVoid(
                "NguyenDacSon",
                "twenty two old"
            ) { a, b -> "$a $b" }
        }"
    )      // fun void: NguyenDacSon twenty two old

    // function Initializer Blocks
    print("value area before set data: ${myFunOnBlock.area}")      // value area before set data: 36
    myFunOnBlock.area = 12
    print("value area after set data: ${myFunOnBlock.area}")       // value area after set data: 12

    // higher order function
    println(
        "value heightOderFunction: ${
            highOrderFunction.high(18, 2) { a, b -> a + b }}"
    )     // value heightOderFunction: 20
    println(
        "value heightOderFunctionUseWhen: ${highOrderFunction.checkOrder("plus")(18, 2)}"
    )    // value heightOderFunctionUseWhen: 20
}