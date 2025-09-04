package com.example.test.tasks.task1.tasks.task1

private fun syntaxArray() {
    val arrayOf = arrayOf(1, 2, 3)          // except type Int can String, Char, ....
    val arrayOf01 = arrayOf(1, 3, 5)
    val arrayOf1 = arrayOf("apple" to 12, "hello" to 2, "hello" to 2)
    val arrayOfNull = arrayOfNulls<Int>(3)
    val array1 = Array(3) { 1 }
    val array2 = Array(3) { i -> (i * i) }
    val arrayTwoDimensional = Array(2) { Array(2) { 2 } }

    println("arrayOf type Int : ${arrayOf.contentToString()}")                      // [1, 2, 3]
    println("arrayOf type Key - value : ${arrayOf1.contentToString()}")             // [(apple, 12), (hello, 2)]

    println("arrayOfNull type Default null Before set data: ${arrayOfNull.contentToString()}")     // [null, null, null]
    arrayOfNull[0] = 18
    arrayOfNull[1] = 2
    arrayOfNull[2] = 2003
    println("arrayOfNull type Default null After set data : ${arrayOfNull.contentToString()}")     // [18, 2, 2003]

    println("array1 : ${array1.contentToString()}")                                  // [1, 1, 1, 1]
    println("array2 : ${array2.contentToString()}")                                  // [0, 1, 4, 9, 16]
    println("arrayTwoDimensional : ${arrayTwoDimensional.contentDeepToString()}")    // [[2, 2], [2, 2]]

    // add
    val arrayNew = arrayOf.plus(1)

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

    // equals
    println(arrayOf.contentEquals(arrayOf01))    // (false)
    println(arrayOf contentDeepEquals arrayOf01)        // (false)

    // size
    println("size arrayOf: ${arrayOf.size}")            // size arrayOf: 3
}

private fun syntaxList() {
    // Immutable List
    val immutableList = listOf(1, 2, 3)                             // except Int can many String, Double ... or (Any,Any)
    val immutableListType = listOf<String>("Nguyen", "Dac", "Son")  // only one type String
    println("Immutable List: $immutableList") //

    // Mutable List
    val mutableList = mutableListOf("Xiaomi", "Apple", "SamSung")       // except Int can many String, Double ... or (Any,Any)
    val mutableListTest = mutableListOf(1, 4, 3, 7, 5, 6, 3)            // Use test button extension

    println("Mutable List before add: $mutableList")
    mutableList.add("Oppo")
    println("Mutable List after add: $mutableList")                     // [Xiaomi, Apple, SamSung, Oppo]

    // add first >< last
    mutableListTest.addFirst(2003)
    println("mutableListTest after add first position element 0: $mutableListTest") // [2003, 1, 4, 3, 7, 5, 6, 3]

    // get value take,first >< last
    println("value position 0 1 2: ${mutableListTest.take(3)}")             // [2003, 1, 4]
    println("value position 0 1 2: ${mutableListTest.takeWhile { it > 4 }}")    // [2003]
    println("Value First: ${mutableList.first()}")                      // Value First: Xiaomi
    println("Value Last: ${mutableList.last()}")                        // Value Last: Oppo

    // get size
    println("Size listOf: ${mutableList.size}")                         // Size listOf: 4

    // sort and sortedDescending
    mutableListTest.sort()
    println("Mutable List after Sorted List: $mutableListTest")              // [1, 3, 3, 4, 5, 6, 7]

    mutableListTest.sortedBy { it > 3 }
    println("Mutable List after Sorted List element > 3: $mutableListTest")  // [1, 3, 3, 4, 5, 6, 7]

    mutableListTest.sortDescending() // except sortByDescending
    println("Mutable List after Sorted Descending: $mutableListTest")        // [7, 6, 5, 4, 3, 3, 1]

    // filter
    println("${mutableList.filter { it.startsWith("X") }}")     // [Xiaomi]
    println("${mutableListTest.filter { it > 4 }}")                     // [7, 6, 5]

    // reduce return one value
    println("sum all element on list: ${mutableListTest.reduce { it, nextElement-> it + nextElement }}")    // sum all element on list: 29

    // forEach
    mutableListTest.forEach { print("$it ") }                           // 7 6 5 4 3 3 1 1

    // count
    println("count element > 4 on List: ${mutableListTest.count{it>4}}") // 4

    // check contains
    println("1 existed on list: ${mutableListTest.contains(1)}")        // 1 existed on list: true
    println("1 existed on list: ${1 in mutableListTest}")               // 1 existed on list: true

    // map
    println("mutableListTest after map : ${mutableListTest.map { it * it }}")       // [4012009, 49, 36, 25, 16, 9, 9, 1]

    // min, max
    println("mutableListTest min : ${mutableListTest.minOrNull()}")                 // 1 // recommend more use .min, .max

    //replace
    mutableListTest[0] =  1000
    println("mutableListTest after replace element positon 0: $mutableListTest")    // [1000, 7, 6, 5, 4, 3, 3, 1, 9]

    // groupBy
    val newList = mutableListTest.groupBy { if (it % 2 == 0) "Chan" else "Le" }
    println("List after group: $newList")                                           // {Chan=[1000, 6, 4], Le=[7, 5, 3, 3, 1]}

    // remove, drop
    println("Drop immutableListOf: ${immutableList.drop(2)}") // [3]

    mutableListTest.remove(3)
    println("mutableListTest after remove element find first == 3: $mutableListTest") // [1000, 7, 6, 5, 4, 3, 1, 9]

    mutableListTest.subList(0,3).clear()
    println("mutableListTest after remove position 0 -> <3: $mutableListTest")      // [5, 4, 3, 1, 9]

    mutableListTest.removeFirst()  // first >< last
    println("mutableListTest after remove element positon 0: $mutableListTest")     // [7, 6, 5, 4, 3, 3, 1, 9]
}

