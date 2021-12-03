package edu.neu.coe.info6205.finalProject.sort;
//import edu.neu.coe.info6205.finalProject.sort.InsertionSort;
import edu.neu.coe.info6205.finalProject.util.PinyinHelperClass;

/**
 * Class to implement Most significant digit string sort (a radix sort).
 */
public class MSDRadixSortChinese {

    /**
     * Sort an array of Strings using MSDStringSort.
     * @param chineseWords the array to be sorted.
     */
    public static void sort( String[] chineseWords) {
        int n = chineseWords.length;
        System.out.println("start of conversion");
        String[] pinyinWords = PinyinHelperClass.chineseToPinyan(chineseWords);
        System.out.println("end of conversion");
        pinyinAux = new String[n];
        chineseAux = new String[n];
        System.out.println("start of sorted");
        sort(pinyinWords, chineseWords, 0, n-1, 0);
        System.out.println("start of sorted");
    }

    /**
     * Sort from a[lo] to a[hi] (exclusive), ignoring the first d characters of each String.
     * This method is recursive.
     *
     * @param pinyinWords the array to be sorted.
     * @param lo the low index.
     * @param hi the high index (one above the highest actually processed).
     * @param d the number of characters in each String to be skipped.
     */
    private static void sort(String[] pinyinWords, String[] chineseWords, int lo, int hi, int d) {

        if(hi<=lo) return;
        int[] count = new int[radix + 2];

        //compute frequency
        for (int i = lo; i <= hi; i++) {
            //if (d < a[i].length()) System.out.println(charAt(a[i], d) + " " + a[i].charAt(d) + " " + d + " " + a[i]);
            count[charAt(pinyinWords[i], d) + 2]++;
        }

        //Transform to indices
        for (int r = 0; r < radix + 1; r++)
            count[r + 1] += count[r];

        //distribute
        for (int i = lo; i <= hi; i++)
        {
            int index = charAt(pinyinWords[i], d) + 1;
            pinyinAux[count[index]] = pinyinWords[i];
            chineseAux[count[index]] = chineseWords[i];
            count[index]++;
        }

        // copy back
        for (int i = lo; i <= hi; i++)
        {
            pinyinWords[i] = pinyinAux[i - lo];
            chineseWords[i] = chineseAux[i - lo];
        }

        for (int r = 0; r < radix; r++)
            sort(pinyinWords, chineseWords, lo + count[r], lo + count[r+1] - 1, d+1);

    }

    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    private static final int radix = 65536;
    private static String[] pinyinAux;
    private static String[] chineseAux;
}

