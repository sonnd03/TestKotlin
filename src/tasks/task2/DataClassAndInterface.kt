package com.example.test.tasks.task1.tasks.task2

// Data Class
data class UserUse(
    var name: String? = null,
    var age: Int = 18,
    var sex: String = "Male"
)

// Interface exist property
interface Interface {
    val speed: Int // muốn dùng thì bên class cần overive k có tính sate
    fun fly()
}

class Bird(override val speed: Int) : Interface {
    override fun fly() = print("bay cao nao nhay cao nao: $speed")
}

// sealed interface
sealed interface State1 {
    fun checkLoading() = print("Loading State 1")
    fun check(id: String) {
        print("hẹ hẹ hẹ $id")
    }
}

sealed interface State2 {
    fun checkLoading() = print("Loading State 2")
}

sealed class StateClass(val state: String) {
    open fun checkLoading() = print("Loading Class $state")
}

// data class implement
data class OnlyClassAndManyInterface(val message: String, val st: String) : StateClass(st), State1, State2 {
    override fun checkLoading() {
        super<StateClass>.checkLoading()
        println("$message $st")
    }
}

// class implement
class ImplementManyInterface(val status: String) : StateClass(status), State1 {
    override fun check(id: String) {
        print("not hẹ hẹ hẹ $status")
    }

    override fun checkLoading() {
        print("Override MANY")   // always override Function class first
    }
}


fun main() {
    val bird = Bird(18022003)
    bird.fly()

    val onlyClassAndManyInterface = OnlyClassAndManyInterface("HEHEHEHE", "123")
    onlyClassAndManyInterface.checkLoading()

    val implementManyInterface = ImplementManyInterface("12000")
    implementManyInterface.checkLoading()
    implementManyInterface.check(bird.speed.toString())

    // copy only Data class
    val dataUseUser = UserUse("SONN")
    val dataUserUse2 = dataUseUser.copy(name = "SONNNN2")
    println(dataUseUser)
    println(dataUserUse2)
}

