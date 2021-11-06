package io.github.itamarc;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class JavaSyntax {
    public static void main(String[] args) {
        math();
    }
    
    public static  void attribution() {
        String a, b, c;
        a = b = c = "0";
        b += ".";
        c += a;
        System.out.println( "Hello World! " + a + " - " + b + " - " + c);
    }

    public static void iterate() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            int i = iter.next();
            System.out.println(i);
        }
    }

    public static void math() {
        int a = 5;
        int b = 6;
        System.out.println((a + b) / 2);
        System.out.println(((float)a + b) / 2);
        System.out.println(Math.floor(((float)a + b) / 2));
    }
}
