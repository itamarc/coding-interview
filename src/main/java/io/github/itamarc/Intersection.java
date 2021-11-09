package io.github.itamarc;

import java.util.ArrayList;
import java.util.Arrays;

public class Intersection {
    public static void main(String[] args) {
        int[][] array1 = {{0, 8}, {10, 12}, {14, 15}, {15, 16}, {17, 18}, {18, 24}};
        int[][] array2 = {{0, 10}, {10, 11}, {12, 13}, {15, 16}, {20, 24}};
    
        ArrayList<Integer[]>  array1Compl = calculateComplementaryArray(array1);
        
        ArrayList<Integer[]> array2Compl = calculateComplementaryArray(array1);

        ArrayList<Integer[]> intersection = findInterceptionBetweenArrays(array1Compl, array2Compl);
        System.out.println("Intersection of complementary arrays:");
        intersection.forEach(arr -> System.out.print(Arrays.toString(arr)));
        System.out.println();
    }

    private static ArrayList<Integer[]> calculateComplementaryArray(int[][] array) {
        System.out.println("Original array:\n"+Arrays.deepToString(array));

        ArrayList<Integer[]> complArray = new ArrayList<Integer[]>();
        int ini = 0;
        for (int i = 0; i < array.length; i++) {
            // Check if ini is equals the beginning of the block
            // if is, make ini equals the end of the block
            if (ini == array[i][0]) {
                ini = array[i][1];
            } else if (ini < array[i][0]) { // else, if ini is < than the beginning
                // Create a block from ini to this beginning
                Integer[] block = new Integer[2];
                block[0] = ini;
                block[1] = array[i][0];
                complArray.add(block);
                // and make ini equals the end of the block
                ini = array[i][1];
            }
        }

        System.out.println("Complementary array:");
        complArray.forEach(arr -> System.out.print(Arrays.toString(arr)));
        System.out.println();

        return complArray;
    }

    private static ArrayList<Integer[]> findInterceptionBetweenArrays(ArrayList<Integer[]> array1, ArrayList<Integer[]> array2) {
        ArrayList<Integer[]> intersection = new ArrayList<Integer[]>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < array1.size() && i2 < array2.size()) {
            Integer[] block1 = array1.get(i1);
            Integer[] block2 = array2.get(i2);
            // blocks overlap
            if ((block1[0] > block2[0] && block1[0] < block2[1]) ||
                (block2[0] > block1[0] && block2[0] < block1[1])) {
                Integer[] intersectBlock = new Integer[2];
                intersectBlock[0] = (block1[0] > block2[0] ? block1[0] : block2[0]);
                intersectBlock[1] = (block1[1] < block2[1] ? block1[1] : block2[1]);
                intersection.add(intersectBlock);
                i1++;
                i2++;
            } else {
                if (block1[0] > block2[0]) {
                    i1++;
                } else {
                    i2++;
                }
            }
        }
        return intersection;
    }
}
