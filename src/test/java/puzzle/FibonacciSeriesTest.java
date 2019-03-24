package puzzle;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FibonacciSeriesTest {

    FibonacciSeries fibonacciSeries;

    @Before
    public void setup() {
        fibonacciSeries = new FibonacciSeries();
    }

    @Test
    public void getFibonacciSum() {
        assertThat(fibonacciSeries.getFibonacciSum(5)).isEqualTo(3);
    }

    @Test
    public void getFibonacciSum_largerNumber() {
        assertThat(fibonacciSeries.getFibonacciSum(29)).isEqualTo(317811);
    }

}