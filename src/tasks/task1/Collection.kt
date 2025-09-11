package com.example.test.tasks.task1.tasks.task1

import com.example.test.tasks.task1.tasks.task2.UserUse

private fun syntaxArray() {
    val arrayOf = arrayOf(1, 2, 3)                              // except type Int can String, Char, ....
    println("arayOf; $arrayOf")                                 // [Ljava.lang.Integer;@452b3a41
    println("arrayOf type Int : ${arrayOf.contentToString()}")  // [1, 2, 3]

    val arrayOf01 = arrayOf(1, 3, 5)
    // equals
    println(arrayOf.contentEquals(arrayOf01))    // (false)
    println(arrayOf contentDeepEquals arrayOf01)        // (false)

    val arrayOf1 = arrayOf("apple" to 12, "hello" to 2, "hello" to 2)
    println("arrayOf type Key - value : ${arrayOf1.contentToString()}")   // [(apple, 12), (hello, 2)]

    val arrayOfNull = arrayOfNulls<Int>(3)
    println("arrayOfNull type Default null Before set data: ${arrayOfNull.contentToString()}")     // [null, null, null]
    arrayOfNull[0] = 18
    arrayOfNull[1] = 2
    arrayOfNull[2] = 2003
    println("arrayOfNull type Default null After set data : ${arrayOfNull.contentToString()}")     // [18, 2, 2003]

    val array1 = Array(3) { 1 }
    println("array1 : ${array1.contentToString()}")                                  // [1, 1, 1, 1]

    val array2 = Array(3) { i -> (i * i) }
    println("array2 : ${array2.contentToString()}")                                  // [0, 1, 4, 9, 16]

    val arrayTwoDimensional = Array(2) { Array(2) { 2 } }
    println("arrayTwoDimensional : ${arrayTwoDimensional.contentDeepToString()}")    // [[2, 2], [2, 2]]

    // add
    val arrayNew = arrayOf.plus(1)
    println("arrayNew: ${arrayNew.joinToString()}")         // 1, 2, 3, 1

    // check find on array
    if (1 in arrayOf) {
        println("1 existed on arrayOf")     // 1 existed on arrayOf
    } else {
        println("not find 1 on arrayOf")
    }

    // loop array
    for (x in arrayOf) println(x)           // 1, 2, 3

    // sum all value on array
    println(arrayOf.sum())                  // 6

    // size
    println("size arrayOf: ${arrayOf.size}")            // size arrayOf: 3
}

