package edu.neu.coe.info6205.finalProject.util;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class TeluguComparator  implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        Collator collator = Collator.getInstance(new Locale("te_IN"));
        return collator.compare(str1, str2);
    }

}
