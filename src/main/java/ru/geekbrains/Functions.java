package ru.geekbrains;

import java.util.Scanner;

/**
 * Formula Gerona
 */
public class Functions {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int sideA = 0;
    private static int sideB = 0;
    private static int sideC = 0;
    private static final String colGreen = "\u001B[32m";
    private static final String colRed = "\u001B[31m";
    private static final String colNo = "\u001B[0m";


    // human turn
    public static void dataInput() {
        do {
            System.out.print("Введите значения (целые числа) 3-х сторон треугольника через пробел >>> ");
            sideA = SCANNER.nextInt();
            sideB = SCANNER.nextInt();
            sideC = SCANNER.nextInt();
        } while (!isValidSide(sideA, sideB, sideC));
    }

    // check valid side
    public static boolean isValidSide(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println(colRed + "Любая из сторон треугольника не может быть меньше или равной 0" + colNo);
            return false;
        }
        if ((a + b) <= c || (b + c) <= a || (a + c) <= b) {
            System.out.println(colRed + "Сумма длин 2-х сторон треугольника не может быть меньше или равной длине оставшейся стороны" + colNo);
            return false;
        }
        return true;
    }

    public static double areaTriangle(int sideA, int sideB, int sideC) {
        double p;
        p = 0.5 * ((double) sideA + (double) sideB + (double) sideC);
        return Math.sqrt(p * (p - (double) sideA) * (p - (double) sideB) * (p - (double) sideC));
    }

    public static void main(String[] args) {
        dataInput();
        System.out.println(colGreen + "S = " + areaTriangle(sideA, sideB, sideC) + colNo);
    }
}
