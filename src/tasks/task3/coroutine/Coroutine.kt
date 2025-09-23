package com.example.test.tasks.task1.tasks.task3.coroutine

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlin.system.measureTimeMillis

import kotlinx.coroutines.*
import kotlinx.coroutines.yield
import kotlinx.coroutines.isActive
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.time.withTimeoutOrNull
import java.lang.Exception
import javax.swing.JButton


// Coroutine and Thread
@OptIn(DelicateCoroutinesApi::class)
fun deferenceThreadAndCoroutine(){
    println("Main start: ${Thread.currentThread().name}")
    GlobalScope.launch {
        println("Fake start: ${Thread.currentThread().name}")
        delay(1000)
        println("Fake finish: ${Thread.currentThread().name}")
    }
    Thread.sleep(2000)
    println("Main program end: ${Thread.currentThread().name}")
}


 // Use launch or sync
//fun main() = runBlocking {
//    println("Main start: ${Thread.currentThread().name}")
//    val deferred: Deferred<Int> = async {
//        println("Fake start: ${Thread.currentThread().name}")
//        delay(1000)
//        println("Fake finish: ${Thread.currentThread().name}")
//
//        15
//    }
////    val job: Job= launch {
////        println("Fake start: ${Thread.currentThread().name}")
////        delay(1000)
////        println("Fake finish: ${Thread.currentThread().name}")
////    }
//    delay(4000)
//    val num: Int = deferred.await()
//    println(num)
//    deferred.join()
////    job.join()
//    println("Main program end: ${Thread.currentThread().name}")
//}

fun useLaunchAndAsync() = runBlocking {
    println("Main start: ${Thread.currentThread().name}")

    val deferred: Deferred<Int> = async {
        println("Fake start: ${Thread.currentThread().name}")
        delay(1000)
        println("Fake finish: ${Thread.currentThread().name}")
        15
    }

    val job: Job= launch {
        println("Fake start: ${Thread.currentThread().name}")
        delay(1000)
        println("Fake finish: ${Thread.currentThread().name}")
    }

//    delay(4000)
    val num: Int = deferred.await()
    println(num)
    deferred.join()
//    job.join()
    println("Main program end: ${Thread.currentThread().name}")
}


suspend fun mySuspendingFunc() {
    delay(1000)
}

fun main() {
//    deferenceThreadAndCoroutine()
    useLaunchAndAsync()
}




// Use runBlocking
//fun main() = runBlocking {
//    println("Main start: ${Thread.currentThread().name}")
//    val job: Job = launch {
//        println("Fake start: ${Thread.currentThread().name}")
//        delay(1000)
//        println("Fake finish: ${Thread.currentThread().name}")
//    }
////    delay(2000)
//    job.join()
//    println("Main program end: ${Thread.currentThread().name}")
//}
//


// equals launch, async and runBlocking
//fun main()  {
//    println("Main start: ${Thread.currentThread().name}")
//
//    runBlocking {
//        println("Fake start: ${Thread.currentThread().name}")
//        delay(2000)
//        println("Fake finish: ${Thread.currentThread().name}")
//    }
////    GlobalScope.launch {
////        println("Fake start: ${Thread.currentThread().name}")
////        delay(2000)
////        println("Fake finish: ${Thread.currentThread().name}")
////    }
////    delay(2000)
////    val num: Int = deferred.await()
////    println(num)
////    deferred.join()
//    Thread.sleep(500)
//    println("Main program end: ${Thread.currentThread().name}")
//}

// coroutine is Cooperative
//fun main() = runBlocking {
//    println("Main start: ${Thread.currentThread().name}")
//
//    val job: Job = launch(Dispatchers.Default) {
//        for (i in 1..10_0000) {
//            if (!isActive) {
//                return@launch
//            }
//            println("$i. ")
//            Thread.sleep(1)
//            println("Main check: ${Thread.currentThread().name}")
//
////            println("$i. ")
////            Thread.sleep(200) // không dừng vig k phải cooperative
////            delay(200) // hủy được vì là copperative
////            yield() // hủy được vì là copperative không delay mà vẫn là coparative
//        }
//    }
//
////    delay(2000)
//    delay(10)
//    job.cancel()
////    job.join()
//    job.cancelAndJoin()
//    println("Main program end: ${Thread.currentThread().name}")
//}

// Handling Exception
//fun main() = runBlocking {
//    println("Main start: ${Thread.currentThread().name}")
//
////    val job: Job = launch(Dispatchers.Default) {
////        try {
////            for (i in 1..500) {
////                println("$i ")
////                delay(200) // hủy được vì là copperative
////            }
////        } catch (ex: CancellationException) {
////            println("Exception is safety: $ex")
////        } finally {
////            withContext(NonCancellable) {
////                delay(1000)
////                println("Main delay: ${Thread.currentThread().name}")
////                println("Done delay")
////            }
////        }
////    }
//    val job: Job = launch(Dispatchers.Default) {
//        for (i in 1..500) {
//            println("$i ")
//            withContext(NonCancellable) {
//                delay(50)
//                println("check")
//            }
////            delay(200) // hủy được vì là copperative
//        }
//
//    }
//    delay(5000)
//    job.cancel()
//    job.join()
//    println("Main program end: ${Thread.currentThread().name}")
//}

// Time out
//fun main() = runBlocking {
//    println("Main start: ${Thread.currentThread().name}")
//
//    val result: String? = withTimeoutOrNull(2000) {
//        for (i in 0..2) {
//            println("$i ")
//            delay(500)
//        }
//        "Hello"
//    }
//
////    val result: String = withTimeout(2000){
////        for (i in 0..5) {
////            println("$i ")
////            delay(500)
////        }
////        "Hello"
////    }
//    println(result)
//    println("Main program end: ${Thread.currentThread().name}")
//}



////// Composing Suspending Function
//fun main() = runBlocking {
//    println("Main program Start: ${Thread.currentThread().name}")
//    val time = measureTimeMillis {
//        val mes1 = async(start = CoroutineStart.LAZY){ getMessageOne() }
//        val mes2 = async { getMessageTwo() }
//        println("Sum mess: ${mes1.await() + mes2.await()}")
//    }
//    println("Sum times: $time")
//    println("Main program end: ${Thread.currentThread().name}")
//}
//
//
//suspend fun getMessageOne(): String{
//    delay(1000)
//    println("Message one")
//    return "Hello One"
//}
//
//suspend fun getMessageTwo(): String{
//    delay(1000)
//    println("Message two")
//    return " Hello Two"
//}


//// Coroutine Scop
//fun main() = runBlocking {
//    println(this)
//
//    launch {
//        println("launch: $this")
//    }
//
//    async {
//        println("async: $this")
//    }
//
//    println("end")
//}


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

//suspend fun lambdaOne() {
//    delay(5000)
//    println("lambadaOne")
//}
//
//suspend fun loadData() {
//    delay(1000)
//    println("fun Load")
//}



