package com.example.test.tasks.task1

import java.util.Scanner

open class Product(
    var name: String,
    var publisher: String
){
    open fun input(scanner: Scanner){
        println("input name product: ");
        name = scanner.nextLine();
        println("input publisher product: ");
        publisher = scanner.nextLine();
    }
    open fun output(){
        println("name product: $name");
        println("publisher product: $publisher");
    }
    open fun payment(): Double = 0.0;
}
