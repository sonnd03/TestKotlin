package com.example.test.tasks.task1.tasks.task3.coroutine

import org.junit.Assert
import org.junit.Test
import kotlinx.coroutines.runBlocking


class SimpleTest {
    @Test
//    fun myFirstTest(){
//        Assert.assertEquals(10, 5 + 5)
//        mySuspendingFunc()  // BÁO LỖI VÌ CHỈ RUN ĐC delay trong coroutine
//    }

    fun myFirstTest() = runBlocking {
        Assert.assertEquals(10, 5 + 5)
        mySuspendingFunc()  // dùng đc do tạo coroutine
    }

}