private fun syntaxList() {
    // Immutable List
    val immutableList = listOf(1, 2, 3)                             // except Int can many String, Double ... or (Any,Any)
    val immutableListType = listOf<String>("Nguyen", "Dac", "Son")  // only one type String
    println("Immutable List: $immutableList")                       //Immutable List: [1, 2, 3]
    println("Immutable List: $immutableListType")                   //Immutable List: [Nguyen, Dac, Son]

    // Mutable List
    val mutableList = mutableListOf("Xiaomi", "Apple", "SamSung")   // except Int can many String, Double ... or (Any,Any)
    val mutableListType = mutableListOf<Int>(18, 2, 2003)           // Only one type Int
    val mutableListTest = mutableListOf(1, 4, 3, 7, 5, 6, 3)        // Use test button extension

    println("Mutable List before add: $mutableList")                // Mutable List before add: [Xiaomi, Apple, SamSung]
    println("Mutable List before add: $mutableListType")            // Mutable List before add: [18, 2, 2003]

    mutableList.add("Oppo")
    println("Mutable List after add: $mutableList")                 // [Xiaomi, Apple, SamSung, Oppo]

    // add first >< last
    mutableListTest.addFirst(2003)
    println("mutableListTest after add first position element 0: $mutableListTest") // [2003, 1, 4, 3, 7, 5, 6, 3]

    // get value take,first >< last
    println("value position 0 1 2: ${mutableListTest.take(3)}")             // [2003, 1, 4]
    println("value position 0 1 2: ${mutableListTest.takeWhile { it % 3 == 0 && it > 5 }}")    // [2003]
    println("Value First: ${mutableList.first()}")                      // Value First: Xiaomi
    println("Value Last: ${mutableList.last()}")                        // Value Last: Oppo

    // get size
    println("Size listOf: ${mutableList.size}")                         // Size listOf: 4
    // count
    println("count element > 4 on List: ${mutableListTest.count { it > 4 }}") // 4


    // sort and sortedDescending
    mutableListTest.sort()
    println("Mutable List after Sorted List: $mutableListTest")              // [1, 3, 3, 4, 5, 6, 7]S

    mutableListTest.sortedBy { it > 3 }
    println("Mutable List after Sorted List element > 3: $mutableListTest")  // [1, 3, 3, 4, 5, 6, 7]

    mutableListTest.sortDescending() // except sortByDescending
    println("Mutable List after Sorted Descending: $mutableListTest")        // [7, 6, 5, 4, 3, 3, 1]

    // filter
    println("${mutableList.filter { it.startsWith("X") }}")     // [Xiaomi]
    println("${mutableListTest.filter { it > 4 }}")                     // [7, 6, 5]

    // reduce return one value
    println("reduce : ${mutableListTest.reduce { it, nextElement -> it + nextElement }}")    // reduce : 2032
    println("fold : ${mutableListTest.fold(10) { it, nextElement -> it + nextElement }}")    // fold : 2042
    println("sum :${mutableListTest.sum()}")    // sum :2032

    // forEach
    mutableListTest.forEach { print("$it ") }                           // 2003 7 6 5 4 3 3 1

    // check contains
    println("1 existed on list: ${mutableListTest.contains(1)}")        // 1 existed on list: true
    println("1 existed on list: ${1 in mutableListTest}")               // 1 existed on list: true

    // map
    val map = mutableListTest.map { if (it > 2) it * 2 else it}
    println("mutableListTest after map element > 2 then * 2 : $map")    // [4006, 14, 12, 10, 8, 6, 6, 1]

    mutableListTest.map {
        fun check(element: Int) {
            if (element > 10) {
                val firstElementMoreBig10 = element / 10
                println("value firstElementMoreBig10: $firstElementMoreBig10")
            } else if (element > 2) {
                val firstElementMoreBig2 = element / 2
                println("value firstElementMoreBig2: $firstElementMoreBig2")
            }
            when (true) {
                (element > 10) -> println("$element > 10")
                (element > 2 && element < 10) -> println("2 < $element < 10")
                (element > 2) -> println("$element > 2")
                else -> println("Done Check")
            }
        }
        check(it)
    }

    /* value firstElementMoreBig10: 200
        2003 > 10
        value firstElementMoreBig2: 3
        2 < 7 < 10
        value firstElementMoreBig2: 3
        2 < 6 < 10
        value firstElementMoreBig2: 2
        2 < 5 < 10
        value firstElementMoreBig2: 2
        2 < 4 < 10
        value firstElementMoreBig2: 1
        2 < 3 < 10
        value firstElementMoreBig2: 1
        2 < 3 < 10
        Done Check
    */

    // min, max
    println("mutableListTest min : ${mutableListTest.minOrNull()}")                 // 1 // recommend more use .min, .max

    //replace
    mutableListTest[0] = 1000
    println("mutableListTest after replace element positon 0: $mutableListTest")    // [1000, 7, 6, 5, 4, 3, 3, 1]

    // groupBy
    val newList = mutableListTest.groupBy { if (it % 2 == 0) "Chan" else "Le" }
    val newList1 = mutableListTest.groupBy { it % 2 == 0}
    println("List after group: $newList")                                           // {Chan=[1000, 6, 4], Le=[7, 5, 3, 3, 1]}
    println("List after group: $newList1")                                          // {true=[1000, 6, 4], false=[7, 5, 3, 3, 1]}

    // union, intersect, subtract
    val mutableListA = mutableListOf(1, 2, 3, 4, 2)
    val mutableListB = mutableListOf(3, 4, 5, 6)
    println("Union (a+b bỏ lặp): ${mutableListA union mutableListB}")           // [1, 2, 3, 4, 5, 6]
    println("Intersect (a trùng b): ${mutableListA intersect mutableListB}")    // [3, 4]
    println("Subtract (a có b k có): ${mutableListA subtract mutableListB}")    // [1, 2]

    // any / all / none
    println("Any > 5: ${mutableListA.any { it > 5 }}")          // false
    println("All > 0: ${mutableListA.all { it > 0 }}")          // true
    println("None == 1: ${mutableListA.none { it == 1 }}")      // false

    // remove, drop
    println("Drop mutableListTest: ${mutableListTest.drop(2)}") // [6, 5, 4, 3, 3, 1]

    mutableListTest.removeAll { !(it % 2 == 0 && it > 2 && it < 7) }
    println("mutableListTest after remove all element % 2 !== 0 and element < 2 and element > 7 $mutableListTest") // [6, 4]

    mutableListTest.remove(3)
    println("mutableListTest after remove element find first == 3: $mutableListTest") // [6, 4]

    mutableListTest.subList(0, 1).clear()
    println("mutableListTest after remove position 0 -> <1: $mutableListTest")      // [4]

    mutableListTest.removeFirst()  // first >< last
    println("mutableListTest after remove element positon 0: $mutableListTest")     // []

    // value use many extension
    val valueTest = mutableListOf(1, 4, 2, 5, 7, 2, 12, 4, 62)
    val valueTest1 = mutableListOf(23, 24, 12, 4, 1, 4)

    val valueManyExtension = valueTest
        .take(5)
        .map { it * 5 }
        .filter { it > 18 }
    println("value Many Extension: $valueManyExtension")    // value Many Extension: [20, 25, 35]

    val valueManyExtension2 = valueTest
        .plus(valueTest1 subtract valueTest)
        .sorted()
        .filter { it % 2 == 0 }
        .take(5)
        .toSet()
    println("value Many Extension2: $valueManyExtension2")

    val dataData = mutableListOf<UserUse>()
    val listUser = listOf(
        UserUse("Son18", 18),
        UserUse("Son20", 20),
        UserUse("Hoàng12", 12),
        UserUse("Hoàng22", 22),
        UserUse("Hoàng21", 21),
        UserUse("Nhi", 18, "Women"),
        UserUse("Nhi15", 15, "Women"),
        UserUse("Tuấn", 9),
    )
    dataData.addAll(listUser)
    println("Data User :")
    dataData.forEach { it ->
        println("name: ${it.name}, age: ${it.name}, sex: ${it.sex}")
    }

    val userAge18Male = dataData
        .filter { it.age > 18 }
        .filter { it.sex == "Male" }
        .sortedBy { it.name }
    userAge18Male.forEach { print("name: ${it.name} ") }

    val startWriteName = listOf("H", "S")
    dataData.filter { it -> startWriteName.any { name -> it.name!!.startsWith(name) } }
        .sortedBy { it.age }
        .map {
            fun checkAndPrint(ageUser: Int) {
                if (ageUser > 18) {
                    println("${it.name} old enough")
                } else {
                    println("${it.name} not old enough")
                }
            }
            checkAndPrint(it.age)
        }
}

