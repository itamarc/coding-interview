package io.github.itamarc;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        iterate();
        Regex.findGroup();

        float[] farr = {12F, 1.1F, 10F, -0.4F, 2.2F, 0.3F, 0F, -13F, 3.3F, 0.2F, 11F, 14F, 15F, -4.4F, -0.1F, 5.5F};
        System.out.println("Original array:\n" + Arrays.toString(farr));
        System.out.println("Merge sorted array:\n" + Arrays.toString(Sort.topDownMergeSort(farr)));
    }

    private static  void attribution() {
        String a, b, c;
        a = b = c = "0";
        b += ".";
        c += a;
        System.out.println( "Hello World! " + a + " - " + b + " - " + c);
    }

    private static void iterate() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            int i = iter.next();
            System.out.println(i);
        }
    }
}
