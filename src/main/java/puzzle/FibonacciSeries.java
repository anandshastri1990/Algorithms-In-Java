package puzzle;

class FibonacciSeries {

    int getFibonacciSum(int count) {
        if (count == 0) {
            return 0;
        }

        if (count == 1) {
            return 1;
        }

        int[] fibArray = new int[count];
        fibArray[0] = 0;
        fibArray[1] = 1;

        getSum(fibArray, 2);

        return fibArray[count - 1];
    }

    private void getSum(int[] fibArray, int counter) {
        if (counter == (fibArray.length)) {
            return;
        }

        fibArray[counter] = fibArray[counter - 1] + fibArray[counter - 2];

        getSum(fibArray, counter + 1);

    }
}
