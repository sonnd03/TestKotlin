package com.example.test.tasks.task1

fun main() {
// Type Data
    val number1 = 12
    val numberAdDtype: Int = 12
    var numberAddType: Int = 12

// toType want convert ex: toInt() , toByte()
    val type1: Int = 12;
    val type2: Double = type1.toDouble();
    println("type after convert Int to Double $type2")

    /// Integer (Byte, Short, Int, Long)
    val numberByte: Byte = 12 //(-128,127)
    val numberShort: Short = 32760 //(-32768,32767)
    val myNum1: Int = 5 //(-2147483648,2147483647)
    val myLong: Long = 2147483648 //(-9223372036854775808,9223372036854775807)
    val myLong1: Long = 100L //(-9223372036854775808,9223372036854775807)

    /// Point Type
    val myFloat: Float = 3.14F
    val myFloat1: Float = 12E4F  //(120000.0)
    val Double: Double = 12.0933233

    /// Boolean
    val myBoolean: Boolean = true

    /// Character
    //// \t(tab) , \n(new line),
    val myLetter: Char = 'S'
    val myString: String = "Nguyen Dac Son"
    val myString1: String = "Nguyen Dac Son1"

//    println("type data position 0 on my String = ${myString[0]}")
//    println("length String: " + myString.length)
//    println(myString.uppercase())
//    println(myString.lowercase())
//    val compare: Int = myString.compareTo(myString1)
//    println(compare) //(if identical => return 0 else => return -1)
//    //// search on String
//    println(myString.indexOf("Dac"))  // 7 location start Dac
//    println(myString.indexOf("Da1c"))  // -1 because "Da1c" not find on myString
//    println(myString.plus(myString1))
//    println("my name is $myString")

    /// Array
//    val myArrayOf0 = arrayOf(1, 2, 3)
//    val myArrayOf01 = arrayOf("apple" to 12, "hello" to 2)
//    var myArrayOf = arrayOf("a", "b", "c")
//    var myArrayOf1 = arrayOf("a", "b", "c")
//    val array = arrayOfNulls<Int>(4)
//    val array1 = Array<Int>(4) { 1 }
//    val array2 = Array(5) { i -> (i * i).toString() }
//    val arrayTwoDimensional = Array(2) { Array(2) { 2 } }
//    array[0] = 12;
//    array[3] = 1

//    /// change value myArrayOf[0]
//    myArrayOf[0] = "12A10"

//    /// add on array
//    myArrayOf += "add value"

//    /// check find on array
//    if ("12A3" in myArrayOf) println("success") else println("not found")

//    /// check type
//    if (number1 is Int) println("type is Int") else println("not type Int")  // type is Int

//    /// Loop array
//    for (x in myArrayOf) println(x)  // a, b, c

//    /// sum all value on array
//    println(myArrayOf0.sum()) // 6

//    /// shuffle
//    val shuffle = myArrayOf0.toList().shuffled()

//    /// to Map
//    val map = myArrayOf01.toMap()
    /// print

//    println(shuffle.joinToString())
//    println(arrayTwoDimensional.contentDeepToString())
//    println(myArrayOf.joinToString()) // a, b, c


//    println(array.joinToString());
//    println(array1.joinToString())
//    println(array2.joinToString())

//    println(myArrayOf.contentEquals(myArrayOf1)) // (true)
//    println(myArrayOf contentDeepEquals myArrayOf1) // (true)
//    println(myArrayOf[0] + " size: " + myArrayOf.size )


//    println(myLong::class.simpleName)
//    println(myLong1::class.simpleName)
//    println(myFloat1)
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

// Operator
/// Arithmetic(số học): +, += , - , -=, *, *= , %, %= , ++, --, /, /=
/// Comparison(so sánh): ==, != , > , < , >= , <=, ===(phân vùng bộ nhớ)
/// Logic &&(and) ||(or) !(not)
}

//In ra các số lẻ.
private class OddNumber {

    fun oddNumber(list: List<Int>) {
        println("list is odd numbers:" + list.filter { it % 2 != 0 })
        println("----------------------------------------------------------------------")
        for (i in list) {
            if (i % 2 != 0) {
                println("odd numbers order$orderNumber: $i")
                orderNumber++
            }
        }
    }

    fun oddNumber1(list: List<Int>) {
        println("----------------------------------------------------------------------")
        list.forEachIndexed { index, value ->
            if (value % 2 != 0) {
                println("odd numbers order$index: $value");
            }
        }
    }
}

//Tính tổng các số chẵn.
private class SumEvenNumber {

    fun sumEvenNumber1(list: List<Int>) {
        var sum = list.filter { it % 2 == 0 }.sum();
        var sum1 = list.filter { it % 2 == 0 }.reduce { number, it -> number + it }
        var sum2 = list.filter { it % 2 == 0 };
        sum2.forEach { println("number $it") }
        println("sum of even numbers: $sum")
        println("sum of even numbers: $sum1")
    }

}

//Tạo list mới chứa bình phương của tất cả phần tử.
private class ListCopy {
    fun listCopy(list: List<Int>) {
        var listNew = list.map { value -> value * value }
        var listNew1 = list.filter { it % 2 == 0 }.map { value -> value * value }
        println("new List: $listNew")
        println("new List: $listNew1")
    }
}
////////////////////////////////////////////////////////////

