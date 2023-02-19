package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 1.Реализовать алгоритм сортировки слиянием
 *
 */
public class task01 {
    public static void main(String[] args) {
        List<Integer> arl = new ArrayList<Integer>();
        intListRandomFilling(arl, 10); // List rnd Creating
        System.out.println(arl);
        arl = mergeSorting(arl);
        System.out.println(arl);
    }

    public static List<Integer> mergeSorting(List<Integer> arr) {
        if (arr.size() == 1) {
            return arr;
        }
        int midIndex = arr.size() / 2;
        List<Integer> arrSubLeft = new ArrayList<>(arr.subList(0, midIndex));
        List<Integer> arrSubRight = new ArrayList<>(arr.subList(midIndex, arr.size()));
        arrSubLeft = mergeSorting(arrSubLeft);

        arrSubRight = mergeSorting(arrSubRight);

        int leftArrIndex = 0;
        int rightArrIndex = 0;

        while (leftArrIndex < arrSubLeft.size() && rightArrIndex < arrSubRight.size()) {

            if (arrSubLeft.get(leftArrIndex) < arrSubRight.get(rightArrIndex)) {
                arr.set(leftArrIndex + rightArrIndex, arrSubLeft.get(leftArrIndex));

                leftArrIndex++;
            } else {
                arr.set(leftArrIndex + rightArrIndex, arrSubRight.get(rightArrIndex));

                rightArrIndex++;
            }

        }
        if (leftArrIndex < arrSubLeft.size()) {

            for (int i = leftArrIndex; i < arrSubLeft.size(); i++) {
                arr.set(leftArrIndex + rightArrIndex, arrSubLeft.get(i));
                leftArrIndex++;
            }
        } else {

            for (int i = rightArrIndex; i < arrSubRight.size(); i++) {
                arr.set(leftArrIndex + rightArrIndex, arrSubRight.get(i));
                leftArrIndex++;
            }
        }

        return arr;
    }

    public static void arrMerge(List<Integer> arrLeft, List<Integer> arrRight) {

    }

    public static void intListRandomFilling(List<Integer> arr, int size) {
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            arr.add(rnd.nextInt(100));
        }

    }
}
