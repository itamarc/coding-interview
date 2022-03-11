package io.github.itamarc;

import java.util.Arrays;

public class GenericCodingProblems {
    public static void main(String[] args) {
        // testTask();
        task1(); // 77% 7/9
        task2(); // 100%
        task3(); // 40% 4/10 + 0/6
    }

    private static void task3() {
        int[] arr1 = {5, 19, 8, 1};
        System.out.println(solution3(arr1) + " " + Arrays.toString(arr1));
        int[] arr2 = {10, 10};
        System.out.println(solution3(arr2) + " " + Arrays.toString(arr2));
        int[] arr3 = {3, 0, 5};
        System.out.println(solution3(arr3) + " " + Arrays.toString(arr3));
        int[] arr4 = {0, 0};
        System.out.println(solution3(arr4) + " " + Arrays.toString(arr4));
        int[] arr5 = {0, 10};
        System.out.println(solution3(arr5) + " " + Arrays.toString(arr5));
        int[] arr6 = {0};
        System.out.println(solution3(arr6) + " " + Arrays.toString(arr6));
        int[] arr7 = {100};
        System.out.println(solution3(arr7) + " " + Arrays.toString(arr7));
        int[] arr8 = {10, 10, 10, 10, 10};
        System.out.println(solution3(arr8) + " " + Arrays.toString(arr8));
    }

    public static int solution3(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        Arrays.sort(arr);
        float[] F = new float[arr.length];
        for (int i = 0; i < F.length; i++) {
            F[i] = arr[i];
        }
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        if (total == 0) {
            return 0;
        }
        int filters = 0;
        float filtered = total;
        int currind = arr.length-1;
        while (filtered > (((float)total) / 2)) {
            if (currind <= 0 || F[currind]/2 < F[currind-1]/2) {
                currind--;
            }
            F[currind] = F[currind]/2;
            filtered -= F[currind];
            filters++;
        }
        return filters;
    }

    private static void task2() {
        int[] f1 = {1, 4, 1};
        int[] c1 = {1, 5, 1};
        System.out.println(solution2(f1, c1));
        int[] f2 = {4, 4, 2, 4};
        int[] c2 = {5, 5, 2, 5};
        System.out.println(solution2(f2, c2));
        int[] f3 = {2, 3, 4, 2};
        int[] c3 = {2, 5, 7, 2};
        System.out.println(solution2(f3, c3));
    }

    public static int solution2(int[] f, int[] c) {
        Arrays.sort(c);
        int friends = 0;
        for (int i = 0; i < f.length; i++) {
            friends += f[i];
        }
        int result = 0;
        while (friends > 0) {
            friends -= c[c.length - result - 1];
            result++;
        }
        return result;
    }

    private static void testTask() {
        int[] arr = {3, 1, 2, 4, 3};
        System.out.println(solutionTest(arr));
    }

    private static int solutionTest(int[] arr) {
        int solution = 1;
        Arrays.sort(arr);
        int currind = 0;
        for (int i = 1; i < 100000; i++) {
            while (currind < arr.length && i != arr[currind]) {
                currind++;
            }
            if (currind == arr.length) {
                solution = i;
                break;
            }
        }
        return solution;
    }

    private static void task1() {
        //                                  01234567890123456789012
        System.out.println("[" + solution1("Selected as best rovers", 5) + "]");
        System.out.println("[" + solution1("Selected as best rovers", 10) + "]");
        System.out.println("[" + solution1("Selected as best rovers", 11) + "]");
        System.out.println("[" + solution1("Selected as best rovers", 14) + "]");
        System.out.println("[" + solution1("Selected as best rovers", 21) + "]");
        System.out.println("[" + solution1("Selected as best rovers", 22) + "]");
        System.out.println("[" + solution1("Selected as best rovers", 23) + "]");
        System.out.println("[" + solution1("Selected as best rovers", 24) + "]");
        System.out.println("[" + solution1("Selected as best rovers", 0) + "]");
        System.out.println("[" + solution1("", 24) + "]");
    }

    private static String solution1(String str, int x) {
    System.out.print(x + " " + str.length() + " ");
        int lastCharInd = x+1;
        if (str.length() <= x) {
            System.out.println("case1");
            return str;
        } else if (str.charAt(x) == ' ') {
            System.out.println("case2");
            lastCharInd = x;
        } else if (str.length() > x+1 && str.charAt(x+1) == ' ') {
            System.out.println("case3");
            lastCharInd = x+1;
        } else {
            System.out.println("case4");
            int i=x;
            while (i >= 0 && str.charAt(i) != ' ') {
                i--;
            }
            if (i > 0) {
                lastCharInd = i;
            } else {
                lastCharInd = 0;
            }
        }
        return str.substring(0, lastCharInd);
    }
}
