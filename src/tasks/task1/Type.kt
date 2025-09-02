package com.example.test.tasks.task1
private var orderNumber: Int = 0;
val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
var changeList = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7);
val set = setOf(1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10);
val mapList = mutableMapOf("name" to 18, "name1" to 19, "name2" to 20);


// Type Data
val number1 = 12
val numberAdDtype: Int = 12
var numberAddType: Int = 12

/// Integer (Byte, Short, Int, Long)
val numberByte: Byte = 12 //(-128,127)
val numberShort: Short = 32760 //(-32768,32767)
val myNum1: Int = 5 //(-2147483648,2147483647)
val myLong: Long = 2147483648 //(-9223372036854775808,9223372036854775807)

val myDouble: Double = 5.1
val myLetter: Char = 'S'
val myBoolean: Boolean = true
val myString: String = "Nguyen Dac Son"



fun main() {
    println(myLong::class.simpleName)
//    OddNumber().oddNumber(list)
//    OddNumber().oddNumber1(list)
//
//    SumEvenNumber().sumEvenNumber1(list)
//
//    ListCopy().listCopy(list)
//
//    println(list)
//    println(set)
//    println(mapList)
//
//    changeList.add(8)
//
//    println(mapList["name"])
//    mapList.put("name3", 21);
//    println(mapList)

}

//In ra các số lẻ.
private class OddNumber{

     fun oddNumber(list: List<Int>) {
        println("list is odd numbers:" + list.filter { it % 2 != 0 })
        println("----------------------------------------------------------------------")
        for (i in list){
            if (i % 2 != 0){
                println("odd numbers order$orderNumber: $i")
                orderNumber++
            }
        }
    }

    fun oddNumber1(list: List<Int>) {
        println("----------------------------------------------------------------------")
        list.forEachIndexed { index, value ->
            if(value % 2 != 0){
                println("odd numbers order$index: $value");
            }
        }
    }
}

//Tính tổng các số chẵn.
private class SumEvenNumber{

    fun sumEvenNumber1(list: List<Int>) {
        var sum = list.filter { it % 2 == 0 }.sum();
        var sum1 = list.filter { it % 2 == 0 }.reduce {number, it -> number + it }
        var sum2 = list.filter { it % 2 == 0 };
        sum2.forEach { println("number $it") }
        println("sum of even numbers: $sum")
        println("sum of even numbers: $sum1")
    }

}

//Tạo list mới chứa bình phương của tất cả phần tử.
private class ListCopy{
    fun listCopy(list: List<Int>){
        var listNew = list.map { value -> value * value }
        var listNew1 = list.filter { it % 2 == 0 }.map { value -> value * value }
        println("new List: $listNew")
        println("new List: $listNew1")
    }
}
////////////////////////////////////////////////////////////

