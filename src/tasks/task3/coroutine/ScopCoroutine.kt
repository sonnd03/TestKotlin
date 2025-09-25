package com.example.test.tasks.task1.tasks.task3.coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

// Coroutine Job
@OptIn(DelicateCoroutinesApi::class)
fun coroutineJob() = runBlocking {
    println(this)       // BlockingCoroutine{Active}@e2d56bf

    GlobalScope.launch {
        println("GlobalScope launch: $this")        // GlobalScope launch: StandaloneCoroutine{Active}@2410b401
    }

    launch {
        println("launch: $this")                    // launch: StandaloneCoroutine{Active}@6a38e57f
    }

    async {
        println("async: $this")                     // async: DeferredCoroutine{Active}@1c6b6478
    }

    coroutineScope {
        launch {
            println("launch on Scope: $this")       // launch: StandaloneCoroutine{Active}@6a38e57f
        }

        async {
            println("async on Scope: $this")         // async: DeferredCoroutine{Active}@38cccef
        }

        println("coroutineScope: $this")             // coroutineScope: ScopeCoroutine{Active}@6d86b085
    }

    // => mỗi coroutine có 1 Coroutine Job khác nhau dù nằm trong cùng 1 coroutine cha hay không
}

// Context Dispatcher
@OptIn(DelicateCoroutinesApi::class)
fun contextDispatcher() = runBlocking {
    GlobalScope.launch {
        println("C0: ${Thread.currentThread().name}")
        delay(3000)
        println("C0 after: ${Thread.currentThread().name}")
    }

    launch {
        println("C1: ${Thread.currentThread().name}")
        delay(3000)
        println("C1 after: ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Default) {
        println("C2: ${Thread.currentThread().name}")
        delay(3000)
        println("C2 after: ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Unconfined) {
        println("C3: ${Thread.currentThread().name}")
        delay(3000)
        println("C3 after: ${Thread.currentThread().name}")
    }

    launch(Dispatchers.IO) {
        println("C4: ${Thread.currentThread().name}")
        delay(3000)
        println("C4 after: ${Thread.currentThread().name}")
    }
    println("Launch cha: $this")
}


// Test speed
fun testSpeed() = runBlocking {
    val testDefault: Deferred<Int> = async(Dispatchers.Default + CoroutineName("Default")) {
        var sum: Int = 0
        for (i in 1..1000000) {
            sum = i * 3 * 92294 / 12
        }
        println("Other : ${Thread.currentThread().name}")
        println("Name other : ${coroutineContext[CoroutineName]}")
        sum
    }

    val testIO: Deferred<Int> = async(Dispatchers.IO + CoroutineName("IO")) {
        var sum: Int = 0
        for (i in 1..1000000) {
            sum = i * 3 * 92294 / 12
        }
        println("Other : ${Thread.currentThread().name}")
        println("Name other : ${coroutineContext[CoroutineName]}")
        sum
    }

    val testNon: Deferred<Int> = async(CoroutineName("Non")) {
        var sum: Int = 0
        for (i in 1..1000000) {
            sum = i * 3 * 92294 / 12
        }
        println("Other : ${Thread.currentThread().name}")
        println("Name other : ${coroutineContext[CoroutineName]}")
        sum
    }

    val testUnconfined: Deferred<Int> = async(Dispatchers.Unconfined + CoroutineName("Unconfined")) {
        var sum: Int = 0
        for (i in 1..1000000) {
            sum = i * 3 * 92294 / 12
        }
        println("Other : ${Thread.currentThread().name}")
        println("Name other : ${coroutineContext[CoroutineName]}")
        sum
    }

    val timeDefault = measureTimeMillis {
        println("testIo ${testDefault.await()}")
    }

    val timeNon = measureTimeMillis {
        println("testLaunch ${testNon.await()}")
    }

    val timeIo = measureTimeMillis {
        println("testIo ${testIO.await()}")
    }

    val timeUnconfined = measureTimeMillis {
        println("testLaunch ${testUnconfined.await()}")
    }

    println("timeNon: $timeNon")
    println("timetimeDefault: $timeDefault")
    println("timetimeUnconfined: $timeUnconfined")
    println("timeIo: $timeIo")
    println("Launch cha: $this")

    // => timeUnconfined < timeNon < timeDefault < timeIo
}

fun main() {
    coroutineJob()
    contextDispatcher()
    testSpeed()
}
