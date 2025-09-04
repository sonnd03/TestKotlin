package com.example.test.tasks.task1.tasks.task2

import com.example.test.tasks.task2.message
import com.example.test.tasks.task2.name
import java.util.concurrent.atomic.LongAdder
import javax.annotation.processing.Messager

// Class
    /// Class no value
    class Person1 {
        var name = ""
        var age = 18
    }

    /// class constructor
    class User(var name: String, var age: String = "12") {
        //// constructor primary
        init {
            print("primary constructor called")
            print(name + age)
        }

        //// constructor secondary
        constructor(address: Int, age: String) : this("Nguyendacson", age) {
            print("secondary constructor called $name $age")

        }
    }

    /// open class
    open class Base(
        //// Encapsulation Đóng gói
        //// default no notify => public +> global
        //// private only use class
        //// protected use class and class inheritance
        //// iternal use on file
        private var name: String,
        var age: String
    ) {
        open fun getData() = print("name: $name, age: $age ")
        open fun getDataName(value: String) = print("value is $value")
    }

    /// Inheritance kế thừa
    class Inheritance(
        name: String,
        age: String,
        var address: String,
        var sex: String
    ) : Base(name, age) {
        override fun getData() {
            print("$address ")
        }

        override fun getDataName(value: String) {
            super.getDataName(sex)
        }
    }

    /// Abstract Trừu tượng
    abstract class Abstract(
        name: String,
        age: String,
    ) : Base(name, age) {
        abstract fun getPrintData(): String
    }
    /// Abstract Trừu tượng
    class getAbstract(
        name: String,
        age: String,
        var add: String
    ) : Abstract(name, age) {
        override fun getPrintData(): String {
            return println(add).toString()
        }
    }

// interface difference Interface and Class
    interface Interface {
        val speed: Int // muốn dùng thì bên class cần overive k có tính sate
        fun fly()
    }

    class Bird(override val speed: Int) : Interface {
        override fun fly() = print("bay cao nao nhay cao nao")
    }


//class User2(var name: String){
//    constructor(name: String) : this(name){
//        print(name)
//    }
//}

//// Class Constructor
//class Person2(val name: String, val age: Int = 18, val sex: String = "")
//

// Object // Singleton
object Status {
    fun print() = print("\nThis is singleton Object")
    var status = "online"
}

class objectOnClass {

    fun getPrint() = print("hehehe")

    //// companion Object
    companion object {
        fun print() = print("\nHello this is Companion Object")
    }
}


enum class Warring {
    ERROR, LOADING, SUCCESS
}

fun handleEnum(status: Warring) {
    when (status) {
        Warring.ERROR -> print("Error")
        Warring.LOADING -> print("Loading")
        Warring.SUCCESS -> print("Success")
    }
}

sealed class Warring1() {
    data class Success(val data: String) : Warring1()
    data class Error(val code: String, val message: String) : Warring1()
    object Loading : Warring1()
}

fun handleEnum1(result: Warring1) {
    when (result) {
        is Warring1.Success -> print("Success : ${result.data}")
        is Warring1.Error -> print("Error: ${result.message}, code: ${result.code}")
        Warring1.Loading -> print("Loading")
    }
}


fun main() {
//    val user = Person1()
//    user.name = "Nguyen Dac Son"
//    user.age = 22
//
//    val user1 = Person2("nguyendacson")
//
//    // the equality operator
////    println(user == user1) // flase want to true change class is data class
//
//    // Copy instance
//    val user2 = Person("nguyendacson")
//    val user3 = user2.copy("nguyendacsonCopy")
//
//    // Object
//    val object1 = Status
//    object1.status = "offline"
//    println(object1.status)

    //Companion object

//    val user4 = User("nguyenDacson","12")
//    val user5 = User(name = "nguyendacson", age = "12", address = "canhhung")
//    user4.print()
//    print(user5)

//// kế thừa, đa hình, đóng gói, trừu tượng,
//    val listData = mutableListOf<Base>() // chứa cả các Base và Inheritance
//    val listBase = Base("nguyen dac son","22")
//    val listBase1 = Base("nguyen dac son","22")
//    val inheritance : Inheritance
//    val list = Inheritance("nguyendacson","12","canhhung","male")
//    val list1 = Inheritance("nguyendacson","14","phattich","male")
//    listData.add(listBase)
//    listData.add(listBase1)
//    listData.add(list)
//    listData.add(list1)
//
//    listBase.age = "1232"
//
//    // Polymorphism Đa hình
//    // if Base and Inheritance exited data => call get.data on Base and on Inheritance,
//    listData.forEach { it.getData() }
//
//    val abstract = getAbstract("son","hai muoi","adđthem")
//    abstract.getPrintData()

//    handleEnum1(Warring1.Error("400", "Bad Request"))
//    print("\n")
//    handleEnum(Warring.ERROR)

    // Companion Object
    //// deference between Object and Companion Object is two can use which not necessary create new and Object Singleton will run recent Modul run
    val getObjectClass = objectOnClass()
    getObjectClass.getPrint()
    objectOnClass.print()
    Status.print()


}