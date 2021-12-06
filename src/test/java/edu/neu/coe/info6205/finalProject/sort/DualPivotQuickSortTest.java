package edu.neu.coe.info6205.finalProject.sort;
import edu.neu.coe.info6205.finalProject.util.ChineseComparator;
import org.junit.Test;

import edu.neu.coe.info6205.finalProject.util.TeluguComparator;

import static org.junit.Assert.*;

public class DualPivotQuickSortTest {


    @Test
    public void testRandomTeluguWordsSort() throws Exception{
        String[] unsortedArray = { "సాదా", "అమ్మాయి", "సాధారణ", "యువ", "సిద్ధంగా", "పైన","ఎప్పుడూ","ఎరుపు","జాబితా","అయితే"};
        String[] sortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};

        DualPivotQuickSort dualPivot=new DualPivotQuickSort(new TeluguComparator());
        dualPivot.dualPivotQuickSort(unsortedArray);
        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }

    @Test
    public void testSortedTeluguWordsSort() throws Exception{
        String[] unsortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};
        String[] sortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};

        DualPivotQuickSort dualPivot=new DualPivotQuickSort(new TeluguComparator());
        dualPivot.dualPivotQuickSort(unsortedArray);

        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }
    @Test
    public void testReverseSortedTeluguWordsSort() throws Exception{
        String[] unsortedArray = {"సిద్ధంగా", "సాధారణ", "సాదా", "యువ", "పైన", "జాబితా", "ఎరుపు", "ఎప్పుడూ", "అయితే", "అమ్మాయి"};
        String[] sortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};

        DualPivotQuickSort dualPivot=new DualPivotQuickSort(new TeluguComparator());
        dualPivot.dualPivotQuickSort(unsortedArray);

        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }
    @Test
    public void testPartiallySortedTeluguWordsSort() throws Exception{
        String[] unsortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "సిద్ధంగా", "సాధారణ", "సాదా", "పైన", "యువ"};
        String[] sortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};

        DualPivotQuickSort dualPivot=new DualPivotQuickSort(new TeluguComparator());
        dualPivot.dualPivotQuickSort(unsortedArray);

        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }


    @Test
    public void testRandomChineseWordsSort() throws Exception{
        String[] unsortedArray = {"阿冰","阿安", "阿斌", "阿兵", "阿朝", "阿冰冰", "阿超", "阿婵", "阿彬","阿滨"};
        String[] sortedArray = {"阿安", "阿彬", "阿斌", "阿滨","阿兵", "阿冰", "阿冰冰", "阿超", "阿朝", "阿婵"};

        DualPivotQuickSort dualPivot=new DualPivotQuickSort(new ChineseComparator());
        dualPivot.dualPivotQuickSort(unsortedArray);
        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }

    @Test
    public void testSortedChineseWordsSort() throws Exception{
        String[] unsortedArray = { "阿安", "阿彬", "阿斌", "阿滨","阿兵", "阿冰", "阿冰冰", "阿超", "阿朝", "阿婵"};
        String[] sortedArray = {"阿安", "阿彬", "阿斌", "阿滨","阿兵", "阿冰", "阿冰冰", "阿超", "阿朝", "阿婵"};

        DualPivotQuickSort dualPivot=new DualPivotQuickSort(new ChineseComparator());
        dualPivot.dualPivotQuickSort(unsortedArray);

        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }
    @Test
    public void testReverseSortedChineseWordsSort() throws Exception{
        String[] unsortedArray = { "阿婵", "阿朝", "阿超", "阿冰冰", "阿冰","阿兵", "阿滨", "阿斌", "阿彬","阿安"};
        String[] sortedArray = {"阿安", "阿彬", "阿斌", "阿滨","阿兵", "阿冰", "阿冰冰", "阿超", "阿朝", "阿婵"};

        DualPivotQuickSort dualPivot=new DualPivotQuickSort(new ChineseComparator());
        dualPivot.dualPivotQuickSort(unsortedArray);

        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }
    @Test
    public void testPartiallySortedChineseWordsSort() throws Exception{
        String[] unsortedArray = {"阿安", "阿彬", "阿斌", "阿滨","阿兵", "阿超", "阿冰冰",  "阿婵", "阿冰","阿朝"};
        String[] sortedArray = {"阿安", "阿彬", "阿斌", "阿滨","阿兵", "阿冰", "阿冰冰", "阿超", "阿朝", "阿婵"};

        DualPivotQuickSort dualPivot=new DualPivotQuickSort(new ChineseComparator());
        dualPivot.dualPivotQuickSort(unsortedArray);

        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }

}