package com.example.test.tasks.task1.tasks.task1

fun main() {
    // add Type
    val listType = listOf(1, 2, 3, 4, 5) // except Int can many String, Double ...
    val listType1: List<Int> = listType
    // List
    val listOf = listOf("name", "age", "address") // only read
    val mutableListOf = mutableListOf("name1", "age1", "address1") // can change , add, delete
    // Set
    val setOf = setOf("hehe", "hehe1", "hehe") // practical "hehe","hehe1"
    val mutableSetOf = mutableSetOf("hehe", "hehe1")

    // Map
    val mapOf = mapOf("name" to 1, "age" to 2, "number phone" to 3)
    val mutableMap = mutableMapOf("name" to 1, "age" to 2, "number phone" to 3)
    val mapOf1: Map<String, Int> = mapOf
    /// add map
    mutableMap["status"] = 4 // {name=1, age=2, number phone=3, status=4}
    mutableMap.remove("status") //name=1, age=2, number phone=3}
    /// find key
    println(mapOf.containsKey("name")) // true
    /// get key , value
    println(mutableMap.keys)
    /// remove
    mutableMap.remove("name") // {age=2, number phone=3}

// println
    /// get First last
    println(listOf.first()) // name -- .last // address
    /// get size
    println(listOf.size) // 3
    /// check find on list
    println("name" in listOf) // true
    /// add value
    mutableListOf.add("numberPhone1") // ("name1","age1","address1","numberPhone1)
    /// replace
    mutableListOf[0] = "namemm"  //[namemm, age1, address1]
    /// add first last
    mutableListOf.addFirst("name00") // [name00, namemm, age1, address1, numberPhone1]
    /// remove first last
    mutableListOf.removeFirst() //[namemm, age1, address1, numberPhone1]

// Overall Operations (any, all, none)
    val number = listOf(1, 2, 3, 4, 5, 6, 1)

    /// any no except
    var any: Any? = null
    any = "heheelo"
    any = 123
    any = 12.23
    /// all
    println(number.all { it % 2 == 0 })  // false because 1 3 5 % 2 != 0
    println(number.all { it > 0 }) // true
    // none
    println(number.none { it % 10 == 0 }) // true because no value % 10

    /// max min
    println(number.max()) // 6
    /// sum
    println(number.sum()) // 21
    println(number.sumOf { it * 2 }) // 42
    /// fold
    println(number.fold(0) { it, element -> it + element }) // 21
    val sumEven = number.fold(0) { acc, n ->
        if (n % 2 == 0) acc + n else acc
    }
    println(sumEven) // 12
    /// reduce
    println(number.reduce { it, element -> it + element }) // 21


// Transformation Operations (map, flatMap, groupBy, filter, filterNot, take, drop, takeWhile, dropWhile
    ///map
    println(number.map { it -> it * 3 }) // (1, 2, 3, 4, 5, 6) => [3, 6, 9, 12, 15, 18]
    /// flatMap
    println(number.flatMap { listOf(it, -it) }) // [1, -1, 2, -2, 3, -3, 4, -4, 5, -5, 6, -6]

    class Student(val name: String, val subject: List<String>);

    val student = listOf(
        Student("Son", listOf("math ", "english")),
        Student("Nam", subject = listOf("badminton", "tennis"))
    )
    println(student.flatMap { it.subject }) //[math , english, badminton, tennis]
    /// groupBy
    val grouped = number.groupBy { if (it % 2 == 0) "Even" else "Odd" } //{Odd=[1, 3, 5], Even=[2, 4, 6]}
    /// filter >< filterNot
    val filter = number.filter { it % 2 == 0 }  // 2 4 6
    /// drop
    val drop = number.drop(2) // drop 2 first value [3, 4, 5, 6]
    /// takeWhile as while
    val takeWhile = number.takeWhile { it < 5 } // [1, 2, 3, 4]
    /// dropWhile
    val dropWhile = number.dropWhile { it < 5 } // 5 6

// Accessing and Searching (first , last , firstOrNull, lastOrNull, elementAt, elementArOrNull, indexOf, indexOfFirst, indexOfLast, contains
    /// first last existed top
    /// firstOrNull >< lastOrNull
    val firstOrNull = number.firstOrNull { it > 10 } // null
    val firstOrNull1 = number.firstOrNull { it < 10 } // 1  return value
    /// elementAt
    val elementAt = number.elementAt(10)  // = number[1] = 2 // error => Exception
    val elementAt1 = number.elementAtOrNull(10)  // error => null
    /// indexOf
    val indexOf = number.indexOf(1) // position 0  get when find first // error => -1
    val indexOfFirst = number.indexOfFirst { it > 10 } // -1 => return position
    val indexOfLast = number.indexOfLast { it > 1 } // 5
    /// contain
    val check = number.contains(3) // true = 3 in number

// Sorting Operations (sorted, sortedBy, sortedDescending, sortedByDescending)
    /// sorted, sortedBy >< sortedDescending, sortedByDescending
    val sorted = number.sorted() // [1, 1, 2, 3, 4, 5, 6]
    val sortedBy = number.sortedBy { it % 2 == 0 } // [1, 3, 5, 1, 2, 4, 6]
}


