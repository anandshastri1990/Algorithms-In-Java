package puzzle;


import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TowersOfHanoiTest {

    private TowersOfHanoi towersOfHanoi;

    @Before
    public void setup() {
        towersOfHanoi = new TowersOfHanoi();
    }

    @Test
    public void getNumberOfSteps() {
        assertThat(towersOfHanoi.getNumberOfSteps(3)).isEqualTo(7);
    }
}