package com.example.test.tasks.task1.tasks.task2

fun main() {
    var char: String = "Nguyen Dac Son"
//    char = null  // error

    var char1: String? = "Nguyen Dac Son"
//    char1 = null // no error //null

    print(char1?.length)
    print(char!!.length)
}