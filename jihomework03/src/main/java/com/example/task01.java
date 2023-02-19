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
        arrMerge(arr, arrSubLeft, arrSubRight);
        return arr;
    }

    public static void arrMerge(List<Integer> arrMain, List<Integer> arrLeft, List<Integer> arrRight) {
        /*
         * Merging two subarrays
         */
        int leftArrIndex = 0;
        int rightArrIndex = 0;

        while (leftArrIndex < arrLeft.size() && rightArrIndex < arrRight.size()) {
            /*
             * Проходим по подмассивам до тех пор, пока элементы из один из них не будут полностью
             * перенесены в основной массив 
             */
            if (arrLeft.get(leftArrIndex) < arrRight.get(rightArrIndex)) {
                /*
                 * В основной массив переносится меньший из двух рассматриваемых
                 * (один - из левого и один - из правого подмассивов)
                 */
                arrMain.set(leftArrIndex + rightArrIndex, arrLeft.get(leftArrIndex));
                leftArrIndex++;
            } else {
                arrMain.set(leftArrIndex + rightArrIndex, arrRight.get(rightArrIndex));
                rightArrIndex++;
            }
        }
        if (leftArrIndex < arrLeft.size()) {
            /*
             * Когда один из подмассивов закончился, элементы, которые остались не перенесёнными
             * (из второго подмассива) полностью переносятся в конец основного массива 
             */
            for (int i = leftArrIndex; i < arrLeft.size(); i++) {
                arrMain.set(leftArrIndex + rightArrIndex, arrLeft.get(i));
                leftArrIndex++;
            }
        } else {
            for (int i = rightArrIndex; i < arrRight.size(); i++) {
                arrMain.set(leftArrIndex + rightArrIndex, arrRight.get(i));
                leftArrIndex++;
            }
        }
    }

    public static void intListRandomFilling(List<Integer> arr, int size) {
        /*
         * Заполнение массива случайными целыми
         */
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            arr.add(rnd.nextInt(100));
        }

    }
}
