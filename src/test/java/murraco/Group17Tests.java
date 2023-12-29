package murraco;

import java.util.Arrays;

import org.junit.Test;

import murraco.BubbleSort;
import murraco.Heapsort;
import murraco.InsertionSort;
import murraco.MergeSort;
import murraco.Quicksort;
import murraco.SelectionSort;

import static org.junit.Assert.*;

public class Group17Tests {
    @Test
    public void testBubbleSortEmptyArray() {
        final Integer[] data = {};
        BubbleSort.bubbleSort(data);
        assertEquals("[]", Arrays.toString(data));
    }

    @Test
    public void testBubbleSortRepeatedSequences() {
        final Integer[] data = {0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3};
        BubbleSort.bubbleSort(data);
        assertEquals("[0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3]", Arrays.toString(data));
    }

    // Tests if BubbleSort is stable like specified in the specification (Readme)
    @Test
    public void testBubbleSortStable() {
        final PositionElement[] data = {
                new PositionElement(5, 0),
                new PositionElement(5, 1),
                new PositionElement(5, 2),
                new PositionElement(5, 3),
                new PositionElement(5, 4)
        };
        BubbleSort.bubbleSort(data);
        assertEquals("[(5,0), (5,1), (5,2), (5,3), (5,4)]", Arrays.toString(data));
    }

    @Test
    public void testInsertionSortSingleElement() {
        final Integer[] data = {8};
        InsertionSort.insertionSort(data);
        assertEquals("[8]", Arrays.toString(data));
    }

    // Tests if SelectionSort is stable like specified in the specification (Readme)
    @Test
    public void testSelectionSortStable() {
        final PositionElement[] data = {
                new PositionElement(5, 0),
                new PositionElement(5, 1),
                new PositionElement(5, 2),
                new PositionElement(5, 3),
                new PositionElement(5, 4)
        };
        SelectionSort.selectionSort(data);
        assertEquals("[(5,0), (5,1), (5,2), (5,3), (5,4)]", Arrays.toString(data));
    }

    @Test
    public void testMergeSortReverseSorted() {
        final Integer[] data = {3, 2, 1, 0};
        MergeSort.mergeSort(data);
        assertEquals("[0, 1, 2, 3]", Arrays.toString(data));
    }

    @Test
    public void testMergeSortSorted() {
        final Integer[] data = {1, 2, 3, 4, 5, 6, 7};
        MergeSort.mergeSort(data);
        assertEquals("[1, 2, 3, 4, 5, 6, 7]", Arrays.toString(data));
    }

    @Test
    public void testHeapSortNegativeValues() {
        final Integer[] data = {-43, -531, -42, -4, 0};
        Heapsort.heapSort(data);
        assertEquals("[-531, -43, -42, -4, 0]", Arrays.toString(data));
    }

    @Test
    public void testQuickSortMinMaxValues() {
        final Integer[] data = {4, Integer.MAX_VALUE, 49355, -32423, Integer.MIN_VALUE, 0};
        Quicksort.quickSort(data);
        assertEquals("[-2147483648, -32423, 0, 4, 49355, 2147483647]", Arrays.toString(data));
    }

    @Test
    public void testQuickSortLargeArray() {
        final int size = 10000;
        Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {
            data[i] = size - i;
        }
        Quicksort.quickSort(data);
        for (int i = 1; i < size; i++) {
            assertTrue(data[i - 1] <= data[i]);
        }
    }
}

class PositionElement implements Comparable<PositionElement> {
    final int value;
    final int position;

    public PositionElement(int value, int position) {
        this.value = value;
        this.position = position;
    }

    public int compareTo(PositionElement x) {
        return Integer.compare(this.value, x.value);
    }

    public String toString() {
        return "(" + this.value + "," + this.position + ")";
    }
}