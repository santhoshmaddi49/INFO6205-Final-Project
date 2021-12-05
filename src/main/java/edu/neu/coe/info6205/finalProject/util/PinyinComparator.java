package edu.neu.coe.info6205.finalProject.util;
import java.util.Comparator;

public class PinyinComparator implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {

        String p1 = PinyinHelperClass.chineseToPinyan(str1);
        String p2 = PinyinHelperClass.chineseToPinyan(str2);
        return p1.compareTo(p2);

    }
}
