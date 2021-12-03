package edu.neu.coe.info6205.finalProject.sort;

import java.util.Comparator;
// https://www.geeksforgeeks.org/dual-pivot-quicksort/
// Java program to implement
// dual pivot QuickSort
public class DualPivotQuickSort{

    private Comparator<String> cmp;
    DualPivotQuickSort(Comparator<String> cmp){
        this.cmp = cmp;
    }
    public void swap(String[] arr, int i, int j)
    {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void dualPivotQuickSort(String[] arr, int low, int high)
    {
        if (low < high)
        {

            // piv[] stores left pivot and right pivot.
            // piv[0] means left pivot and
            // piv[1] means right pivot
            int[] piv;
            piv = partition(arr, low, high);

            dualPivotQuickSort(arr, low, piv[0] - 1);
            dualPivotQuickSort(arr, piv[0] + 1, piv[1] - 1);
            dualPivotQuickSort(arr, piv[1] + 1, high);
        }
    }

    public void dualPivotQuickSort(String[] arr)
    {

        dualPivotQuickSort(arr,0, arr.length-1);

    }

    public int[] partition(String[] arr, int low, int high)
    {

        if (cmp.compare(arr[low],arr[high]) > 0)// arr[low] > arr[high])
            swap(arr, low, high);

        // p is the left pivot, and q is the right pivot.
        int j = low + 1;
        int g = high - 1, k = low + 1;
        String p = arr[low], q = arr[high];

        while (k <= g)
        {

            // If elements are less than the left pivot
            if ( cmp.compare(arr[k],p)<0) //arr[k] < p)
            {
                swap(arr, k, j);
                j++;
            }

            // If elements are greater than or equal
            // to the right pivot
            else if ( cmp.compare(arr[k],q)>=0)//arr[k] >= q)
            {
                while (cmp.compare(arr[g],q)>0 && k<g) //arr[g] > q && k < g)
                    g--;

                swap(arr, k, g);
                g--;

                if (cmp.compare(arr[k],p)<0) //arr[k] < p)
                {
                    swap(arr, k, j);
                    j++;
                }
            }
            k++;
        }
        j--;
        g++;

        // Bring pivots to their appropriate positions.
        swap(arr, low, j);
        swap(arr, high, g);

        // Returning the indices of the pivots
        // because we cannot return two elements
        // from a function, we do that using an array.
        return new int[] { j, g };
    }

    // Driver code
//    public static void main(String[] args)
//    {
//        int[] arr = { 24, 8, 42, 75, 29, 77, 38, 57 };
//
//        dualPivotQuickSort(arr, 0, 7);
//
//        System.out.print("Sorted array: ");
//        for (int i = 0; i < 8; i++)
//            System.out.print(arr[i] + " ");
//
//        System.out.println();
//    }
}

// This code is contributed by Gourish Sadhu

