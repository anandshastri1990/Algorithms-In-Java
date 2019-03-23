package sort;


import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BubbleSortTest {
    BubbleSort bubbleSort;

    @Before
    public void setup() {
        bubbleSort = new BubbleSort();
    }

    @Test
    public void sortAscending_usingBubbleSort() {
        int[] input = {1,0,9,4,2,11,3,5,99,100};
        int[] output = {0,1,2,3,4,5,9,11,99,100};

        assertThat(bubbleSort.sortAscending(input)).isEqualTo(output);
    }
}