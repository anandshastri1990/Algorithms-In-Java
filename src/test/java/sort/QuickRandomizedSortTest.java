package sort;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class QuickRandomizedSortTest {

    QuickRandomizedSort quickRandomizedSort;

    @Before
    public void setup() {
        quickRandomizedSort = new QuickRandomizedSort();
    }

    @Test
    public void sortAscending() {
        int[] input = {1, 0, 100, 9, 4, 99, 2, 11, 3, 5};
        int[] output = {0, 1, 2, 3, 4, 5, 9, 11, 99, 100};

        assertThat(quickRandomizedSort.sortAscending(input)).isEqualTo(output);
    }

    @Test
    public void sortAscending_worstCase() {
        int[] input = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        int[] output = {1, 2, 3, 4, 5, 5, 7, 8, 9};

        assertThat(quickRandomizedSort.sortAscending(input)).isEqualTo(output);
    }

}