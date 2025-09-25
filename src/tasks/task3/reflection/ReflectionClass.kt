package com.example.test.tasks.task1.tasks.task3.reflection

import junit.framework.TestCase.assertEquals
import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty0

class MyClass {
    var mutableProperty: String = "Default"
}

data class ExampleDataClass(
    val name: String, var enabled: Boolean,
)

class MyType

fun main() {
    println("Name class" + ExampleDataClass::class)

    // get all method by class
    ExampleDataClass::class.java.methods.forEach(::println)

    // 1. List
    val listClass: KClass<List<*>> = List::class
    println(listClass)

    // 2. String
    val name = "Baeldung"
    val stringClass: KClass<out String> = name::class
    println(stringClass)

    // 3. Chuyển giữa Java class và Kotlin KClass
    val someClass: Class<MyType> = MyType::class.java
    val kotlinClass: KClass<MyType> = someClass.kotlin
    println(kotlinClass)


    val typeStringClass = String::class
    println(typeStringClass.qualifiedName)
    println("isData = ${typeStringClass.isData}")
    println("isCompanion = ${typeStringClass.isCompanion}")
    println("isAbstract = ${typeStringClass.isAbstract}")
    println("isFinal = ${typeStringClass.isFinal}")
    println("isSealed = ${typeStringClass.isSealed}")

    val myObj = MyClass()

    val prop: KMutableProperty0<String> = myObj::mutableProperty

    // 2. set with prop
    prop.set("Hello")
    assertEquals("Hello", prop.get())

    // 3. getter, setter
    prop.setter("World")
    assertEquals("World", prop.getter())

    // print
    println("Giá trị cuối cùng của mutableProperty = ${myObj.mutableProperty}")
}

