package com.example.test.tasks.task1

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`);
    println("input quantity product N: ");
    val n = scanner.nextInt();
    scanner.nextLine();

    val listProduct = mutableListOf<Product>();

    repeat(n){ i ->
        println("\n Input product order: ${i+1}");
        println("Chose type product: (1: retail, 2: wholesale)");
        val type = scanner.nextInt();
        scanner.nextLine();
        val pr: Product = if (type == 1) {
            Retail("", "", 0.0, 0).apply { input(scanner) }
        }else{
            WholeSale("", "", 0.0, 0).apply { input(scanner) }
        }

        listProduct.add(pr);
    }

    println("List Product recent enter: ")
    listProduct.forEach { it.output() }

    val minProduct  = listProduct.minByOrNull { it.payment() }
    println("List Min product:")
    minProduct?.output()
}