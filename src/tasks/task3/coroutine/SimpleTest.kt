package com.example.test.tasks.task1.tasks.task3.coroutine

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class SimpleTest {
    @Test
    fun myFirstTest0() {
        Assert.assertEquals(10, 5 + 5)
//        mySuspendingFunc()  // BÁO LỖI VÌ CHỈ RUN ĐC delay trong coroutine
    }

    @Test
    fun myFirstTest() = runBlocking {
        Assert.assertEquals(10, 5 + 5)
        mySuspendingFunc()  // dùng đc do tạo coroutine
    }
}