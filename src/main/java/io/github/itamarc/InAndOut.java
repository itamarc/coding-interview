package io.github.itamarc;

import java.util.Locale;
import java.util.Scanner;

public class InAndOut {
    public static void main(String[] args) {
        test3();
    }

    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        long num = scanner.nextLong();
        scanner.nextLine(); // read the newline character after the number
        System.out.println("Enter a text: ");
        String txt = scanner.nextLine();
        System.out.println("Your inputs:\n" + num + "\n" + txt);
        scanner.close();
    }

    public static void test3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        long num = scanner.nextLong();
        System.out.println("Enter a text: ");
        String txt = scanner.next(); // can only read text until first space
        scanner.close();
        System.out.println("Your inputs:\n" + num + "\n" + txt);
    }
}
