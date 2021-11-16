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
