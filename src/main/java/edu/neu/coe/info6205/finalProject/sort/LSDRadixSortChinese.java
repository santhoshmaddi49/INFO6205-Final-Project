package edu.neu.coe.info6205.finalProject.sort;


import edu.neu.coe.info6205.finalProject.util.PinyinHelperClass;

public class LSDRadixSortChinese {


    private final int UNICODE_RANGE = 256;

    /**
     * findMaxLength method returns maximum length of all available strings in an array
     *
     * @param strArr It contains an array of String from which maximum length needs to be found
     * @return int Returns maximum length value
     */
    private int findMaxLength(String[] strArr) {
        int maxLength = strArr[0].length();
        for (String str : strArr)
            maxLength = Math.max(maxLength, str.length());
        return maxLength;
    }

    /**
     * charUnicodeVal method returns ASCII value of particular character in a String.
     *
     * @param str          String input for which ASCII Value need to be found
     * @param charPosition Character position of which ASCII value needs to be found. If character
     *                     doesn't exist then ASCII value of null i.e. 0 is returned
     * @return int Returns ASCII value
     */
    private int charUnicodeVal(String str, int charPosition) {
        if (charPosition >= str.length()) {
            return 0;
        }
        return str.charAt(charPosition);
    }

    /**
     * charSort method is implementation of LSD sort algorithm at particular character.
     *
     * @param pinyinWords       It contains an array of String on which LSD char sort needs to be performed
     * @param charPosition This is the character position on which sort would be performed
     * @param from         This is the starting index from which sorting operation will begin
     * @param to           This is the ending index up until which sorting operation will be continued
     */
    private void charSort(String[] pinyinWords, String[] chineseWords,int charPosition, int from, int to) {


        int[] count = new int[UNICODE_RANGE + 2];

        String[] pinyinResult = new String[pinyinWords.length];
        String[] chineseResult = new String[pinyinWords.length];

        for (int i = from; i <= to; i++) {
            int c = charUnicodeVal(pinyinWords[i], charPosition);
            count[c + 1]++;
        }

        // transform counts to indices
        for (int r = 1; r < UNICODE_RANGE + 2; r++)
            count[r] += count[r - 1];

        // distribute
        for (int i = from; i <= to; i++) {
            int c = charUnicodeVal(pinyinWords[i], charPosition);
            pinyinResult[count[c]] = pinyinWords[i];
            chineseResult[count[c]] = chineseWords[i];
            count[c]++;
        }

        // copy back
        for (int i = from; i <= to; i++)
        {
            pinyinWords[i] = pinyinResult[i];
            chineseWords[i] = chineseResult[i];
        }

    }

    /**
     * sort method is implementation of LSD String sort algorithm.
     *
     * @param strArr It contains an array of String on which LSD sort needs to be performed
     * @param from   This is the starting index from which sorting operation will begin
     * @param to     This is the ending index up until which sorting operation will be continued
     */
    public void sort(String[] strArr, int from, int to)
    {

        String[] pinyinWords = PinyinHelperClass.chineseToPinyan(strArr);
        int maxLength = findMaxLength(pinyinWords);
        for (int i = maxLength - 1; i >= 0; i--)
            charSort(pinyinWords,strArr, i, from, to);
    }

    /**
     * sort method is implementation of LSD String sort algorithm.
     *
     * @param strArr It contains an array of String on which LSD sort needs to be performed
     */
    public void sort(String[] strArr) {

        sort(strArr, 0, strArr.length - 1);
    }
}

