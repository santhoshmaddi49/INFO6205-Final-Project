package edu.neu.coe.info6205.finalProject.sort;

import edu.neu.coe.info6205.finalProject.util.ChineseComparator;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LSDRadixSortChineseTest extends TestCase {

    @Test
    public void testRandomChineseWordsSort() throws Exception{
        String[] unsortedArray = { "阿斌", "阿安", "阿彬", "阿滨", "阿兵", "阿冰", "阿婵", "阿冰冰", "阿朝", "阿超"};
        String[] sortedArray = {"阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿兵", "阿冰冰", "阿婵", "阿超", "阿朝"};

        LSDRadixSortChinese lsdRadixSortChinese=new LSDRadixSortChinese();
        lsdRadixSortChinese.sort(unsortedArray);

        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }

    @Test
    public void testSortedChineseWordsSort() throws Exception{
        String[] unsortedArray = { "阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿兵", "阿冰冰", "阿婵", "阿超", "阿朝"};
        String[] sortedArray = {"阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿兵", "阿冰冰", "阿婵", "阿超", "阿朝"};

        LSDRadixSortChinese lsdRadixSortChinese=new LSDRadixSortChinese();
        lsdRadixSortChinese.sort(unsortedArray);

        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }
    @Test
    public void testReverseSortedChineseWordsSort() throws Exception{
        String[] unsortedArray = { "阿朝", "阿超", "阿婵", "阿冰冰", "阿兵", "阿冰", "阿彬", "阿滨", "阿斌", "阿安"};
        String[] sortedArray = {"阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿兵", "阿冰冰", "阿婵", "阿超", "阿朝"};

        LSDRadixSortChinese lsdRadixSortChinese=new LSDRadixSortChinese();
        lsdRadixSortChinese.sort(unsortedArray);

        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }
    @Test
    public void testPartiallySortedChineseWordsSort() throws Exception{
        String[] unsortedArray = { "阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿冰冰", "阿兵", "阿超", "阿婵", "阿朝"};
        String[] sortedArray = {"阿安", "阿斌", "阿滨", "阿彬", "阿冰", "阿兵", "阿冰冰", "阿婵", "阿超", "阿朝"};

        LSDRadixSortChinese lsdRadixSortChinese=new LSDRadixSortChinese();
        lsdRadixSortChinese.sort(unsortedArray);

        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }

}