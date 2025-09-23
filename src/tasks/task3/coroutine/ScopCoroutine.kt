package com.example.test.tasks.task1.tasks.task3.coroutine

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

//// Context and Dispatcher
//fun main() = runBlocking {
//    launch {
//        println("C1: ${Thread.currentThread().name}")
//        delay(3000)
//        println("C1 after: ${Thread.currentThread().name}")
//    }
//
//    launch(Dispatchers.Default) {
//        println("C2: ${Thread.currentThread().name}")
//        delay(3000)
//        println("C2 after: ${Thread.currentThread().name}")
//    }
//
//    launch(Dispatchers.Unconfined) {
//        println("C3: ${Thread.currentThread().name}")
//        delay(3000)
//        println("C3 after: ${Thread.currentThread().name}")
//    }
//
//    launch(Dispatchers.IO) {
//        println("C4: ${Thread.currentThread().name}")
//        delay(3000)
//        println("C4 after: ${Thread.currentThread().name}")
//    }
//    println("Launch cha: $this")
//}

// mỗi coroutine có 1 ScopCoroutine riêng


/// test công suât
fun main() = runBlocking {

    val testIo: Deferred<Int> = async(Dispatchers.Default + CoroutineName("Default")) {
        var sum: Int = 0
        for (i in 1..1000000) {
            sum = i * 3 * 92294 / 12
        }
        println("Other : ${Thread.currentThread().name}")
        println("Name other : ${coroutineContext[CoroutineName]}")
        sum
    }

    val testLunch: Deferred<Int> = async(CoroutineName("Non")) {
        var sum: Int = 0
        for (i in 1..1000000) {
            sum = i * 3 * 92294 / 12
        }
        println(Thread.currentThread().name)
        sum
    }

    val timeIo = measureTimeMillis {
        println("testIo ${testIo.await()}")
    }

    val timeLaunch = measureTimeMillis {
        println("testLaunch ${testLunch.await()}")
    }

    println("timeIo: $timeIo")
    println("timeLaunch: $timeLaunch")

    println("Launch cha: $this")
}
