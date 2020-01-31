import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class CalculatorParameterizedTest {
    private int valueA;
    private int valueB;
    private int expected;

    public CalculatorParameterizedTest(int valueA, int valueB, int expected) {
        this.valueA = valueA;
        this.valueB = valueB;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}:sumOf({0}+{1})={2}") //{index} - индекс теста. пояснение к тестам
    public static Iterable<Object[]> dataForTest() { //интерфейс Iterator
        return Arrays.asList(new Object[][]{
                {1, 1, 2},
                {2, 6, 8},
                {18, 2, 20},
                {13, 15, 28},
                {1, 5, 6}
        });
    }

    @Test
    public void paramTest() {
        assertEquals(expected, new Calculator().getSum(valueA,valueB));
    }
}
