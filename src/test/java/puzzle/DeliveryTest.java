package puzzle;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DeliveryTest {
    private Delivery delivery;

    @Before
    public void setup() {
        delivery = new Delivery();
    }

    @Test
    public void getClosestLocations() {
        int[][] locations = {{1, 2}, {3, 4}, {1, -1}};
        int[][] output = {{1, -1}, {1, 2}};
        assertThat(delivery.getClosestLocations(3, locations, 2)).isEqualTo(output);
    }

    @Test
    public void getClosestLocations_withMoreLocations() {
        int[][] locations = {{1, 2}, {3, 4}, {1, -1}, {-2,6}, {2,2}, {10,99}, {1, 1}};
        int[][] output = {{1, -1}, {1, 1}};
        assertThat(delivery.getClosestLocations(6, locations, 2)).isEqualTo(output);
    }
}