package puzzle;

class TowersOfHanoi {
    private static int steps;

    int getNumberOfSteps(int numberOfDiscs) {
        steps = 0;

        String pole1 = "A";
        String pole2 = "B";
        String pole3 = "C";

        getAndPrintSteps(numberOfDiscs, pole1, pole3, pole2);

        return steps;
    }

    private void getAndPrintSteps(int numberOfDiscs, String startingPole, String endingPole, String auxPole) {
        if (numberOfDiscs == 1) {
            print(startingPole, endingPole);
            return;
        }

        getAndPrintSteps(numberOfDiscs - 1, startingPole, auxPole, endingPole);
        print(startingPole, endingPole);
        getAndPrintSteps(numberOfDiscs - 1, auxPole, endingPole, startingPole);

    }

    private void print(String a, String b) {
        steps++;
        System.out.println("moving disc from " + a + " --> " + b);
    }
}
