package edu.neu.coe.info6205.finalProject.sort;

import edu.neu.coe.huskySort.sort.huskySort.PureHuskySort;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskyCoderFactory;
import edu.neu.coe.info6205.finalProject.benchMark.Benchmark;
import edu.neu.coe.info6205.finalProject.benchMark.Benchmark_Timer;
import edu.neu.coe.info6205.finalProject.util.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BenchMarkForAllSort {


    private static int arraySize = 1000000;

    public static String[] randomTeluguWordsFromFile(){

        String filePath = "./csvFiles/TeluguWords.csv";
        FileUtil fileUtil = new FileUtil();
        List<String> teluguWordsList = fileUtil.readFile(filePath);
        int N = teluguWordsList.size();
        String[] teluguWords = new String[arraySize];
        for(int i = 0; i<arraySize;i++)
            teluguWords[i] =teluguWordsList.get(i%N);
        return teluguWords;

    }

    public static String[] sortedTeluguWordsFromFile(){

        String filePath = "./csvFiles/TeluguWords.csv";
        FileUtil fileUtil = new FileUtil();
        List<String> teluguWordsList = fileUtil.readFile(filePath);
        int N = teluguWordsList.size();
        String[] teluguWords = new String[arraySize];
        for(int i = 0; i<arraySize;i++)
            teluguWords[i] =teluguWordsList.get(i%N);
        Arrays.sort(teluguWords);
        return teluguWords;

    }

    public static String[] partiallySortedTeluguWordsFromFile(){

        String filePath = "./csvFiles/TeluguWords.csv";
        FileUtil fileUtil = new FileUtil();
        List<String> teluguWordsList = fileUtil.readFile(filePath);
        int N = teluguWordsList.size();
        String[] teluguWords = new String[arraySize];
        for(int i = 0; i<arraySize;i++)
            teluguWords[i] =teluguWordsList.get(i%N);
        Arrays.sort(teluguWords, 0, arraySize/2);
        return teluguWords;

    }

    public static String[] reverseOrderTeluguWordsFromFile(){

        String filePath = "./csvFiles/TeluguWords.csv";
        FileUtil fileUtil = new FileUtil();
        List<String> teluguWordsList = fileUtil.readFile(filePath);
        int N = teluguWordsList.size();
        String[] teluguWords = new String[arraySize];
        for(int i = 0; i<arraySize;i++)
            teluguWords[i] =teluguWordsList.get(i%N);
        Collections.reverse(Arrays.asList(teluguWords));
        return teluguWords;

    }

    public static String[] randomchineseWordsFromFile(){

        String filePath = "./csvFiles/shuffledChinese.txt";
        FileUtil fileUtil = new FileUtil();
        List<String> chineseWordsList = fileUtil.readFile(filePath);

        int N = chineseWordsList.size();
        String[] chineseWords = new String[arraySize];
        for(int i = 0; i<arraySize;i++)
            chineseWords[i] =chineseWordsList.get(i%N);

        return chineseWords;

    }

    public static String[] sortedChineseWordsFromFile(){

        String filePath = "./csvFiles/shuffledChinese.txt";
        FileUtil fileUtil = new FileUtil();
        List<String> chineseWordsList = fileUtil.readFile(filePath);

        int N = chineseWordsList.size();
        String[] chineseWords = new String[arraySize];
        for(int i = 0; i<arraySize;i++)
            chineseWords[i] =chineseWordsList.get(i%N);
        Arrays.sort(chineseWords, new ChineseComparator() );
        return chineseWords;

    }
    public static String[] partialSortedChineseWordsFromFile(){

        String filePath = "./csvFiles/shuffledChinese.txt";
        FileUtil fileUtil = new FileUtil();
        List<String> chineseWordsList = fileUtil.readFile(filePath);

        int N = chineseWordsList.size();
        String[] chineseWords = new String[arraySize];
        for(int i = 0; i<arraySize;i++)
            chineseWords[i] =chineseWordsList.get(i%N);
        Arrays.sort(chineseWords, 0, arraySize/2, new ChineseComparator());
        return chineseWords;

    }
    public static String[] reverseOrderchineseWordsFromFile(){

        String filePath = "./csvFiles/shuffledChinese.txt";
        FileUtil fileUtil = new FileUtil();
        List<String> chineseWordsList = fileUtil.readFile(filePath);

        int N = chineseWordsList.size();
        String[] chineseWords = new String[arraySize];
        for(int i = 0; i<arraySize;i++)
            chineseWords[i] =chineseWordsList.get(i%N);

        Collections.reverse(Arrays.asList(chineseWords));
        return chineseWords;

    }

    static void runBenchmark(String description, Consumer<String[]> fun, Supplier<String[]> supplier, int m){

        Benchmark<String[]> benchmark = new Benchmark_Timer<>(description, fun);
        double time = benchmark.runFromSupplier(supplier,m);
        System.out.println("Time Taken: " +time + "ms");

    }

    public static void runAllBenchmarksTelugu(String sort, Consumer<String[]> fun, int m){

        String description = "Benchmark for " + sort + " sort for " + arraySize + " random order telugu elements";
        runBenchmark(description,fun,BenchMarkForAllSort::randomTeluguWordsFromFile,m);

        description = "Benchmark for " + sort + " sort for " + arraySize + " sorted order telugu elements";
        runBenchmark(description,fun,BenchMarkForAllSort::sortedTeluguWordsFromFile,m);

        description = "Benchmark for " + sort + " sort for " + arraySize  + " partial sorted order telugu elements";
        runBenchmark(description,fun,BenchMarkForAllSort::partialSortedChineseWordsFromFile,m);

        description = "Benchmark for " + sort + " sort for " + arraySize  + " reverse order telugu elements";
        runBenchmark(description,fun,BenchMarkForAllSort::reverseOrderTeluguWordsFromFile,m);

    }

    public static void runAllBenchmarksChinese(String sort, Consumer<String[]> fun, int m){

        String description = "Benchmark for " + sort + " sort for " + arraySize + " random order chinese elements";
        runBenchmark(description,fun,BenchMarkForAllSort::randomchineseWordsFromFile,m);

        description = "Benchmark for " + sort + " sort for " + arraySize + " sorted order chinese elements";
        runBenchmark(description,fun,BenchMarkForAllSort::sortedChineseWordsFromFile,m);

        description = "Benchmark for " + sort + " sort for " + arraySize + " partial sorted order chinese elements";
        runBenchmark(description,fun,BenchMarkForAllSort::partialSortedChineseWordsFromFile,m);

        description = "Benchmark for " + sort + " sort for " + arraySize + " reverse order chinese elements";
        runBenchmark(description,fun,BenchMarkForAllSort::reverseOrderchineseWordsFromFile,m);

    }

    public static void main(String[] args) {


        // Msd Sort for Telugu strings
        runAllBenchmarksTelugu("Msd radix",MSDRadixSort::sort,5);

        // Lsd Sort for Telugu strings
        LSDRadixSort lsdRadixSort = new LSDRadixSort();
        runAllBenchmarksTelugu("Lsd radix",lsdRadixSort::sort,5);

        // Tim Sort for Telugu strings
        TimSort timSort = new TimSort(new TeluguComparator());
        runAllBenchmarksTelugu("Tim",timSort::sort,5);

        // Husky sort for Telugu
        PureHuskySort<String> pureHuskyTelugu = new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false);
        runAllBenchmarksTelugu("Husky",pureHuskyTelugu::sort,5);

        // Dual pivot quick Sort for Telugu strings
        DualPivotQuickSort dualPivot = new DualPivotQuickSort(new TeluguComparator());
        runAllBenchmarksTelugu("Dual pivot quick",dualPivot::dualPivotQuickSort,5);


        // Msd Sort for Chinese strings
        runAllBenchmarksChinese("Msd radix",MSDRadixSortChinese::sort,5);

        // Lsd Sort for Chinese strings
        LSDRadixSortChinese lsdRadixSortChinese = new LSDRadixSortChinese();
        runAllBenchmarksChinese("Lsd radix",lsdRadixSortChinese::sort,5);

        // Tim Sort for Chinese strings
        timSort = new TimSort(new ChineseComparator());
        runAllBenchmarksChinese("Tim",timSort::sort,5);

        // Husky sort for Chinese
        PureHuskySort<String> pureHuskyChinese = new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false);
        runAllBenchmarksChinese("Husky",pureHuskyChinese::sort,5);

        // Dual pivot quick Sort for Chinese strings
        dualPivot = new DualPivotQuickSort(new ChineseComparator());
        runAllBenchmarksChinese("Dual pivot quick",dualPivot::dualPivotQuickSort,5);


    }
}
