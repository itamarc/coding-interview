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
