package edu.neu.coe.info6205.finalProject.sort;

import java.util.Arrays;
import java.util.Comparator;

public class TimSort<T> {

     public void sort(T[] words, int from , int to, Comparator<? super T> cmp)
    {
        Arrays.sort(words,from,to,cmp);
    }
}
