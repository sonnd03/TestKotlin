package com.example.test.tasks.task1

private fun syntaxVariable() {
    // mutable
    var a = 12
    a = 18
    print("Mutable variable a: $a")     // Mutable variable a: 18

    // immutable
    val b = 12
//    b = 12                            // error: 'val' cannot be reassigned
    print("Immutable variable a: $b")   // Immutable variable a: 12
}

private fun syntaxDataType() {
    val any = 12                // String, Int , Double ....
    val char: Char = 'S'        // one Value
    val boolean: Boolean = true // or false
    val int: Int = 12           //(-2147483648,2147483647)
    val long: Long = 2147483648 //(-9223372036854775808,9223372036854775807)
    val long1: Long = 100L      //(-9223372036854775808,9223372036854775807)
    val double: Double = 18.02  //(4.9E-324, 1.7976931348623157E308)
    val float: Float = 3.14F    //(1.4E-45, 3.4028235E38)
    val float1: Float = 12E4F   //(120000.0) // E1 = 10.
    val byte: Byte = 12         //(-128,127)
    val short: Short = 32760    //(-32768,32767)

    println("Data type Any: $any")              // Data type Any: 12
    println("Data type Char: $char")            // Data type Char: S
    println("Data type Boolean: $boolean")      // Data type Boolean: true
    println("Data type Int: $int")              // Data type Int: 12
    println("Data type Long: $long")            // Data type Long: 2147483648
    println("Data type Long end L: $long1")     // Data type Long end L: 100
    println("Data type Double: $double")        // Data type Double: 18.02
    println("Data type Float: $float")          // Data type Float: 3.14
    println("Data type Float use E: $float1")   // Data type Float use E: 120000.0
    println("Data type Byte: $byte")            // Data type Byte: 12
    println("Data type Short: $short")          // Data type Short: 32760
}

private fun syntaxConvert() {
    val double = 12.3
    val toInt = double.toInt()
    val toFloat = toInt.toFloat()
    val toString = toFloat.toString()

    print("Double: $double, toInt: $toInt, toFloat: $toFloat, toString: $toString ") // Double: 12.3, toInt: 12, toFloat: 12.0, toString: 12
}

private fun syntaxString() {
    val string = "Nguyen Dac Son"
    val string1 = "Son Nguyen Dac"

    print("String: $string")    // String: Nguyen Dac Son
    print(string)               // Nguyen Dac Son

    // extension on String
    println("type data position 0: ${string[0]}")                                       // type data position 0: N
    println("length String: ${string.length}")                                          // length String: 14
    println("string after Uppercase: ${myString.uppercase()}")                          // string after Uppercase: NGUYEN DAC SON
    println("string after Uppercase: ${myString.lowercase()}")                          // string after Uppercase: nguyen dac son
    println("compare: ${myString.compareTo(string)}")                                   // compare: 0
    println("positon type:'Dac' first on String: ${myString.indexOf("Dac")}")   // positon type:'Dac' first on String: 7
    println("plus two String: ${myString.plus(string1)}")                       // plus two String: Nguyen Dac SonSon Nguyen Dac

}

private fun syntaxOperation() {
    val a = 18
    val b = 2
    val c = 2003
    val d = 2

    // +, -, *, /, %
    println("a + b = ${a + b}")                 // 20
    println("a - b = ${a - b}")                // 16
    println("a * b = ${a.times(b)}")   // 36
    println("a / b = ${a / b}")               // 9
    println("a % b = ${a.rem(b)}")    // 0

    // += , -= , *= , /= , %=
    println("a += 3 => ${a + 3}")     // 21
    println("a -= 1 => ${a - 1}")     // 17
    println("a *= 2 => ${a * 2}")     // 36
    println("a /= 4 => ${a / 4}")     // 4
    println("a %= 3 => ${a % 3}")     // 0 // Value of 'a % 3' is always zero

    // ++ , --
    println("a++ => ${a + 1}")        // 19
    println("a-- => ${a - 1}")        // 17

    // &&, ||, ==, ===
    if (a < c && b < c) {
        println("a and b < c") // a and b < c
    }
    if (a < c || b > c) {
        println("a < c")       // a < c
    }
    if (b == d) {
        println("b = d = 2")   // b = d = 2
    }
    if (b === d) {
        println("b === d")     // b === d because in a fun
    } else {
        println("No")
    }
}

fun main() {
    syntaxVariable()
    syntaxDataType()
    syntaxConvert()
    syntaxString()
    syntaxOperation()
}

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

private class ListCopy {
    fun listCopy(list: List<Int>) {
        var listNew = list.map { value -> value * value }
        var listNew1 = list.filter { it % 2 == 0 }.map { value -> value * value }
        println("new List: $listNew")
        println("new List: $listNew1")
    }
}