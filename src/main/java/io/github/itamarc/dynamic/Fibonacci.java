package io.github.itamarc.dynamic;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 40;

        // Brute force
        long startTime = System.currentTimeMillis();
        System.out.println("Fib("+n+")="+brute(n));
        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        // Top-down solution (memoization)
        startTime = System.currentTimeMillis();
        System.out.println("FibTD("+n+")="+topDown(n));
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

        // Bottom-up solution (tabulating)
        startTime = System.currentTimeMillis();
        System.out.println("FibBU("+n+")="+bottomUp(n));
        endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }

    // I'm considering fib(0) = 1 and fib(1) = 1
    public static int brute(int n) {
        if (n <= 1) {
            return 1;
        }
        return brute(n-1) + brute(n-2);
    }

    // NOT thread safe
    private static int[] cache = null;
    public static int topDown(int n) {
        if (n <= 1) {
            return 1;
        }
        int fib = 0;
        if (cache == null) {
            cache = new int[n+1];
            Arrays.fill(cache, -1);
            cache[0] = 1;
            cache[1] = 1;
            if (cache[n] > 0) {
                return cache[n];
            }
            fib = topDown(n-1) + topDown(n-2);
            cache = null;
        } else {
            if (cache[n] > 0) {
                return cache[n];
            }
            fib = topDown(n-1) + topDown(n-2);
            cache[n] = fib;
        }
        return fib;
    }

    public static int bottomUp(int n) {
        int a = 1; // f(n-2)
        int b = 1; // f(n-1)
        for (int i = 2; i < n+1; i++) {
            int tmp = b;
            b = a + b;
            a = tmp;
        }
        return b;
    }
}
