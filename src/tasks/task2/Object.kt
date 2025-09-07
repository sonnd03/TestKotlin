package com.example.test.tasks.task1.tasks.task2

// Singleton
object Status {
    fun print() = print("\nThis is singleton Object")
    var status = "online"

    fun getName(name: String) {
        println("name: $name")
    }
}

// implement class
object ObjectOverrideFunClass : Base("Son", "12") {
    override fun getInfor() {
        println("$name is: $age")
    }
}

// deference between function default, function companion
class CompanionObjectOnClass() {

    fun printGlobal() = print("hehehe")

    //// companion Object
    companion object {
        fun printCompanionObject() = print("\nHello this is Companion Object")
    }
}

fun main() {
    println(Status.status)
    Status.print()
    Status.getName("Nguyen Dac Son")

    ObjectOverrideFunClass.getInfor()

    val companionObjectOnClass = CompanionObjectOnClass()
    companionObjectOnClass.printGlobal()

    CompanionObjectOnClass.printCompanionObject()
}