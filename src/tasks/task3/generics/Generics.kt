package com.example.test.tasks.task1.tasks.task3.generics

/*
    T = type,
    E = element,
    R = return
*/

// Generics Class
data class Person(
    val name: String = "USERNAME",
    val action: String = "badminton",
)

data class Student(
    val detail: String = "Is Student",
    val action: String = "Learning",
)

data class Teacher(
    val age: Int = 18,
    val detail: String = "Is Teacher",
    val address: String = "Ha Noi",
    val action: String = "Reading",
)

class Generics<T> {
    fun insert(ps: T) {
        println("insert new Person $ps ok")
    }
}

// Generics Function
fun <T> getData(data: T): String {
    val message = "data is: $data"
    return message
}

fun main() {
    val genericsPerson = Generics<Person>()
    genericsPerson.insert(Person())

    val genericsTeacher = Generics<Teacher>()
    genericsTeacher.insert(Teacher())

    val genericsStudent = Generics<Student>()
    genericsStudent.insert(Student())

    val dataPerson = getData(Person())
    println(dataPerson)

    val dataTeacher = getData(Teacher())
    println(dataTeacher)

    val dataStudent = getData(Student())
    println(dataStudent)
}





























