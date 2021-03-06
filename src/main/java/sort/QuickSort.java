package sort;

public class QuickSort {

    private static int count;

    public int[] sortAscending(int[] input) {
        count = 0;

        quickSort(input, 0 , input.length -1);

        System.out.println("complexity is " + count + " for array length "+input.length);

        return input;
    }

    private void quickSort(int[] input, int start, int end) {
        if (start >= end) {
            return;
        }

        int partitionIndex = start;
        int pivot = end;
        for (int i = start; i <= end; i++) {
            count++;
            if (input[i] < input[pivot]) {
                swap(input, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(input, partitionIndex, pivot);

        quickSort(input, 0, partitionIndex-1);
        quickSort(input, partitionIndex+1, end );
    }

    private void swap(int[] input, int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
