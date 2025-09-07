package com.example.test.tasks.task1.tasks.task2
/*
Scop parameter:
- default no notify => public +> global
- private only use class
- protected use class and class inheritance
- iternal use on file
*/

// Class
class Person {
    var name = ""
    var age = 18
}

class Person1 {
    var name = ""
    var age = 18
}

// class constructor
class User(var name: String, age: String = "12") {
    /// constructor primary
    init {
        println("primary constructor called")
        println("$name : $age")
    }

    /// constructor secondary
    constructor(address: Int, age: String) : this("Nguyendacson", age) {
        print("secondary constructor called $name, $age, $address")
    }
}

// Open class + OOP , override , open class, open fun, abstract fun, super
open class Base(
    /// Encapsulation (Đóng gói)
    protected var name: String,
    var age: String
) {
    open fun getInfor() = print("name: $name, age: $age ")
    open fun getSex(value: String) = println("Sex is $value")
}

/// Inheritance (kế thừa)
class Inheritance(
    name: String, age: String,
    var address: String
) : Base(name, age) {
    /// Polymorphism (đa hình)
    override fun getInfor() {
        super.getInfor()
        println(address)
    }

}

class Inheritance1(
    name: String, age: String,
    var status: String,
    var sex: String
) : Base(name, age) {
    /// Polymorphism (đa hình)
    override fun getInfor() {
        println(status)
    }

    /// must get many function on superclass
    fun getFunSuperClass() {
        val superClass = Base(name, age)
        superClass.getInfor()
        println("\nget two function")
        superClass.getSex(sex)
    }
}

// Abstract (Trừu tượng)
abstract class Abstract(
    name: String,
    age: String,
) : Base(name, age) {
    abstract fun getPrintData(): String
}

class StatusAbstract(
    name: String, age: String, var status: Int
) : Abstract(name, age) {
    override fun getPrintData(): String {
        return println(status).toString()
    }
}

fun classType() {
    // Class
    val person = Person()
    person.name = "Nguyen Dac Son"
    person.age = 22

    val person1 = Person1()
    person1.name = "Nguyen Dac Son"
    person1.age = 22

    // the equality operator
    println(person == person1) // flase // want to true change class is data class

    // class constructor
    User("Son", "22")/*
        primary constructor called
        Son : 22
    */

    User(address = 12, age = "22")
    /*
    primary constructor called
    Nguyendacson : 22
    secondary constructor called Nguyendacson 22 12
    */
}

fun classOOPAndAbstract() {
    val dataBase = mutableListOf<Base>()
    val dataInheritance1 = mutableListOf<Inheritance1>()

    val listInheritance = listOf(
        Inheritance("Son", "10", "Phat Tich"),
        Inheritance("Son1", "12", "Phat Tich 1"),
        Inheritance("Son2", "13", "Phat Tich 2"),
        Inheritance("Son3", "13", "Phat Tich 3"),
        Inheritance("Son4", "14", "Phat Tich 4")
    )

    val listInheritance1 = listOf(
        Inheritance1("Son", "10", "1", "Male"),
        Inheritance1("Son1", "12", "1", "Women"),
        Inheritance1("Son2", "13", "2", "Women"),
        Inheritance1("Son3", "13", "3", "Male"),
        Inheritance1("Son4", "14", "4", "Women")
    )

    val listAbstract = listOf(
        StatusAbstract("Son5", "15", 1),
        StatusAbstract("Son6", "16", 0),
        StatusAbstract("Son7", "17", 0),
        StatusAbstract("Son8", "18", 0),
        StatusAbstract("Son9", "19", 1),
        StatusAbstract("Son10", "20", 1)
    )

    dataBase.addAll(listInheritance)
    dataBase.addAll(listInheritance1)
    dataInheritance1.addAll(listInheritance1)
    dataBase.addAll(listAbstract)

    dataBase.forEach { it.getInfor() }
    dataInheritance1.forEach { it.getFunSuperClass() }

    val testDataAbstract = StatusAbstract("Son","12",2000)
    testDataAbstract.getPrintData()
}

fun main() {
    classType()
    println("\n")
    classOOPAndAbstract()
}