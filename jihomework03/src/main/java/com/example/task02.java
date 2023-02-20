package com.example;

/*
 * 2.Пусть дан произвольный список целых чисел, удалить из него четные числа
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class task02 {
    public static void main(String[] args) {
        List<Integer> arl = new ArrayList<Integer>();
        intListRandomFilling(arl, 20); // List rnd Creating
        System.out.println(arl);
        evenRemoving(arl);
        System.out.println(arl);

    }
    public static void evenRemoving(List <Integer>arr) {
        Iterator <Integer> iter = arr.iterator();
        while (iter.hasNext()) {
            if (iter.next()%2==0) iter.remove();
        }
    }
    public static void intListRandomFilling(List<Integer> arr, int size) {
        // Заполнение массива случайными целыми
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            arr.add(rnd.nextInt(100));
        }

    }
}
