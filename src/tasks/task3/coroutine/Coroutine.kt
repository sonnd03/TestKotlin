package com.example.test.tasks.task1.tasks.task3.coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

// Coroutine
@OptIn(DelicateCoroutinesApi::class)
fun coroutine() {
    println("Main start: ${Thread.currentThread().name}")
    GlobalScope.launch {
        println("Fake start: ${Thread.currentThread().name}")
        delay(1000)
        println("Fake finish: ${Thread.currentThread().name}")
    }
    Thread.sleep(2000)
    println("Main program end: ${Thread.currentThread().name}")
}


// Deference between Thread and Coroutine
@OptIn(DelicateCoroutinesApi::class)
fun deferenceThreadAndCoroutine() {
    println("Main start: ${Thread.currentThread().name}")
    runBlocking {
        val job: Job = launch {
            println("Fake start: ${Thread.currentThread().name}")
            delay(2000)
            println("Fake finish: ${Thread.currentThread().name}")
        }
        delay(4000)
        job.cancelAndJoin()
    }

    GlobalScope.launch {
        println("input method Launch")
    }
    // có thể thấy nội dung của launch k được chạy vì nó k có tính Block Thread
    // Thread.sleep(50) // cho Thread dừng thì sẽ thực thi block
    println("Main program end: ${Thread.currentThread().name}")
}


// Use launch or sync
fun useLaunchAndAsync() = runBlocking {
    println("Main start: ${Thread.currentThread().name}")

    val deferred: Deferred<Int> = async {
        println("Fake start Async: ${Thread.currentThread().name}")
        delay(1000)
        println("Fake finish Async: ${Thread.currentThread().name}")
        15
    }

    val job: Job = launch {
        println("Fake start Launch: ${Thread.currentThread().name}")
        delay(1000)
        println("Fake finish Launch: ${Thread.currentThread().name}")
    }

    delay(5000)
    val num: Int = deferred.await()
    println(num)

    deferred.join()
    job.join()

    println("Main program end: ${Thread.currentThread().name}")
}


// user runBlocking recommend
suspend fun mySuspendingFunc() {
    delay(1000)
}


// coroutine is Cooperative
class CoroutineCooperative {

    /// Non Cooperative => can not cancel
    fun coroutineNonCooperative() = runBlocking {
        println("Main start: ${Thread.currentThread().name}")
        val job: Job = launch {
            for (i in 1..10000000) {
                println("$i. ")
                println("Main check: ${Thread.currentThread().name}")
            }
        }
        delay(2000)
        job.cancelAndJoin()
    }

    /// Cooperative with isActive
    fun coroutineCooperativeIATV() = runBlocking {
        println("Main start: ${Thread.currentThread().name}")
        val job: Job = launch {
            for (i in 1..10000000) {
                if (!isActive) {
                    break
                }
                println("Cancelled at $i")
                println("Check thread: ${Thread.currentThread().name}")
            }
        }
        job.cancelAndJoin()
        println("Main program end: ${Thread.currentThread().name}")
    }

    /// Cooperative with delay, yield
    fun coroutineCooperativeLaunch() = runBlocking {
        println("Main start: ${Thread.currentThread().name}")
        val job: Job = launch {
            for (i in 1..10000000) {
                println("Cancelled at $i")
                delay(200)
                yield()
                println("Check thread: ${Thread.currentThread().name}")
            }
        }
        job.cancelAndJoin()
        println("Main program end: ${Thread.currentThread().name}")
    }
}


// use withContext
class WithContext() {
    fun withContextFinally() = runBlocking {
        println("Main start: ${Thread.currentThread().name}")
        val job: Job = launch {
            try {
                for (i in 1..2) {
                    println("$i ")
                    delay(200) // can cancel because this is cooperative
                }
            } catch (ex: CancellationException) {
                println("Exception is safety: $ex")
            } finally {
                withContext(NonCancellable) {
                    delay(1000)
                    println("Main delay: ${Thread.currentThread().name}")
                    println("Done delay")
                }
            }

        }
        delay(500)
        job.cancelAndJoin()
        println("Main program end: ${Thread.currentThread().name}")
    }

    fun withCotextDefault() = runBlocking {
        val job: Job = launch {
            for (i in 1..2) {
                println("$i ")
                withContext(NonCancellable) {
                    delay(2000) // can cancel because this is cooperative
                    println("Main delay: ${Thread.currentThread().name}")
                    println("Done delay")
                }
            }
        }
        job.cancelAndJoin()
        println("Main program end: ${Thread.currentThread().name}")
    }
}


