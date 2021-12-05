package edu.neu.coe.info6205.finalProject.sort;

import edu.neu.coe.info6205.finalProject.benchMark.Benchmark;
import edu.neu.coe.info6205.finalProject.benchMark.Benchmark_Timer;
import edu.neu.coe.info6205.finalProject.util.*;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BenchMarkForAllSort {


    public static String[] teluguWordsFromFile(){

        String filePath = "./csvFiles/TeluguWords.csv";
        FileUtil fileUtil = new FileUtil();
        List<String> teluguWordsList = fileUtil.readFile(filePath);
        String[] teluguWords = new String[teluguWordsList.size()];
        teluguWords = teluguWordsList.toArray(teluguWords);
        return teluguWords;

    }

    public static String[] chineseWordsFromFile(){

        String filePath = "./csvFiles/shuffledChinese.txt";
        FileUtil fileUtil = new FileUtil();
        List<String> chineseWordsList = fileUtil.readFile(filePath);
        String[] chineseWords = new String[chineseWordsList.size()];
        chineseWords = chineseWordsList.toArray(chineseWords);
        return chineseWords;

    }

    static void performBenchmark(String description, Consumer<String[]> fun, Supplier<String[]> supplier, int m){

        Benchmark<String[]> benchmark = new Benchmark_Timer<>(description, fun);
        double time = benchmark.runFromSupplier(supplier,m);
        System.out.println(description +": " + time + "ms");

    }

    public static void main(String[] args) {
        
        DualPivotQuickSort dp = new DualPivotQuickSort(new ChineseComparator());
        //performBenchmark("dual pivot sort for chinese words", dp::dualPivotQuickSort,BenchMarkForAllSort::chineseWordsFromFile,1);

        TimSort tm = new TimSort(new ChineseComparator());
        //performBenchmark("Timsort for chinese words", tm::dualPivotQuickSort,BenchMarkForAllSort::chineseWordsFromFile,1);

    }
}