private fun syntaxSet() {
    // Immutable Set
    val immutableSet = setOf(18, 2, 2003)                           // except Int can String, Double ... or (Any,Any)
    val immutableSetType = setOf<String>("Nguyen", "Dac", "Son")    // Only String
    println("Immutable Set: $immutableSet")                         // Immutable Set: [18, 2, 2003]
    println("Immutable Set: $immutableSetType")                     // Immutable Set: [Nguyen, Dac, Son]

    // Mutable Set
    val mutableSet = mutableSetOf(1, 12, "SamSung")
    val mutableSetTest = mutableSetOf(1, 4, 3, 7, 5, 6, 3)           // Use test button extension
    println("Mutable Set before add: $mutableSet")                   // [1, 12, SamSung]
    println("Mutable Set before add: $mutableSetTest")               // [1, 4, 3, 7, 5, 6]

    // Add
    println("Mutable Set before add: $mutableSet")      // [1, 12, SamSung]
    mutableSet.add("Oppo")
    println("Mutable Set after add: $mutableSet")       // [1, 12, SamSung, Oppo]
    mutableSet.addAll(listOf("Xiaomi, Sony"))
    println("Mutable Set after add: $mutableSet")       // [1, 12, SamSung, Oppo, Xiaomi, Sony]

    // get element first >< last
    println("First element: ${mutableSet.first()}")     // First element: 1
    println("Last element: ${mutableSet.last()}")       // Last element: Xiaomi, Sony

    // get size
    println("Size of mutableSet: ${mutableSet.size}")                // 5
    // count
    println("Count element > 3: ${mutableSetTest.count { it > 3 }}") // 4

    // filter
    println("Filter > 4: ${mutableSetTest.filter { it > 4 }}")   // [7,5,6]

    // reduce + sum
    println("Sum of mutableSetTest: ${mutableSetTest.reduce { it, nextElement -> it + nextElement }}")              // 26
    println("Sum of mutableSetTest: ${mutableSetTest.fold(10) { it, nextElement -> it + nextElement }}")    // 36
    println("Sum of mutableSetTest: ${mutableSetTest.sum()}")                                                      // 26


    // forEach
    mutableSetTest.forEach { print("$it ") }        // 1 4 3 7 5 6

    // check contains
    println("mutableSet contains 1: ${mutableSetTest.contains(1)}")                                                       // true
    println("mutableSet contains 1: ${1 in mutableSetTest}")                                                              // true
    println("mutableSet containsAll listOf(SamSung,Oppo): ${mutableSet.containsAll(listOf("SamSung", "Oppo"))}") // true

    // any / all / none
    println("Any element > 5: ${mutableSetTest.any { it > 5 }}")      // true
    println("All element > 0: ${mutableSetTest.all { it > 0 }}")      // true
    println("None element < 0: ${mutableSetTest.none { it < 0 }}")    // true

    // map
    val squaredSet = mutableSetTest.map { it * it }
    println("mutableSetTest squared (map): $squaredSet") // [1, 16, 9, 49, 25, 36]

    // groupBy
    val newList = mutableSetTest.groupBy { if (it % 2 == 0) "Chan" else "Le" }
    val newList1 = mutableSetTest.groupBy { it % 2 == 0}
    println("Set after group: $newList")                // {Chan=[1000, 6, 4], Le=[7, 5, 3, 3, 1]}
    println("Set after group: $newList1")               // {false=[1, 3, 7, 5], true=[4, 6]}


    // union, intersect, subtract
    val setA = setOf(1, 2, 3, 4)
    val setB = setOf(3, 4, 5, 6)
    println("Union (a+b bỏ lặp): ${setA union setB}")           // [1, 2, 3, 4, 5, 6]
    println("Intersect (a trùng b): ${setA intersect setB}")    // [3, 4]
    println("Subtract (a có b k có): ${setA subtract setB}")    // [1, 2]

    // min, max
    println("mutableSetTest min : ${mutableSetTest.minOrNull()}")     // 1 // recommend more use .min, .max

    // remove, drop
    println("mutableSetTest after remove: ${mutableSetTest.drop(1)}") // [4, 3, 7, 5, 6]

    println("check Xiaomi : ${mutableSet.contains("Xiaomi")}")  // false
    println("Set current: $mutableSet")                         // [1, 12, SamSung, Oppo, Xiaomi, Sony]
    mutableSet.remove(" Xiaomi")
    println("mutableSet after remove Xiaomi: $mutableSet")       // [1, 12, SamSung, Oppo, Xiaomi, Sony]

    mutableSetTest.removeIf{ it < 5 }
    println("mutableSetTest after clear: $mutableSetTest")      // [7, 5, 6]

}

