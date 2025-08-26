package com.example.test.tasks.task1

import java.util.Scanner

class Retail(
    name: String,
    publisher: String,
    var priceRetail: Double,
    var quantityRetail: Int
) : Product(name, publisher){

    override fun input(scanner: Scanner) {
        super.input(scanner);

        println("input price retail: ");
        priceRetail = scanner.nextDouble();

        do {
            println("input quantity retail: < 10")
            quantityRetail = scanner.nextInt()
            if (quantityRetail > 10) println("input quantity retail: < 10, re-enter: ")
        }while (quantityRetail >= 10);
        scanner.nextLine();
    }

    override fun output() {
        super.output();
        println("price retail: $priceRetail");
        println("quantity retail: $quantityRetail");
    }

    override fun payment(): Double = priceRetail * quantityRetail;
}
