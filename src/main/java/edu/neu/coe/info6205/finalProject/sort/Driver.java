package edu.neu.coe.info6205.finalProject.sort;

import edu.neu.coe.info6205.finalProject.benchMark.Benchmark;
import edu.neu.coe.info6205.finalProject.benchMark.Benchmark_Timer;
import edu.neu.coe.info6205.finalProject.util.FileUtil;

import java.text.Collator;
import java.util.*;

public class Driver {


    public static void main(String[] args)
    {

        FileUtil fileUtil = new FileUtil();

        String teluguFilePath = "./csvFiles/TeluguWords.csv";
        List<String> teluguWordsList = fileUtil.readFile(teluguFilePath);
        String[] teluguWords = new String[teluguWordsList.size()];
        teluguWords = teluguWordsList.toArray(teluguWords);

        String shuffledChineseFilePath = "./csvFiles/shuffledChinese.txt";
        //String shuffledChineseFilePath = "./csvFiles/sampleChineseShuffled.txt";
        List<String> shuffledChinesewordsList = fileUtil.readFile(shuffledChineseFilePath);
        String[] chineseWords = new String[shuffledChinesewordsList.size()];
        chineseWords = shuffledChinesewordsList.toArray(chineseWords);

        String sortedChineseFilePath = "./csvFiles/sortedChinese.txt";
        //String sortedChineseFilePath = "./csvFiles/sampleChinesesorted.txt";
        List<String> sortedChinesewordsList = fileUtil.readFile(sortedChineseFilePath);
        String[] sortedChineseWords = new String[sortedChinesewordsList.size()];
        sortedChineseWords = sortedChinesewordsList.toArray(sortedChineseWords);

        //msd
        MSDRadixSortChinese.sort(chineseWords);

        //LSD
//        LSDRadixSort lsdSort = new LSDRadixSort();
//        lsdSort.sort(teluguWords);


        Comparator<String> cmpTelugu = (s1,s2) -> {
            Collator collator = Collator.getInstance(new Locale("te_IN"));
            return collator.compare(s1, s2);
        };
        Comparator<String> cmpChinese = (s1,s2) -> {
            Collator collator = Collator.getInstance(Locale.CHINESE);
            return collator.compare(s1, s2);
        };
        //Tim
//        Arrays.sort(teluguWords , cmpTelugu);
        //Arrays.sort(chineseWords , cmpChinese);


        //Dual pivot
        DualPivotQuickSort dualPivotQuickSort = new DualPivotQuickSort(cmpTelugu);
        //dualPivotQuickSort.dualPivotQuickSort(teluguWords);

        //print
//        System.out.println("---------------------------------------------");
//        for(String word: chineseWords)
//        {
//            System.out.println(word);
//        }

        int c = 0;
        for (int i = 0; i < chineseWords.length; i++) {
            if (!chineseWords[i].equals(sortedChineseWords[i])) {
                //System.out.println(chineseWords[i] + "    "+ sortedChineseWords[i]);
                c++;
            }
        }

        System.out.println(c + " " + chineseWords.length);


//        Locale[] listLocales = Locale.getAvailableLocales();
//        List<String> listInstalledLanguages = new ArrayList<String>();
//        for(int i=0; i<listLocales.length; i++) {
//            String language = listLocales[i].getDisplayLanguage();
//            if(language.equalsIgnoreCase("telugu"))
//            {
//                System.out.println(listLocales[i]);
//            }
//
//
//            Log.i(TAG, "Language : "+language);
//            if (language.equals("English") && !listInstalledLanguages.contains("English"))
//                listInstalledLanguages.add(language);
//
//            if (language.equals("Hindi") && !listInstalledLanguages.contains("Hindi"))
//                listInstalledLanguages.add(language);
//
//            if (language.equals("Kannada") && !listInstalledLanguages.contains("Kannada"))
//                listInstalledLanguages.add(language);
//        }

    }

}
