package io.github.itamarc.dynamic;

import java.util.Arrays;

public class FlowerBox {
    public static void main(String[] args) {
        int[] vals = {3, 10, 3, 1, 2};
        System.out.println("flowerbox("+Arrays.toString(vals)+")="+flowerbox(vals));
        int[] vals2 = {9, 10, 9};
        System.out.println("flowerbox("+Arrays.toString(vals2)+")="+flowerbox(vals2));
    }
    public static int flowerbox(int[] nutrientValues) {
        int a = 0;
        int b = 0;
        for (int val : nutrientValues) {
            int tmp = b;
            b = Integer.max(a + val, b);
            a = tmp;
        }
        return b;
    }
}
