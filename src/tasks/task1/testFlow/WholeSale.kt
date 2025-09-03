package com.example.test.tasks.task1

import java.util.Scanner

class WholeSale(
    name: String,
    publisher: String,
    var priceWholeSale: Double,
    var quantityWholeSale: Int
) : Product(name, publisher) {

    override fun input(scanner: Scanner) {
        super.input(scanner);

        println("input price wholesale: ");
        priceWholeSale = scanner.nextDouble();

        do {
            println("input quantity wholesale: > 100");
            quantityWholeSale = scanner.nextInt();
            if (quantityWholeSale <= 100) println("input quantity wholesale: > 100, re-enter: ");
        }while (quantityWholeSale < 100)
    }

    override fun output() {
        super.output();
        println("price wholesale: $priceWholeSale");
        println("quantity wholesale: $quantityWholeSale");
    }

    override fun payment(): Double = priceWholeSale * quantityWholeSale;
}