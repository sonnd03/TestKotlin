package com.example.test.tasks.task1.tasks.task3.generics

interface Home1<in T> {
    fun put(person: T)
}

class People1(val name: String)

class PeopleHome1 : Home1<People1> {
    override fun put(person: People1) {
        println("Put ${person.name} into PeopleHome")
    }
}

fun main() {
    val peopleOnly: Home1<People1> = object : Home1<Any> {
        override fun put(person: Any) {
            println("Put something: $person")
        }
    }
    peopleOnly.put(People1("Son"))   // OK

    val peopleHome: Home1<People1> = PeopleHome1()
//    val anyHome: Home1<Any> = peopleHome // error because not get
}
