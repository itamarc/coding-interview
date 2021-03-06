package io.github.itamarc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numbers {
    public static void main(String[] args) {
        manipListOfLong();
        intDivision();
    }

    private static void intDivision() {
        int a = 0;
        int b = 9;
        int c = (a + b) / 2;
        System.out.println("("+a+" + "+b+") / 2 = "+c);
        // mod
        int d = b % 5;
        System.out.println("mod("+b+", 5)="+d);

        int div = (int)Math.floor((b-1)/2);
        System.out.println("(int)Math.floor(("+b+"-1)/2)="+div);
        System.out.println("Math.floor(("+b+"-1)/2)="+Math.floor((b-1)/2));
    }

    public static void manipListOfLong() {
        List<Long> listOfLong = new ArrayList<Long>();
        listOfLong.add(1324L);
        listOfLong.add(342525234513451234L);
        listOfLong.add(555555555555L);
        Collections.sort(listOfLong);
        for (int i = 0; i < listOfLong.size(); i++) {
            int x = listOfLong.get(i).intValue();
            System.out.println(x);
        }
    }
}
