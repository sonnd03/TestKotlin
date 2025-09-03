package com.example.test.tasks.task1.tasks.task1

fun main() {
    // if
    var height = 12
    val taller = 15
    val home = 18
    var room: Int? = null
    val listItem = listOf(1, 2, 3, 5, 4, 7, 8)
    val array1 = arrayOf("Day", "An", "Lam")

//    ////
//    if (height < taller && height != 0){
//        println("taller > height")
//    }else{
//        println("fail")
//    }
//    ///
//    if (height < taller) room = height
//    ////
    room = if (height < taller) height else taller
    room = if (height < taller) height else if (height > taller) taller else home

//    // When
//    val name = "Son"
//    when (name) {
//        "SoN" -> println("My name is SoN")
//        "Son" -> println("My name is Son")
//        else -> println("No name")
//    }
//    var message: String? = null
//    val notify = 1
//    message = when (notify) {
//        1 -> "Success"
//        2 -> "Fail"
//        else -> "empty"
//    }
//
//    /// Expression
//    ////
//    fun getRandomLove(): Love {
//        return if (Random.nextBoolean()) Love.Love else Love.NotLove
//    }
//
//    val status = when (getRandomLove()) {
//        Love.Love -> 1
//        Love.NotLove -> 0
//    }
//    if (status == 0) println("Not Love: $status") else println("Love: $status")

    /// when{}
    ////
//    val message1 = when {
//        height < taller -> "More letter"
//        taller > height -> "More long"
//        else -> "Exception"
//    }
//    ////
//    val message2 = when (val input = "yes") {
//        "yes" -> "Yes"
//        "no" -> "No"
//        else -> "Exception"
//    }
//    ////
//    when (height) {
//        in 1..10 -> println("1 in 10")
//        in 11..20 -> println("11 in 20")
//        else -> "null"
//    }
//    ////
//    fun checkType(input: Any): Boolean = when (input) {
//        is String -> input.startsWith("Nguyen")
//        else -> false
//    }
//
//    val testType = "Nguyen Dac Son"
//    checkType(testType)
//    ////
//    fun checkLoveYou(type: Love) {
//        when (type) {
//            Love.Love -> println("Status is Loving")
//            Love.NotLove -> println("Status isn't Love")
//        }
//    }

// For Loops
//    for (i in 1..10) {
//        // 1...10
//    }
//    for (i in 1..<10) {
//        // 1..9
//    }
//    for (i in 6 downTo 0 step 2) {
//        // 6420
//    }
//    for (i in listItem) {
//        //12345678
//    }
//    for (i in array1.indices) {
//        println(array1[i])
//    }
//    for ((index, value) in array1.withIndex()) {
//        println("Index: $index, Value: $value")
//    }
//    for (chars in 'a'..'s'){
//       // a bcdefghijklmnopqrs
//    }

// ForEach
//    listItem.forEach { it -> println(it) } // 1235478
//    listItem.forEach { it -> if (it > 2) println(it) } //35478

//    listItem.forEach (fun(value: Int) {
//        if (value == 1 || value == 4) return // return as continue
//        print(value)
//    })


// While
//    while (height < taller){
//        println("height < taller")
//        break
//    }
//    do {
//        println(height)
//        height++
//    }while (height < taller)

}