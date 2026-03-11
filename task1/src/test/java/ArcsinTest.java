import org.example.Arcsin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

public class ArcsinTest {
    private static final double delta = 0.000000000001; // погрешность

    @ParameterizedTest
    @ValueSource(doubles = {-1.0, -0.9, -0.5, 0.0, 0.5, 0.9, 1.0})
    @DisplayName("check fixed points")
    void testFixedPoints(double x){
        double expected = Math.asin(x);
        double actual = Arcsin.count(x, 100);
        assertEquals(expected, actual, delta, "Failed for x=" + x);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2.0, 2.0, 1.00000001, -1.000000001, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    @DisplayName("check invalid inputs")
    void testInvalidInputs(double x) {
        double result = Arcsin.count(x, 100);
        assertTrue(Double.isNaN(result), "Expected NaN for x=" + x);
    }

    @Test
    @DisplayName("check random values")
    void testRandomValues() {
        for (int i = 0; i < 1000000; i++) {
            double x = ThreadLocalRandom.current().nextDouble(-0.9999, 0.9999);
            double expected = Math.asin(x);
            double actual = Arcsin.count(x, 100);
            assertEquals(expected, actual, delta, "Failed for x=" + x);
        }
    }

    @Test
    @DisplayName("check NaN input")
    void testNaNInput() {
        double x = Double.NaN;
        double result = Arcsin.count(x);
        assertTrue(Double.isNaN(result), "Expected NaN for x=NaN");
    }

    @Test
    @DisplayName("check values close to +-1")
    void testValuesCloseToOne() {
        double[] nearOne = {0.999999, -0.999999, 0.9999999, -0.9999999};
        for (double x : nearOne) {
            double expected = Math.asin(x);
            double actual = Arcsin.count(x, 100);
            assertEquals(expected, actual, delta, "Failed for x=" + x);
        }
    }

    @Test
    @DisplayName("check small values")
    void testVerySmallValues() {
        double[] smallValues = {Double.MIN_VALUE, -Double.MIN_VALUE, 1e-12, -1e-12};
        for (double x : smallValues) {
            double expected = Math.asin(x);
            double actual = Arcsin.count(x, 100);
            assertEquals(expected, actual, delta, "Failed for x=" + x);
        }
    }
}
