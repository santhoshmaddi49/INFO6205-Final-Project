package edu.neu.coe.info6205.finalProject.sort;

import java.util.Arrays;
import java.util.Comparator;

public class TimSort {

    private Comparator<String> cmp;
    TimSort(Comparator<String> cmp)
    {
        this.cmp = cmp;
    }
    public void sort(String[] words)
    {
        sort(words,0,words.length);
    }

     public void sort(String[] words, int from , int to)
    {
        Arrays.sort(words,from,to,cmp);
    }
}
