package sort;

public class InsertionSort {

    private int count = 0;

    int[] sortAscending(int[] input) {

        int[] output = new int[1];

        output[0] = input[0];

        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (output[j] > input[i]) {
                    output = insertAtIndex(output, j, input[i]);
                    break;
                }

                this.count++;
            }

            if (output.length <= i) {
                output = insertAtIndex(output, i, input[i]);
            }
            this.count++;
        }

        System.out.println("complexity is " + count + " which is n^2 ");

        return output;
    }

    private int[] insertAtIndex(int[] input, int index, int value) {
        int[] output = new int[input.length + 1];

        for (int i = 0; i < index ; i++) {
            output[i] = input[i];
            this.count++;
        }

        output[index] = value;

        for (int i = index; i < input.length ; i++ ) {
            output[i + 1] = input[i];
            this.count++;
        }

        return output;
    }

}
