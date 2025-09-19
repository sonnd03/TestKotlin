package com.example.test.tasks.task1.tasks.task2

class ScopFunction {
    data class Person(
        var name: String,
        var age: Int,
        var salary: Int,
    )

    var person = mutableListOf<Person>(
        Person("Son", 10, 10),
        Person("Hoang", 11, 11),
        Person("Quynh", 12, 12)
    )

//    var mutableList: List<Int> = mutableListOf(1, 2, 3, 4, 5, 6)
//
//    val let = mutableList.let {
//        it.size
//        println(it.size)
//        it.filter { it > 5 }
//            .sum()
//    }
//
//    val apply = mutableList.apply {
//        val item = filter { it > 5 }
//        println(item)
//    }

    // let
    fun letGetAge11(): Int {
        return person.let {
            println(it.size)
            it.forEach { item -> item.age += 1 }
            it.filter { item -> item.age > 11 }.size
        }
    }

    // run
    fun runGetAge11(): Int {
        return person.run {
            println(size)
            forEach { it.age += 1 }
            filter { item -> item.age > 11 }.size
        }
    }

    // apply
    fun applyPersonAge11(): List<Person> {
        var personAge: List<Person> = emptyList()
        person.apply {
            personAge = filter { it.age > 11 }
        }
        return personAge
    }

    fun applyAddData() {
        person.apply {
            add(Person("User", 14, 14))
            add(Person("User", 15, 15))
        }
    }

    fun applyPlusAge() = person.apply {
        forEach { it.age += 1 }
    }

    // also
    fun alsoAddData() {
        person.also {
            it.add(Person("User", 14, 14))
            it.add(Person("User", 15, 15))
        }
    }

    fun alsoPlusAge() = person.also {
        it.forEach { item -> item.age += 1 }
        print(it)
    }

    // with
    fun withAge11() {
        val sumAge = person.filter { it ->
            with(it) {
                print(age)
                age += 1
                print(age)
                age > 12
            }
        }
    }

}

fun main() {
    val scopFunction = ScopFunction()

    scopFunction.letGetAge11()

    scopFunction.runGetAge11()

    scopFunction.applyPersonAge11()
    scopFunction.applyAddData()
    scopFunction.applyPlusAge()

    scopFunction.alsoAddData()
    scopFunction.alsoPlusAge()

    scopFunction.withAge11()
}