// Time out
class TimeOut() {
    fun useWithTimeOutOrNull() = runBlocking {
        println("Main start: ${Thread.currentThread().name}")

        val result: String? = withTimeoutOrNull(2000) {
            for (i in 0..8) {
                println("$i ")
                delay(500)
            }
            "Hello"
        }
        println(result)
        println("Main program end: ${Thread.currentThread().name}")

        /*
        * Nếu hoàn thành block result trong 2000 ms => k trả ra null
        * Nếu không hoàn thành thì thực thi hết 2000 ms => trả result về null
        */
    }

    fun useWithTimeOut() = runBlocking {
        try {
            val result: String = withTimeout(2000) {
                for (i in 0..5) {
                    println("$i ")
                    delay(500)
                }
                "Hello"
            }
            println(result)
            println("Main program end: ${Thread.currentThread().name}")
        } catch (ex: TimeoutCancellationException) {
            println("error: $ex")
        }

        /*
        * Nếu hoàn thành block result trong 2000 ms => k trả ra exception
        * Nếu không hoàn thành thì thực thi hết 2000 ms => bắn ra exception  ex: Timed out waiting for 2000 ms
        */
    }
}

// Composing Suspending Function
class ComposingSuspendingFunc() {
    companion object {
        fun composingSuspending() = runBlocking {
            println("Main program Start: ${Thread.currentThread().name}")
            val time = measureTimeMillis {
                val mes1 = async { getMessageOne() }
                val mes2 = async { getMessageTwo() }
                println("Sum mess: ${mes1.await() + mes2.await()}")
            }
            println("Sum times: $time")         // chạy song song nên thấy chỉ mất 1000 ms
            println("Main program end: ${Thread.currentThread().name}")
        }

        fun composingNonSuspending() = runBlocking {
            println("Main program Start: ${Thread.currentThread().name}")
            val time = measureTimeMillis {
                val mes1 = getMessageOne()
                val mes2 = getMessageTwo()
                println("Sum mess: ${mes1 + mes2}")
            }

            println("Sum times: $time")         // không chạy song song => thấy 2000 ms
            println("Main program end: ${Thread.currentThread().name}")
        }

        suspend fun getMessageOne(): String {
            delay(1000)
            println("Message one")
            return "Hello One"
        }

        suspend fun getMessageTwo(): String {
            delay(1000)
            println("Message two")
            return " Hello Two"
        }
    }
}

// Composing Suspending Function
class UseStartLazy() {
    fun lazyNonPrint() = runBlocking {
        println("Main program Start: ${Thread.currentThread().name}")
        val mes1 =
            async(start = CoroutineStart.LAZY) { getMessageOne() }  // no start lazyPrintAndStart to when use mes1
        println("Main program end: ${Thread.currentThread().name}")
    }

    fun lazyNonPrintAndStart() = runBlocking {
        println("Main program Start: ${Thread.currentThread().name}")
        val mes1 = async { getMessageOne() }                                // allways start lazyPrintAndStart
        println("Main program end: ${Thread.currentThread().name}")
    }

    fun lazyPrintAndStart() = runBlocking {
        println("Main program Start: ${Thread.currentThread().name}")
        val mes1 = async(start = CoroutineStart.LAZY) { getMessageOne() }
        println("Sum mess: $mes1")                                          // start when use mes1 -> print Message One
        println("Main program end: ${Thread.currentThread().name}")
    }

    suspend fun getMessageOne(): String {
        delay(1000)
        println("Message one")
        return "Hello One"
    }
}


fun main() {
    coroutine()
    deferenceThreadAndCoroutine()
    useLaunchAndAsync()

    val coroutineCPT = CoroutineCooperative()
    coroutineCPT.coroutineNonCooperative()
    coroutineCPT.coroutineCooperativeIATV()
    coroutineCPT.coroutineCooperativeLaunch()

    val withContext = WithContext()
    withContext.withContextFinally()
    withContext.withCotextDefault()

    val timeOut = TimeOut()
    timeOut.useWithTimeOut()
    timeOut.useWithTimeOutOrNull()

    ComposingSuspendingFunc.composingSuspending()
    ComposingSuspendingFunc.composingNonSuspending()

    val useStartLazy = UseStartLazy()
    useStartLazy.lazyNonPrintAndStart()
    useStartLazy.lazyNonPrint()
    useStartLazy.lazyPrintAndStart()
}

