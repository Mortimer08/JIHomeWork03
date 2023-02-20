/*
 * 3.Задан целочисленный список ArrayList.
 * Найти минимальное, максимальное и среднее арифметическое этого списка.
 */
package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class task03 {
    public static void main(String[] args) {
        List<Integer> arl = new ArrayList<Integer>();
        intListRandomFilling(arl, 20); // List rnd Creating
        System.out.println(arl);
        System.out.printf("Максимальное значение в списке: %d%n", getMax(arl));
        System.out.printf("Минимальное значение в списке: %d%n", getMin(arl));
        System.out.printf("Среднее значение списка: %d%n", getAvrerage(arl));
    }

    public static Integer getMax(List<Integer> arr) {
        Integer max = arr.get(0);
        Iterator<Integer> iter = arr.iterator();
        while (iter.hasNext()) {
            int item = iter.next();
            if (item > max)
                max = item;
        }
        return max;
    }

    public static Integer getMin(List<Integer> arr) {
        Integer min = arr.get(0);
        Iterator<Integer> iter = arr.iterator();
        while (iter.hasNext()) {
            int item = iter.next();
            if (item < min)
                min = item;
        }
        return min;
    }

    public static int getAvrerage(List<Integer> arr) {
        int sum = 0;
        Iterator<Integer> iter = arr.iterator();
        while (iter.hasNext()) {
            sum += iter.next();
        }
        return sum / arr.size();
    }

    public static void intListRandomFilling(List<Integer> arr, int size) {
        // Заполнение массива случайными целыми
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            arr.add(rnd.nextInt(100));
        }

    }
}
