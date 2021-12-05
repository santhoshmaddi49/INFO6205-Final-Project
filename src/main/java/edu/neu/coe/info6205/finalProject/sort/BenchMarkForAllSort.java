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

    static void runBenchmark(String description, Consumer<String[]> fun, Supplier<String[]> supplier, int m){

        Benchmark<String[]> benchmark = new Benchmark_Timer<>(description, fun);
        double time = benchmark.runFromSupplier(supplier,m);
        System.out.println(description +": " + time + "ms");

    }

    public static void main(String[] args) {
        
        DualPivotQuickSort dp = new DualPivotQuickSort(new TeluguComparator());
        String description = "Benchmark of dual pivot quick sort with 1 million random order telugu words";
        runBenchmark(description,dp::dualPivotQuickSort,BenchMarkForAllSort::teluguWordsFromFile,5);
        //performBenchmark("dual pivot sort for chinese words", dp::dualPivotQuickSort,BenchMarkForAllSort::chineseWordsFromFile,1);

        DualPivotQuickSort dpChinese = new DualPivotQuickSort(new ChineseComparator());
        String descr = "Benchmark of dual pivot quick sort with 1 million random order chinese words";
        runBenchmark(descr, dpChinese::dualPivotQuickSort, BenchMarkForAllSort:: chineseWordsFromFile, 5);

        TimSort tm = new TimSort(new ChineseComparator());
        String descriptionTim = "Benchmark of Tim sort with 1 million random order chinese words";
        runBenchmark(descriptionTim,tm::sort,BenchMarkForAllSort::chineseWordsFromFile,5);


        TimSort tmTelugu = new TimSort(new TeluguComparator());
        String descriptionTimTelugu = "Benchmark of Tim sort with 1 million random order chinese words";
        runBenchmark(descriptionTimTelugu,tmTelugu::sort,BenchMarkForAllSort::teluguWordsFromFile,5);


        String descrTelugu = "Benchmark of MSD Radix sort with 1 million random order telugu words";
        runBenchmark(descrTelugu,MSDRadixSort::sort,BenchMarkForAllSort::teluguWordsFromFile,5);

        String descrChineseMSD = "Benchmark of MSD Radix sort with 1 million random order telugu words";
        runBenchmark(descrChineseMSD,MSDRadixSortChinese::sort,BenchMarkForAllSort::chineseWordsFromFile,5);

        LSDRadixSort lsdTelugu = new LSDRadixSort();
        String descrTeluguLsd = "Benchmark of LSD Radix sort with 1 million random order telugu words";
        runBenchmark(descrTeluguLsd, lsdTelugu::sort,BenchMarkForAllSort::teluguWordsFromFile,5);

        LSDRadixSortChinese lsdRadixSortChinese = new LSDRadixSortChinese();
        String descrLSDChinese = "Benchmark of LSD Radix sort with 1 million random order chinese words";
        runBenchmark(descrLSDChinese, lsdRadixSortChinese::sort,BenchMarkForAllSort::chineseWordsFromFile,5);










    }
}
