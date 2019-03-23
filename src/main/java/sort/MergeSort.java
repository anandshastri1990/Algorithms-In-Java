package sort;

public class MergeSort {

    static int count = 0;

    int[] sortAscending(int[] input) {
        mergeSort(input);

        System.out.println("complexity is " + count + " which is (N log N) for array length "+input.length);

        return input;
    }

    private void mergeSort(int[] arrayChunk) {
        if (arrayChunk.length < 2) {
            return;
        }

        int middle = arrayChunk.length / 2;

        int[] leftChunkArray = getLeftArrayChunk(arrayChunk, middle);
        int[] rightChunkArray = getRightArrayChunk(arrayChunk, middle);

        mergeSort(leftChunkArray);
        mergeSort(rightChunkArray);

        merge(leftChunkArray, rightChunkArray, arrayChunk);
    }

    private void merge(int[] leftArrayChunk, int[] rightArrayChunk, int[] arrayChunk) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftArrayChunk.length && j < rightArrayChunk.length) {
            if (leftArrayChunk[i] <= rightArrayChunk[j])
                arrayChunk[k++] = leftArrayChunk[i++];
            else
                arrayChunk[k++] = rightArrayChunk[j++];

            count++;
        }

        if (i < leftArrayChunk.length) {
            count++;
        }

        if (j < rightArrayChunk.length) {
            count++;
        }

        while (i < leftArrayChunk.length) {
            arrayChunk[k++] = leftArrayChunk[i++];
        }

        while (j < rightArrayChunk.length) {
            arrayChunk[k++] = rightArrayChunk[j++];
        }

    }

    private int[] getLeftArrayChunk(int[] inputArray, int middle) {
        int[] leftArrayChunk = new int[middle];
        System.arraycopy(inputArray, 0, leftArrayChunk, 0, middle);

        return leftArrayChunk;
    }

    private int[] getRightArrayChunk(int[] inputArray, int middle) {
        int[] rightArrayChunk = new int[inputArray.length - middle];
        System.arraycopy(inputArray, middle, rightArrayChunk, 0, inputArray.length - middle);

        return rightArrayChunk;
    }


}
