package sort;

public class BubbleSort {
    int[] sortAscending(int[] input) {

        int count = 0;
        for (int i = input.length - 1; i >= 0; i--) {
            for (int j = 0; j < input.length - 1; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }

                count++;
            }
            count++;
        }

        System.out.println("complexity is " +count +" which is n^2 ");
        System.out.println("Although the efficiency can be increased by avoiding iteration over already sorted element");
        System.out.println("for (int j = 0; j < input.length - 1; j++) ----> for (int j = 0; j < i; j++)");

        return input;
    }
}
