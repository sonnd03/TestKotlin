package com.example.test.tasks.task1.tasks.task3.dsls

data class Person(
    var name: String? = null,
    var age: Int? = null,
    var address: Address? = null,
)

data class Address(
    var street: String? = null,
    var number: Int? = null,
    var city: String? = null,
)

fun person(block: (Person) -> Unit): Person {
    val p = Person()
    block(p)
    return p
}

fun main() {
    val person = person {
        it.name = "John"
        it.age = 25
    }

//    val person = person {
//        name = "John"
//        age = 25
//        address {
//            street = "Main Street"
//            number = 42
//            city = "London"
//        }
//    }
}
