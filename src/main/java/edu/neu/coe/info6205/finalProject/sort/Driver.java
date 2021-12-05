package edu.neu.coe.info6205.finalProject.sort;

import edu.neu.coe.info6205.finalProject.benchMark.Benchmark;
import edu.neu.coe.info6205.finalProject.benchMark.Benchmark_Timer;
import edu.neu.coe.info6205.finalProject.util.ChineseComparator;
import edu.neu.coe.info6205.finalProject.util.FileUtil;
import edu.neu.coe.info6205.finalProject.util.PinyinComparator;
import edu.neu.coe.info6205.finalProject.util.TeluguComparator;

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

    public static void main(String[] args)
    {

        FileUtil fileUtil = new FileUtil();

        String teluguFilePath = "./csvFiles/TeluguWordsNew.csv";
        List<String> teluguWordsList = fileUtil.readFile(teluguFilePath);
        String[] teluguWords = new String[teluguWordsList.size()];
        teluguWords = teluguWordsList.toArray(teluguWords);
        String[] teluguWords1 =  Arrays.copyOf(teluguWords,teluguWords.length);
        String[] teluguWords2 =  Arrays.copyOf(teluguWords,teluguWords.length);
        String[] teluguWords3 =  Arrays.copyOf(teluguWords,teluguWords.length);
        Collections.reverse(Arrays.asList(teluguWords3)); 

        String shuffledChineseFilePath = "./csvFiles/shuffledChinese.txt";
        //String shuffledChineseFilePath = "./csvFiles/sampleChineseShuffled.txt";
        List<String> shuffledChinesewordsList = fileUtil.readFile(shuffledChineseFilePath);
        String[] chineseWords = new String[shuffledChinesewordsList.size()];
        chineseWords = shuffledChinesewordsList.toArray(chineseWords);
        String[] chineseWords1 = Arrays.copyOf(chineseWords,chineseWords.length);
        String[] chineseWords2 = Arrays.copyOf(chineseWords,chineseWords.length);
        String[] chineseWords3 = Arrays.copyOf(chineseWords,chineseWords.length);
        //Collections.reverse(Arrays.asList(chineseWords1));
        //Collections.reverse(Arrays.asList(chineseWords3));


        String sortedChineseFilePath = "./csvFiles/sortedChinese.txt";
        //String sortedChineseFilePath = "./csvFiles/sampleChinesesorted.txt";
        List<String> sortedChinesewordsList = fileUtil.readFile(sortedChineseFilePath);
        String[] sortedChineseWords = new String[sortedChinesewordsList.size()];
        sortedChineseWords = sortedChinesewordsList.toArray(sortedChineseWords);

        long start,end;
        int c;
        c = 0;
         for(int i = 0; i<chineseWords2.length;i++)
         {
             if(chineseWords2[i] != chineseWords3[i])
                 c++;
         }
         
         System.out.println(c + " Mismatches before sorted");
//        //Timsort Chinese
        start = System.currentTimeMillis();
        TimSort ts = new TimSort(new PinyinComparator());
        ts.sort(chineseWords);
         end = System.currentTimeMillis();
         System.out.println("Tim chinese: " + (end - start) + "ms");
//
//        //Dual Pivot chinese
        start = System.currentTimeMillis();
        DualPivotQuickSort ds = new DualPivotQuickSort(new PinyinComparator());
        ds.dualPivotQuickSort(chineseWords1);
        end = System.currentTimeMillis();
        System.out.println("dual pivot chinese: " + (end - start) + "ms");

//      //Lsd chinese
//      start = System.currentTimeMillis();
//      LSDRadixSortChinese lsd = new LSDRadixSortChinese();
//      lsd.sort(chineseWords2);
//      end = System.currentTimeMillis();
//      System.out.println("LSD chinese: " + (end - start) + "ms");
//
//        //msd Chinese
//     start = System.currentTimeMillis();
//     MSDRadixSortChinese.sort(chineseWords3);
//     end = System.currentTimeMillis();
//     System.out.println("MSD sort " +
//            (end - start) + "ms");
//
//        //wordNode MSD sort
//        start = System.currentTimeMillis();
//        TestSort testSort = new TestSort();
//        testSort.sort(chineseWords2);
//        end = System.currentTimeMillis();
//        System.out.println("Word Node MSD sort " +
//                (end - start) + "ms");

     //wordNode LSD sort
//     start = System.currentTimeMillis();
//     LSDWordNode lsdw = new LSDWordNode();
//     lsdw.sort(chineseWords3);
//     end = System.currentTimeMillis();
//     System.out.println("WordNode LSD sort " +
//             (end - start) + "ms");

    c = 0;
    for(int i = 0; i<chineseWords2.length;i++)
    {
        if(chineseWords[i] != chineseWords1[i])
            c++;
    }
    System.out.println(c + " mismatches after sort");


//        int c = 0;                                                                                                                          
//        for(int i = 0; i<teluguWords.length;i++)                                                                                                    
//        {                                                                                                                                           
//            if(teluguWords[i].equals(teluguWords1[i]) && teluguWords[i].equals(teluguWords2[i]) && teluguWords[i].equals(teluguWords3[i]))          
//            {                                                                                                                                       
//                continue;                                                                                                                           
//            }                                                                                                                               
//            else{                                                                                                                                   // msd telugu
//                //System.out.println(teluguWords[i] + "    " + teluguWords1[i]);                                                            //        start = System.currentTimeMillis();
//                c++;                                                                                                                        //        MSDRadixSort.sort(teluguWords3);
//            }                                                                                                                               //        end = System.currentTimeMillis();
//                                                                                                                                            //        System.out.println("Msd telugu" + (end - start) + "ms");
//        }                                                                                                                                   
//        System.out.println(c);
//




// LSD Telugu
        //        start = System.currentTimeMillis();
        //        LSDRadixSort lsdSort = new LSDRadixSort();
//        lsdSort.sort(teluguWords1);
//        end = System.currentTimeMillis();
//        System.out.println("lsd telugu" + (end - start) + "ms");

        //Dual pivot  Telugu
//        start = System.currentTimeMillis();
//        DualPivotQuickSort dualPivotQuickSort = new DualPivotQuickSort(new TeluguComparator());
//        dualPivotQuickSort.dualPivotQuickSort(teluguWords2);
//        end = System.currentTimeMillis();
//        System.out.println("dual pivot telugu" + (end - start) + "ms");
//
        //Timsort telugu
//        start = System.currentTimeMillis();
//        TimSort ts = new TimSort(new TeluguComparator());
//        ts.sort(teluguWords);
//        end = System.currentTimeMillis();
//        System.out.println("tim sort telugu" + (end - start) + "ms");
//
//        c = 0;
//        for(int i = 0; i<teluguWords.length;i++)
//        {
//            if(teluguWords[i].equals(teluguWords1[i]) && teluguWords[i].equals(teluguWords2[i]) && teluguWords[i].equals(teluguWords3[i]))
//            {
//               continue;
//            }
//            else{
//                System.out.println(teluguWords[i] + "    " + teluguWords1[i]);
//                c++;
//            }
//
//        }
//        System.out.println(c + " mismatch after sort");

//        Locale[] listLocales = Locale.getAvailableLocales();


    }

}
