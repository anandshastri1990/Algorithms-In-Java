package sort;


import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SelectionSortTest {

    SelectionSort selectionSort;

    @Before
    public void setup() {
        selectionSort = new SelectionSort();
    }

    @Test
    public void sortAscending_usingSelectionSort() {
        int[] input = {1,0,9,4,2,11,3,5,99,100};
        int[] output = {0,1,2,3,4,5,9,11,99,100};

        assertThat(selectionSort.sortAscending(input)).isEqualTo(output);
    }

}