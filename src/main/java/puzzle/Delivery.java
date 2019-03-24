package puzzle;

import java.util.ArrayList;


class Delivery {
    int[][] getClosestLocations(int totalLocations, final int[][] locations, int truckCapacity) {

        if (truckCapacity == totalLocations) {
            return locations;
        }

        ArrayList<DistanceAndLocation> list = new ArrayList<>();

        for (int[] location : locations) {
            list.add(new DistanceAndLocation(findDistance(location), location));
        }

        final int[][] output = new int[truckCapacity][];

        list.sort(DistanceAndLocation::compareTo);

        int i = 0;
        for (DistanceAndLocation distanceAndLocation : list.subList(0, truckCapacity)) {
            output[i++] = distanceAndLocation.location;
        }

        return output;
    }

    private int findDistance(int[] location) {
        return (location[0] * location[0] + location[1] * location[1]);
    }

    class DistanceAndLocation implements Comparable<DistanceAndLocation> {
        int distance;
        int[] location;

        DistanceAndLocation(int distance, int[] location) {
            this.distance = distance;
            this.location = location;
        }

        public int compareTo(DistanceAndLocation o) {
            return this.distance - o.distance;
        }
    }

}
