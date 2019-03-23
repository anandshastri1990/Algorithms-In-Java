package sort;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MergeSortTest {

    MergeSort mergeSort;

    @Before
    public void setup() {
        mergeSort = new MergeSort();
    }

    @Test
    public void sortAscending_usingMergeSort() {
        int[] input = {1,0,100,9,4,99,2,11,3,5};
        int[] output = {0,1,2,3,4,5,9,11,99,100};

        assertThat(mergeSort.sortAscending(input)).isEqualTo(output);
    }

    @Test
    public void sortAscending_usingMergeSortWorstCase() {
        int[] input = {10, 6, 8, 5, 7, 3, 4};
        int[] output = {3, 4, 5, 6, 7, 8, 10};

        assertThat(mergeSort.sortAscending(input)).isEqualTo(output);
    }

}