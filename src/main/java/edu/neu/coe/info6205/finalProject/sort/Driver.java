package edu.neu.coe.info6205.finalProject.sort;


import edu.neu.coe.info6205.finalProject.util.ChineseComparator;
import edu.neu.coe.info6205.finalProject.util.FileUtil;
import edu.neu.coe.info6205.finalProject.util.PinyinComparator;
import edu.neu.coe.info6205.finalProject.util.TeluguComparator;
import edu.neu.coe.huskySort.sort.huskySort.PureHuskySort;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskyCoderFactory;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class Driver {

    public static boolean isTeluguWorld(String word)
    {
        String newWord = word.strip();
        if(newWord.length() == 0) return false;
        for(int i = 0;i<newWord.length();i++)
        {
            if(newWord.charAt(i)<3072 || newWord.charAt(i)>3199)
                return false;
        }

        return true;
    }

    public static String[] readWordsFromFile(String path)
    {

        FileUtil fileUtil = new FileUtil();
        List<String> wordsList = fileUtil.readFile(path);
        String[] words = new String[wordsList.size()];
        words = wordsList.toArray(words);
        return words;

    }

    public static void findMismatches(String[] words1, String[] words2)
    {
        int c;
        c = 0;
        for(int i = 0; i<words1.length;i++)
        {
            if(words1[i] != words2[i])
                c++;
        }
        System.out.println(c + " Mismatches");
    }

    public static void runTeluguTimSort(String[] teluguWords, boolean writeToFile)
    {

        long start, end;
        start = System.currentTimeMillis();
        TimSort ts = new TimSort(new TeluguComparator());
        ts.sort(teluguWords);
        end = System.currentTimeMillis();
        System.out.println("tim sort telugu" + (end - start) + "ms");
        if(writeToFile)
        {
            FileUtil fileUtil = new FileUtil();
            fileUtil.writeToFile(Arrays.asList(teluguWords),"./csvFiles/timSortedTelugu.csv");
        }

    }

    public static void runTeluguMsdSort(String[] teluguWords, boolean writeToFile)
    {

        long start, end;
        start = System.currentTimeMillis();
        MSDRadixSort.sort(teluguWords);
        end = System.currentTimeMillis();
        System.out.println("Msd telugu" + (end - start) + "ms");
        if(writeToFile)
        {
            FileUtil fileUtil = new FileUtil();
            fileUtil.writeToFile(Arrays.asList(teluguWords),"./csvFiles/msdSortedTelugu.csv");
        }



    }

    public static void runTeluguLsdSort(String[] teluguWords, boolean writeToFile)
    {

        long start, end;
        start = System.currentTimeMillis();
        LSDRadixSort lsdSort = new LSDRadixSort();
        lsdSort.sort(teluguWords);
        end = System.currentTimeMillis();
        System.out.println("lsd telugu" + (end - start) + "ms");

        if(writeToFile)
        {
            FileUtil fileUtil = new FileUtil();
            fileUtil.writeToFile(Arrays.asList(teluguWords),"./csvFiles/lsdSortedTelugu.csv");
        }

    }


    public static void runTeluguDualPivotSort(String[] teluguWords, boolean writeToFile)
    {

        long start, end;
        start = System.currentTimeMillis();
        DualPivotQuickSort dualPivotQuickSort = new DualPivotQuickSort(new TeluguComparator());
        dualPivotQuickSort.dualPivotQuickSort(teluguWords);
        end = System.currentTimeMillis();
        System.out.println("dual pivot telugu" + (end - start) + "ms");
        if(writeToFile)
        {
            FileUtil fileUtil = new FileUtil();
            fileUtil.writeToFile(Arrays.asList(teluguWords),"./csvFiles/dualPivotSortedTelugu.csv");
        }

    }

    public static void runTeluguHuskySort(String[] teluguWords, boolean writeToFile)
    {

        long start, end;
        start = System.currentTimeMillis();
        PureHuskySort<String> pureHuskyTelugu = new PureHuskySort<>(HuskyCoderFactory.asciiCoder, false, false);
        pureHuskyTelugu.sort(teluguWords);
        end = System.currentTimeMillis();
        System.out.println("Husky telugu" + (end - start) + "ms");
        if(writeToFile)
        {
            FileUtil fileUtil = new FileUtil();
            fileUtil.writeToFile(Arrays.asList(teluguWords),"./csvFiles/huskySortedTelugu.csv");
        }


    }

    public static void runChineseTimSort(String[] chineseWords, boolean writeToFile)
    {

        long start, end;
        start = System.currentTimeMillis();
        TimSort ts = new TimSort(new ChineseComparator());
        ts.sort(chineseWords);
        end = System.currentTimeMillis();
        System.out.println("Tim sort chinese: " + (end - start) + "ms");
        if(writeToFile)
        {
            FileUtil fileUtil = new FileUtil();
            fileUtil.writeToFile(Arrays.asList(chineseWords),"./csvFiles/timSortedChinese.csv");
        }

    }

    public static void runChineseMsdSort(String[] chineseWords, boolean writeToFile)
    {

        long start, end;
        start = System.currentTimeMillis();
        MSDRadixSortChinese.sort(chineseWords);
        end = System.currentTimeMillis();
        System.out.println("MSD sort for chinese" + (end - start) + "ms");
        if(writeToFile)
        {
            FileUtil fileUtil = new FileUtil();
            fileUtil.writeToFile(Arrays.asList(chineseWords),"./csvFiles/msdSortedChinese.csv");
        }

    }

    public static void runChineseLsdSort(String[] chineseWords, boolean writeToFile)
    {

        long start, end;
        start = System.currentTimeMillis();
        LSDRadixSortChinese lsd = new LSDRadixSortChinese();
        lsd.sort(chineseWords);
         end = System.currentTimeMillis();
        System.out.println("LSD chinese: " + (end - start) + "ms");
        if(writeToFile)
        {
            FileUtil fileUtil = new FileUtil();
            fileUtil.writeToFile(Arrays.asList(chineseWords),"./csvFiles/lsdSortedChinese.csv");
        }

    }


    public static void runChineseDualPivotSort(String[] chineseWords, boolean writeToFile)
    {

        long start, end;
        start = System.currentTimeMillis();
        DualPivotQuickSort dualPivotQuickSort = new DualPivotQuickSort(new ChineseComparator());
        dualPivotQuickSort.dualPivotQuickSort(chineseWords);
        end = System.currentTimeMillis();
        System.out.println("dual pivot chinese" + (end - start) + "ms");
        if(writeToFile)
        {
            FileUtil fileUtil = new FileUtil();
            fileUtil.writeToFile(Arrays.asList(chineseWords),"./csvFiles/dualPivotSortedChinese.csv");
        }

    }

    public static void runChineseHuskySort(String[] chineseWords, boolean writeToFile)
    {

        long start, end;
        start = System.currentTimeMillis();
        PureHuskySort<String> pureHusky = new PureHuskySort<>(HuskyCoderFactory.chineseEncoder, false, false);
        pureHusky.sort(chineseWords);
        end = System.currentTimeMillis();
        System.out.println("Husky chinese " + (end - start) + "ms");
        if(writeToFile)
        {
            FileUtil fileUtil = new FileUtil();
            fileUtil.writeToFile(Arrays.asList(chineseWords),"./csvFiles/huskySortedChinese.csv");
        }

    }


    public static void main(String[] args)
    {

        String teluguFilePath = "./csvFiles/TeluguWordsNew.csv";
        String[] teluguWords = readWordsFromFile(teluguFilePath);
        String[] teluguWords1 = readWordsFromFile(teluguFilePath);
        String[] teluguWords2 = readWordsFromFile(teluguFilePath);
        String[] teluguWords3 = readWordsFromFile(teluguFilePath);
        String[] teluguWords4 = readWordsFromFile(teluguFilePath);
        Collections.reverse(Arrays.asList(teluguWords3));
        Collections.reverse(Arrays.asList(teluguWords1));

        String shuffledChineseFilePath = "./csvFiles/shuffledChinese.txt";
        //String shuffledChineseFilePath = "./csvFiles/sampleChineseShuffled.txt";
        String[] chineseWords = readWordsFromFile(shuffledChineseFilePath);
        String[] chineseWords1 = readWordsFromFile(shuffledChineseFilePath);
        String[] chineseWords2 = readWordsFromFile(shuffledChineseFilePath);
        String[] chineseWords3 = readWordsFromFile(shuffledChineseFilePath);
        String[] chineseWords4 = readWordsFromFile(shuffledChineseFilePath);
        Collections.reverse(Arrays.asList(chineseWords1));
        Collections.reverse(Arrays.asList(chineseWords3));

        String sortedChineseFilePath = "./csvFiles/sortedChinese.txt";
        //String sortedChineseFilePath = "./csvFiles/sampleChinesesorted.txt";
        String[] sortedChineseWords = readWordsFromFile(sortedChineseFilePath);

        findMismatches(chineseWords1,chineseWords);

        //Timsort Chinese
        runChineseTimSort(chineseWords,false);

       //Dual Pivot chinese
        runChineseDualPivotSort(chineseWords1,false);

        //Lsd chinese
        runChineseLsdSort(chineseWords2,false);

        //msd Chinese
        runChineseMsdSort(chineseWords3,false);

        //husky sort
        runChineseHuskySort(chineseWords4,false);



        //Timsort telugu
        runTeluguTimSort(teluguWords,false);

        //Msd Telugu
        runTeluguMsdSort(teluguWords1,false);

        // LSD Telugu
        runTeluguLsdSort(teluguWords2,false);

        //Dual pivot
        runTeluguLsdSort(teluguWords3,false);

        //Husky Telugu
        runTeluguLsdSort(teluguWords4,false);


    }

}
