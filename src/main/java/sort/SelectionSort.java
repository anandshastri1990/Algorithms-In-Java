package sort;

class SelectionSort {

    int[] sortAscending(int[] input) {

        int count = 0;
        for (int i = input.length - 1; i >= 0; i--) {
            int iteratorPosition = 0;
            for (int j = 0; j < i; j++) {
                if (input[iteratorPosition] < input[j +1]) {
                    iteratorPosition = j+1;
                }

                count++;
            }

            int temp = input[iteratorPosition];
            input[iteratorPosition] = input[i];
            input[i] = temp;

            count++;
        }

        System.out.println("complexity is " +count +" which is n^2 ");
        System.out.println("Although the efficiency can be increased by avoiding iteration over already sorted element");
        System.out.println("for (int j = 0; j < input.length - 1; j++) ----> for (int j = 0; j < i; j++)");

        return input;
    }

}
