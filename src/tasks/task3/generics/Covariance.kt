package com.example.test.tasks.task1.tasks.task3.generics

interface Home<out T> {
    fun home(): T
}

class People(val name: String)

class PeopleHome : Home<People> {
    override fun home(): People = People("Son")
}

fun main() {
    val peopleHome: Home<People> = PeopleHome()

    val anyHome: Home<Any> = peopleHome

    val any: Any = anyHome.home()
    println(any)

}