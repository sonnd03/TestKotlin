package com.example.test.tasks.task1.tasks.task3.higherAndLambda

class LambdaExpressions {
    fun compare(a: String, b: String): Boolean = a.length < b.length
}

fun lambdaTypes() {
    // Default
    val default = { a: Int, b: Int -> a + b }
    println(default(12, 2))

    // Used it
    val useNotIt = { a: Int -> a * a }
    val useIt: (Int) -> Int = { it * it }
    println(useIt(18))

    // no param
    val noParam = { println("Hello my friend") }
    println(noParam)

    // return Unit
    val returnUnit: (String) -> Unit = { item -> println("Hello return Unit: $item") }
    returnUnit("item on returnUnit")

    // lambda is param function
    // lambda with scop function
    val name: String? = "NGuyen Dac Son"
    name?.let {
        println(
            "name is long: ${name.length}"
        )
    }
}

// lamda return create function
fun multiplier(number: Int): (Int) -> Int{
    return {item -> item * number}
}

// anonymous lambda
val anonymousLambda = fun(a: Int, b: Int): Int {
    return a + b
}


fun main() {
    val lambda = LambdaExpressions()
    val items = listOf(1, 2, 3, 4, 5, 6)
    val items1 = listOf(1 to "many", 2 to "happy", 3 to "friendy", 4 to "funny", 5 to "country", 6 to "hihi")
    println(lambda.compare("Son", "SonND"))
    val product = items.fold(1) { acc, e ->
        println(acc)
        acc * e
    }
    println(product)

    val listItems = items.filter {
        val check = it > 4
        check
    }
    println(listItems)

    // unused variable
    println(items1.filter { (key, _) -> key > 3 })

    // function anonymous
    println(items.filter(fun(item) = item > 2))

    var sum = 0
    items.filter { it > 0 }
        .forEach {
            println(sum)
            sum += it }
        .also { println(sum) }
    println(sum)

    //Function literals with receiver
    val functionLiteral = fun Int.(number: Int): Int = this.plus(number)
    println(12.functionLiteral(12))

    println(multiplier(12))

    println(anonymousLambda(18,2))
}