package edu.neu.coe.info6205.finalProject.util;


import  net.sourceforge.pinyin4j.PinyinHelper;
import  net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import  net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import  net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import  net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;


public class PinyinHelperClass {

    public static String[] chineseToPinyan(String[] chineseWords){

        String[] pinyinChineseWords = new String[chineseWords.length];
        for(int i = 0; i<chineseWords.length; i++)
        {
            try {
                HanyuPinyinOutputFormat pinyinDefaultFormat = new HanyuPinyinOutputFormat();
                pinyinDefaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
                pinyinDefaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
                pinyinChineseWords[i] = PinyinHelper.toHanYuPinyinString(chineseWords[i], pinyinDefaultFormat, "", true);
            }
            catch (BadHanyuPinyinOutputFormatCombination e){
                e.printStackTrace();
            }
        }
        return pinyinChineseWords;
    }
}
