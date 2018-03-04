package com.ex1;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type re of number:");
        double re = scanner.nextDouble();

        System.out.println("Type im of number:");
        double im = scanner.nextDouble();

        Complex x = new Complex(im, re);
        System.out.println("Your number is:");
        x.print();
        int listSize = 10;
        Random randomGen = new Random();
        Complex[] arrayOfX = randomGen.doubles(listSize).mapToObj(i -> new Complex(i, randomGen.nextDouble())).toArray(Complex[]::new);

        System.out.println("Random array:");
        for(Complex i : arrayOfX) {
            i.print();
        }

        System.out.println("Random array:");

    }
}