private fun syntaxSet() {
    // Immutable Set
    val immutableSet = setOf(18, 2, 2003)                           // except Int can String, Double ... or (Any,Any)
    val immutableSetType = setOf<String>("Nguyen", "Dac", "Son")    // Only String
    println("Immutable Set: $immutableSet")                         // Immutable Set: [Nguyen, Dac, Son]

    // Mutable Set
    val mutableSet = mutableSetOf(1, 12, "SamSung")
    val mutableSetTest = mutableSetOf(1, 4, 3, 7, 5, 6, 3)           // Use test button extension

    // Add
    println("Mutable Set before add: $mutableSet")      // [1, 12, SamSung]
    mutableSet.add("Oppo")
    println("Mutable Set after add: $mutableSet")       // [1, 12, SamSung, Oppo]

    // get element first >< last
    println("First element: ${mutableSet.first()}")
    println("Last element: ${mutableSet.last()}")

    // get size
    println("Size of mutableSet: ${mutableSet.size}")   // 3

    // filter
    println("Filter > 4: ${mutableSetTest.filter { it > 4 }}")   // [7,5,6]

    // reduce
    println("Sum of mutableSetTest: ${mutableSetTest.reduce { it, nextElement-> it + nextElement }}") // 26

    // forEach
    mutableSetTest.forEach { print("$it ") }

    // count
    println("Count element > 3: ${mutableSetTest.count { it > 3 }}") // 3

    // check contains
    println("mutableSet contains Apple: ${mutableSetTest.contains(1)}")                                                   // true
    println("mutableSet containsAll listOf(Apple,Oppo): ${mutableSet.containsAll(listOf("SamSung","Oppo"))}")  // true

    // any / all / none
    println("Any element > 5: ${mutableSetTest.any { it > 5 }}")      // true
    println("All element > 0: ${mutableSetTest.all { it > 0 }}")      // true
    println("None element < 0: ${mutableSetTest.none { it < 0 }}")    // true

    // map
    val squaredSet = mutableSetTest.map { it * it }
    println("mutableSetTest squared (map): $squaredSet") // [1,16,9,49,25,36]

    // min, max
    println("mutableSetTest min : ${mutableSetTest.minOrNull()}")     // 1 // recommend more use .min, .max

    // union, intersect, subtract
    val setA = setOf(1, 2, 3, 4)
    val setB = setOf(3, 4, 5, 6)
    println("Union (a+b bỏ lặp): ${setA union setB}")           // [1, 2, 3, 4, 5, 6]
    println("Intersect (a trùng b): ${setA intersect setB}")    // [3, 4]
    println("Subtract (a có b k có): ${setA subtract setB}")    // [1, 2]

    // remove, drop
    mutableSetTest.remove(3)
    println("mutableSetTest after remove element find first == 3: $mutableSetTest") // [1, 4, 7, 5, 6]

    mutableSet.remove("Apple")
    println("mutableSet after remove Apple: $mutableSet")       // [1, 12, SamSung, Oppo]

    mutableSetTest.removeAll { it < 5 }
    println("mutableSetTest after clear: $mutableSetTest")      // [7, 5, 6]
}

