package com.example.test.tasks.task1.tasks.task2

private fun nullableOrNonNullable() {
    // no nullable
    var message = "Notify"
//    message = null // error
    println(message)        // Notify

    // nullable
    var message1: String? = "Notify"
    message1 = null
    println(message1)       // null
}

private fun elvisOperator() {
    val message: String? = null
    val messageAfter: String = message ?: "Son"

    println(messageAfter)   // Son
}

private fun safeCall() {
    val person: Person? = Person()
    var message: String? = "Message"
    message = person?.name

    println(message)        // null
}

private fun notNullAssertion() {
    val person: Person = Person()
    var message: String = "Message"
    message = person.name!!

    println(message)        // Exception in thread "main" java.lang.NullPointerException because VALUE message never null
}

fun main() {
    nullableOrNonNullable()
    elvisOperator()
    safeCall()
    notNullAssertion()
}