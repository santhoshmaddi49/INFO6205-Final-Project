package edu.neu.coe.info6205.finalProject.sort;

import junit.framework.TestCase;
import org.junit.Test;

public class MSDRadixSortTest extends TestCase {
    @Test
    public void testRandomTeluguWordsSort() throws Exception{
        String[] unsortedArray = { "సాదా", "అమ్మాయి", "సాధారణ", "యువ", "సిద్ధంగా", "పైన","ఎప్పుడూ","ఎరుపు","జాబితా","అయితే"};
        String[] sortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};

        MSDRadixSort msdRadixSort=new MSDRadixSort();
        msdRadixSort.sort(unsortedArray);
        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }

    @Test
    public void testSortedTeluguWordsSort() throws Exception{
        String[] unsortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};
        String[] sortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};

        MSDRadixSort msdRadixSort=new MSDRadixSort();
        msdRadixSort.sort(unsortedArray);

        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }
    @Test
    public void testReverseSortedTeluguWordsSort() throws Exception{
        String[] unsortedArray = {"సిద్ధంగా", "సాధారణ", "సాదా", "యువ", "పైన", "జాబితా", "ఎరుపు", "ఎప్పుడూ", "అయితే", "అమ్మాయి"};
        String[] sortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};

        MSDRadixSort msdRadixSort=new MSDRadixSort();
        msdRadixSort.sort(unsortedArray);

        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }
    @Test
    public void testPartiallySortedTeluguWordsSort() throws Exception{
        String[] unsortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "సిద్ధంగా", "సాధారణ", "సాదా", "పైన", "యువ"};
        String[] sortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};

        MSDRadixSort msdRadixSort=new MSDRadixSort();
        msdRadixSort.sort(unsortedArray);

        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }


}