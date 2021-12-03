package edu.neu.coe.info6205.finalProject.sort;

import edu.neu.coe.info6205.finalProject.benchMark.Benchmark;
import edu.neu.coe.info6205.finalProject.benchMark.Benchmark_Timer;
import edu.neu.coe.info6205.finalProject.util.FileUtil;

import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
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

    static void performBenchmark(String description, Consumer<String[]> fun, Supplier<String[]> supplier){

        Benchmark<String[]> benchmark = new Benchmark_Timer<>(description, fun);
        double time = benchmark.runFromSupplier(supplier, 10);
        System.out.println(description +": " + time + "ms");

    }

    public static void main(String[] args) {

        //String description = "Benchmark for Msd radix sort";
        //final Benchmark<String[]> msdBenchmark = new Benchmark_Timer<>(description , MSDRadixSort::sort);
//        double time = msdBenchmark.runFromSupplier(BenchMarkForAllSort::teluguWordsFromFile, 10);
//        System.out.println(description +": " + time + "ms");

        Comparator<String> cmpChinese = (s1, s2) -> {
            Collator collator = Collator.getInstance(Locale.CHINESE);
            return collator.compare(s1, s2);
        };
        DualPivotQuickSort dualPivotQuickSort = new DualPivotQuickSort(cmpChinese);

        performBenchmark("Chinese 1 million words", dualPivotQuickSort::dualPivotQuickSort,BenchMarkForAllSort::chineseWordsFromFile);




    }
}