private fun syntaxMap() {
    // Immutable Map
    val immutableMap = mapOf(1 to "One", 2 to "Two", 3 to "Three")
    val immutableMapType = mapOf<Int, String>(4 to "Four", 5 to "Five")
    println("Immutable Map: $immutableMap")  // {1=One, 2=Two, 3=Three}

    // Mutable Map
    val mutableMapTest = mutableMapOf(18 to "Day", 2 to "Month")

    // add , put
    println("Mutable Map before add: $mutableMapTest")      // {18=Day, 2=Month}
    mutableMapTest[18] = "NewDay"                           // add new key-value
    mutableMapTest.put(2003, "Year")
    println("Mutable Map after add: $mutableMapTest")       // {18=NewDay, 2=Month, 2003=Year}

    // get value
    println("Get value with key=18: ${mutableMapTest[18]}") // Twenty
    println("Get value with key not exist message default: ${mutableMapTest.getOrDefault(50, "Not Found")}")    // Get value with key not exist message default: Not Found

    // size
    println("Size of mutableMapTest: ${mutableMapTest.size}")  // 3

    // filter
    println("Filtered map with key > 25: ${mutableMapTest.filter { (key, _) -> key > 20 }}")    // {2003=Year}

    // update
    mutableMapTest[18] = "Day"
    println("Mutable Map after update key=20: $mutableMapTest")                             // {18=Day, 2=Month, 2003=Year}

    // forEach
    mutableMapTest.forEach { key, value -> println("Key: $key -> Value: $value") }          // Key: 18 -> Value: Day \nKey: 2 -> Value: Month \nKey: 2003 -> Value: Year

    // check contains
    println("Contains key = 18: ${mutableMapTest.containsKey(18)}")                         // true
    println("Contains value = Year: ${mutableMapTest.containsValue("Year")}")               // true

    // mapValues, mapKeys
    println("Map after mapValues: ${mutableMapTest.mapValues { it.value.uppercase() }}")    // {18=DAY, 2=MONTH, 2003=YEAR}
    println("Map after mapKeys: ${mutableMapTest.mapKeys { it.key * 10 }}")                 // {180=Day, 20=Month, 20030=Year}

    // replace
    mutableMapTest.replace(18, "Day Replace")
    println("Mutable Map after replace key=30: $mutableMapTest")                            // {18=Day Replace, 2=Month, 2003=Year}

    // keys , values , entries
    println("Keys: ${mutableMapTest.keys}")       // [18, 2, 2003]
    println("Values: ${mutableMapTest.values}")   // [Day Replace, Month, Year]
    println("Entries: ${mutableMapTest.entries}") // [18=Day Replace, 2=Month, 2003=Year]

    // remove
    mutableMapTest.remove(18)
    println("Mutable Map after remove key=18: $mutableMapTest") // {2=Month, 2003=Year}

    mutableMapTest.clear()
    println("Mutable Map after clear: $mutableMapTest")         // {}
}


fun main() {
    syntaxArray()
    syntaxList()
    syntaxSet()
    syntaxMap()
}

