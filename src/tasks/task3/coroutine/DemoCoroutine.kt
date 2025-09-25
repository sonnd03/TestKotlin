package com.example.test.tasks.task1.tasks.task3.coroutine

import kotlinx.coroutines.*

//fun main() = runBlocking {
//    lambdaOne()
//
//    launch {
//        delay(2000)
//        println("Only launch")
//    }
//
//    launch(Dispatchers.Default){
//        println("before Default")
//        delay(2000)
//        println("Default")
//    }
//
//    launch {
//        lambdaOne() // 5000
//
//    }
//    launch {
//        loadData()  // 1000
//    }
//
//    println("Done")
//}

/* Các bước chạy
* chạy từ trên xuống
* gặp lambdaOne() -> chạy trước
* khi xong
* gặp 3 hàm launch => cho vào hàng chờ (cho lần lượt nhưng thực thi cùng 1 lúc )
* gặp print => in ra Done và chạy đồng thời chạy các hàm đợi
*=> 1 s sau chạy ra loadData
* => 1 sa sau chạy ra print only Launch
*  => 3 s sau chạy ra lambdaOne
*  */

suspend fun lambdaOne() {
    delay(5000)
    println("lambadaOne")
}

suspend fun loadData() {
    delay(1000)
    println("fun Load")
}


/* ================================================================== */
suspend fun block1(){
    for (i in 1..500){
        println("tetsts1")
        delay(1000)
        println("block 1: $i")
    }
}

suspend fun block2(){
    for (i in 1..100){
        println("tetsts2")
        delay(2000)
        println("block 2: $i")
    }

}
//fun main() = runBlocking {
//    launch { block2() }
//    launch { block1() }
//    println("Done")
//}


/* ================================================================== */
fun main() = runBlocking { // scope 1
    launch {       // coroutine 1
        delay(4000)
        println("Task from runBlocking")   // line code 1
    }
    coroutineScope { // coroutine 2   // scope 2
        launch {   // coroutine 3
            delay(10000)
            println("Task from nested launch") // line code 2
        }

        delay(6000)
        println("Task from coroutine scope") // line code 3
    }

    launch {
        delay(2000)
        println("hêleo")
    }

    println("Coroutine scope is over") // line code 4
}


