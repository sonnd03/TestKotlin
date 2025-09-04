package com.example.test.tasks.task1.tasks.task1

var a = 12
const val b = 15
const val c = 18
var d: Int? = null
val listItem = listOf(1, 2, 3, 5, 4, 7, 8)
val array1 = arrayOf("Day", "Month", "Year")

fun ifSyntax() {
    // If statement
    if (a < b && a != 0) {
        println("b > a")
    } else {
        println("fail")
    }                                       // b > a

    // If as single-line statement
    if (a < b) d = a
    println("after check a<b: $d")          // after check a<b: 12

    // If expression
    d = if (a < b) a else b
    println("value d: $d")                  // value d: 12

    d = if (a < b) a else if (a > b) b else c
    println("value d: $d")                  // value d: 12
}

fun whenSyntax() {
    val name = "Son"
    val notify = 1

    // when statement
    when (name) {
        "SoN" -> println("My name is SoN")
        "Son" -> println("My name is Son")
        else -> println("No name")
    }       // My name is Son

    // when expression
    val message = when (notify) {
        1 -> "Success"
        2 -> "Fail"
        else -> "empty"
    }
    println("Notify: $message")             // Notify: Success
}

fun forLoop() {
    // Range-based loop (inclusive)
    for (i in 1..10) {
        print(i)                            // 12345678910
    }

    // Range-based loop (exclusive)
    for (i in 1 until 10) {
        print(i)                            // 123456789
    }

    // Range with step & direction
    for (i in 6 downTo 0 step 2) {
        print(i)                            // 6420
    }

    // For-each element in collection
    for (i in listItem) {
        print(i)                            // 1235478
    }

    // Index-based for loop
    for (i in array1.indices) {
        print(array1[i])                    // DayMonthYear
    }

    // Indexed for loop
    for ((index, value) in array1.withIndex()) {
        print("Index: $index, Value: $value")       // Index: 0, Value: DayIndex: 1, Value: MonthIndex: 2, Value: Year
    }

    // Char range loop
    for (chars in 'a'..'s') {
        print("$chars ")                            // a b c d e f g h i j k l m n o p q r s
    }
}

fun whileSyntax() {
    // while
    while (a < b) {
        print("a < b")
        break
    }                                               // a < b

    // do ... while
    do {
        print("$a ")                                // 12 13 14
        a++
    } while (a < b)
}


fun main() {
    ifSyntax()
    whenSyntax()
    forLoop()
    whileSyntax()
}