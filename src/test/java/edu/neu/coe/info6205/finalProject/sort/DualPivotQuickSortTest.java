package edu.neu.coe.info6205.finalProject.sort;
import org.junit.Test;

import edu.neu.coe.info6205.finalProject.util.TeluguComparator;

import static org.junit.Assert.*;

public class DualPivotQuickSortTest {


    @Test
    public void testRandomElementsSort() throws Exception{
        String[] unsortedArray = { "సాదా", "అమ్మాయి", "సాధారణ", "యువ", "సిద్ధంగా", "పైన","ఎప్పుడూ","ఎరుపు","జాబితా","అయితే"};
        String[] sortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};

        DualPivotQuickSort dualPivot=new DualPivotQuickSort(new TeluguComparator());
        dualPivot.dualPivotQuickSort(unsortedArray);
        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }

    @Test
    public void testsortedElementsSort() throws Exception{
        String[] unsortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};
        String[] sortedArray = {"అమ్మాయి", "అయితే", "ఎప్పుడూ", "ఎరుపు", "జాబితా", "పైన", "యువ", "సాదా", "సాధారణ", "సిద్ధంగా"};

        DualPivotQuickSort dualPivot=new DualPivotQuickSort(new TeluguComparator());
        dualPivot.dualPivotQuickSort(unsortedArray);

        for(int i = 0; i<unsortedArray.length;i++)
            assertTrue("Mismatch",unsortedArray[i].equals(sortedArray[i]));

    }



}