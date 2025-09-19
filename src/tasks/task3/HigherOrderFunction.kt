package com.example.test.tasks.task1.tasks.task3


private class HeightOrderFunction() {

    operator fun invoke(name: String, age: Int) {
        println(name + age)
    }

    fun function1(number1: Int, number2: Int): Int = number1 + number2

    //function on functon and set one type default
    fun high2(
        number1: Int, connect1: (Int, Int) -> Int
    ): Int {
        return connect1(number1, 123)
    }

    // function on function
    fun high(a: Int, b: Int, sum: (Int, Int) -> Int): Int {
        return sum(a, b)
    }

    // function type fun local
    fun high1(
        number1: Int, connect: (Int, Int) -> Int = ::function1
    ): Int {
        return connect(number1, 12)
    }

    // lambda anonymous
    fun high2(a: Int, b: Int): (Int, Int) -> Int {
        return { x, y ->
            if (a > b) {
                println("$a, $b")
                a + x
            } else {
                b + y
            }
        }
    }

    // inline function
    inline fun inlineFunction(
        x: Int, y: Int,
        sum: (Int, Int) -> Int,
        noinline sum1: (Int, Int) -> Int
    ): Int {
        return sum(x, y) + sum1(x,y)
    }

    inline fun forList(list: List<Int>, get: (Int) -> Unit ){
        for (i in list){
            get(i)
        }
    }

    fun doSomething() {
        println("doSomething start")
        doSomethingElse()
        getMessage{
            println("hehehe")
//            return // error
        }
        println("doSomething end")
    }

    fun doSomethingElse() {
        println("doSomethingElse")
    }

    inline fun getMessage(crossinline ms: () -> Unit){
        ms()
    }


    /// when
    fun checkOrder(type: String): (Int, Int) -> Int {
        return when (type) {
            "plus" -> { a, b -> a + b }
            "minus" -> { a, b -> a - b }
            else -> { _, _ -> 0 }
        }
    }
}

private class TestInvoking {
    operator fun invoke(name: String, age: Int) {
        println("name: $name, age: $age")
    }
}

fun main() {
    val high = HeightOrderFunction()
    println(high.high1(12) { x, y -> x + y })
    println(high.high2(2, 18)(12, 2003))
    println(
        "value heightOderFunctionUseWhen: ${high.checkOrder("plus")(18, 2)}"
    )

    // invoking function
    val stringPlus: String.(String) -> String = String::plus
    val intPlus: (Int, Int) -> Int = Int::plus

    println(stringPlus("Nguyen", "Son"))
    println("Son".stringPlus("nguyendac"))
    println(intPlus(12, 12))
    high("Nguyendacson", 12)

    // class invoke
    val invoke = TestInvoking()
    invoke("Son", 12)

    println(high.inlineFunction(12,2,{x, y -> x + y}, {x,y -> x- y}))

//    val list = listOf(1,2,3,4,5,6,7,8)
//    high.forList(list){
//        if (it == 3) return /// out ra khoi lop cha
//        println(it)
//    }
//    println("no out")

    high.doSomething()

}
