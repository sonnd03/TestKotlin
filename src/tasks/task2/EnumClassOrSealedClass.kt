package com.example.test.tasks.task1.tasks.task2

enum class Warring {
    ERROR, LOADING, SUCCESS
}

fun handleEnum(status: Warring) {
    when (status) {
        Warring.ERROR -> print("Error")
        Warring.LOADING -> print("Loading")
        Warring.SUCCESS -> print("Success")
    }
}

sealed class Warring1() {
    data class Success(val data: String) : Warring1()
    data class Error(val code: String, val message: String) : Warring1()
    object Loading : Warring1()
}

fun handleEnum1(result: Warring1) {
    when (result) {
        is Warring1.Success -> print("Success : ${result.data}")
        is Warring1.Error -> print("Error: ${result.message}, code: ${result.code}")
        Warring1.Loading -> print("Loading")
    }
}

fun main() {
    handleEnum1(Warring1.Error("400", "Bad Request"))
    print("\n")
    handleEnum(Warring.ERROR)
}
