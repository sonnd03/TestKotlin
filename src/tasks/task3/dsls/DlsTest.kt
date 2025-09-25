package com.example.test.tasks.task1.tasks.task3.dsls

// demo simple
val hello: (String) -> String = { name -> "Hello, $name" }
val hello2: String.() -> String = { "Hello, $this" }

fun String.hello(): String = "Hello, $this"

// demo Class
data class Address(
    var street: String? = null,
    var number: Int? = null,
    var city: String? = null,
)

data class Person(
    var name: String? = null,
    var age: Int? = null,
    var address: Address? = null,
)

fun person(block: (Person) -> Unit): Person {
    val p = Person()
    block(p)
    return p
}

fun person1(block: Person.() -> Unit): Person = Person().apply(block)

fun Person.address(block: Address.() -> Unit) {
    address = Address().apply(block)
}

// enum interface
enum class BoardColor {
    BLACK, WHITE, GREEN
}

class Task() {
    var titleTask: String = " "
    var description: String = ""
}

class Board() {
    var title: String = " "
    var color: BoardColor = BoardColor.WHITE
}

class BoardTask() {
    var title: String = " "
    var color: BoardColor = BoardColor.WHITE
    var tasks: MutableList<Task> = mutableListOf()

    fun addTask(init: Task.() -> Unit) {
        val task = Task()
        task.init()
        tasks.add(task)
    }
}

fun board(init: Board.() -> Unit): Board {
    val board = Board()
    board.init()
    return board
}

fun board1(init: BoardTask.() -> Unit): BoardTask {
    val board = BoardTask()
    board.init()
    return board
}


fun main() {
    val greeting = hello("Son")
    val greeting2 = hello2("Son2")

    val greeting1 = "Son1".hello()
    println(greeting)
    println(greeting1)
    println(greeting2)


// demo 2
// ===================================================================== //
    val person = person {
        it.name = "John"
        it.age = 25
    }

    val person1 = person1 {
        name = "John"
        age = 25
    }

    val person2 = person1 {
        name = "John"
        age = 25
        address {
            street = "canhhung"
            number = 1231312
            city = "hanoi"
        }
    }

    println("P: $person")
    println("P1: $person1")
    println("P2: $person2")


// demo 3
// ===================================================================== //
    // before
    val board = Board()
    board.title = "Nguyen Dac Son"
    board.color = BoardColor.GREEN
    println("B: ${board.title + " " + board.color}")

    // after
    val board1 = board {
        title = "Nguyen Dac Son 1"
        color = BoardColor.BLACK
    }
    println("B1: ${board1.title + " " + board1.color}")

// =============================== //

    // before
    val taskOne = Task()
    taskOne.titleTask = "task one"
    taskOne.description = "des task One"

    val taskTwo = Task()
    taskOne.titleTask = "task two"
    taskOne.description = "des task two"

    val tasks = mutableListOf(taskOne, taskTwo)
    val boardTask = BoardTask()
    boardTask.title = "Nguyen Dac Son 2"
    boardTask.color = BoardColor.BLACK
    boardTask.tasks = tasks

    println("B2: $boardTask")

    // after
    val boardTask1 = board1 {
        title = "Nguyen Dac Son 3"
        color = BoardColor.GREEN
        addTask {
            titleTask = "task one one "
            description = "des task two two"
        }
    }
    println("B3: $boardTask1")
}