private fun syntaxMap() {
    // Immutable Map
    val immutableMap = mapOf(1 to "One", 2 to "Two", 3 to "Three")
    val immutableMapType = mapOf<Int, String>(4 to "Four", 5 to "Five")
    println("Immutable Map: $immutableMap")         // {1=One, 2=Two, 3=Three}
    println("Immutable Map: $immutableMapType")     // {4=Four, 5=Five}

    // Mutable Map
    val mutableMapTest = mutableMapOf(18 to "Day", 2 to "Month")
    println("Mutable Map: $mutableMapTest")         // {18=Day, 2=Month}

    // add , put
    println("Mutable Map before add: $mutableMapTest")      // {18=Day, 2=Month}

    mutableMapTest[18022003] = "Full"                       // add new key-value
    println("Mutable Map after add: $mutableMapTest")       // {18=Day, 2=Month, 18022003=Full}

    mutableMapTest.put(2003, "Year")
    println("Mutable Map after add1: $mutableMapTest")      // {18=Day, 2=Month, 18022003=Full, 2003=Year}

    mutableMapTest.putAll(listOf(1102 to "hate", 1997 to "love"))
    println("Mutable Map after add2: $mutableMapTest")      // {18=Day, 2=Month, 18022003=Full, 2003=Year, 1102=hate, 1997=love}

    // get value
    println("Get value with key=18: ${mutableMapTest[18]}") // Twenty
    println(
        "Get value with key not exist message default: ${
            mutableMapTest.getOrDefault(50, "Not Found")}"
    )    // Get value with key not exist message default: Not Found

    // size + count
    println("Size of mutableMapTest: ${mutableMapTest.size}")                       // 6
    println("Size of mutableMapTest: ${mutableMapTest.count { it.key > 1000 }}")    // 4

    // filter
    println("Filtered map with key > 25: ${mutableMapTest.filter { (key, _) -> key > 20 }}")
    // {18022003=Full, 2003=Year, 1102=hate, 1997=love}
    println("Filtered map with key > 25: ${mutableMapTest.filter { (_, value) -> value == "love" }}")   // {1997=love}

    // update, replace
    mutableMapTest[18] = "NewDay"
    println("Mutable Map after update key=20: $mutableMapTest")
    // {18=NewDay, 2=Month, 18022003=Full, 2003=Year, 1102=hate, 1997=love}

    // sum
    println("sum key: ${mutableMapTest.keys.sum()}")                                                // 18027125
    println("reduce key: ${mutableMapTest.keys.reduce {dau, next -> dau + next}}")                  // 18027125
    println("reduce value: ${mutableMapTest.values.reduce {dau, next -> dau + next}}")              // NewDayMonthFullYearhatelove
    println("fold key: ${mutableMapTest.keys.fold(10){dau, next -> dau + next}}")           // 18027135
    println("fold value: ${mutableMapTest.values.fold("hẹ hẹ"){dau, next -> dau + next}}")  // hẹ hẹNewDayMonthFullYearhatelove

    // forEach
    mutableMapTest.forEach { key, value -> println("Key: $key -> Value: $value") }
    // Key: 18 -> Value: Day \nKey: 2 -> Value: Month \nKey: 2003 -> Value: Year

    // check contains
    println("Contains key = 18: ${mutableMapTest.containsKey(18)}")                         // true
    println("Contains value = Year: ${mutableMapTest.containsValue("Year")}")               // true

    // mapValues, mapKeys
    println("Map after mapValues: ${mutableMapTest.mapValues { it.value.uppercase() }}")
    // {18=NEWDAY, 2=MONTH, 18022003=FULL, 2003=YEAR, 1102=HATE, 1997=LOVE}
    println("Map after mapKeys: ${mutableMapTest.mapKeys { it.key * 10 }}")
    // {180=NewDay, 20=Month, 180220030=Full, 20030=Year, 11020=hate, 19970=love}

    // replace
    mutableMapTest.replace(18, "Day Replace")
    println("Mutable Map after replace key=30: $mutableMapTest")                            // {18=Day Replace, 2=Month, 2003=Year}

    // keys , values , entries
    println("Keys: ${mutableMapTest.keys}")       // [18, 2, 18022003, 2003, 1102, 1997]
    println("Values: ${mutableMapTest.values}")   // [Day Replace, Month, Full, Year, hate, love]
    println("Entries: ${mutableMapTest.entries}") // [18=Day Replace, 2=Month, 18022003=Full, 2003=Year, 1102=hate, 1997=love]

    // any / all / none
    println("Any key > 5: ${mutableMapTest.any { it.key > 5 }}")            // true
    println("All key > 0: ${mutableMapTest.all { it.key > 0 }}")            // true
    println("None value == S: ${mutableMapTest.none { it.value == "S" }}")  // true

    // union, intersect, subtract
    val mapA = mapOf(1 to "one", 2 to "two")
    val mapB = mapOf(2 to "two", 3 to "three")
    println("Union (a+b bỏ lặp): ${mapA.keys union mapB.keys}")                 // [1, 2, 3]
    println("Intersect (a trùng b): ${mapA.entries intersect mapB.entries}")    // [2=two]
    println("Subtract (a có b k có): ${mapA.values subtract mapB.values}")      // [one]

    // min, max
    println("key max: ${mutableMapTest.keys.maxOrNull()}")      // 18022003
    println("value max: ${mutableMapTest.values.maxOrNull()}")  // love

    // groupBy
    println("Group key%2 == 0: ${mutableMapTest.entries.groupBy { if (it.key % 2 == 0) "key_chan" else "key_le" }}")
    //{key_chan=[18=Day Replace, 2=Month, 1102=hate], key_le=[18022003=Full, 2003=Year, 1997=love]}

    // remove
    mutableMapTest.remove(1252348)
    println("Mutable Map after remove key=18: $mutableMapTest") // {2=Month, 18022003=Full, 2003=Year, 1102=hate, 1997=love}

    mutableMapTest.clear()
    println("Mutable Map after clear: $mutableMapTest")         // {}
}


fun main() {
    syntaxArray()
    syntaxList()
    syntaxSet()
    syntaxMap()
}




