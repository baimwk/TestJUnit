import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StringUtilsParameterizedTest {
    private double source;
    String expected;

    public StringUtilsParameterizedTest(double source, String expected) {
        this.source = source;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}:{0}={1})")
    public static Iterable<Object[]> dataForTest(){
        return Arrays.asList(new Object[][]{
                {1.0, "1.0"},
                {2.13, "2.13"},
                {18.1, "18.10"},
        });
    }

    @Test
    public void paramTest(){
        assertEquals(expected, StringUtils.fromDouble(source));
    }
}
