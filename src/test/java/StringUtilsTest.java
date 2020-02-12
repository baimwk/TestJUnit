import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringUtilsTest {

    private double source;
    private String expected;
    private String s;
    private String testString;
    private String[] testArray;

    @Before
    public void setUp() {
        source = 3.1415;
        expected = "3.1415";
        s = "Test";
        testString = "T:E:S:T";
        testArray = new String[]{"T", "E", "S", "T"};
    }


    @Test
    public void testFromDouble() {
//        double source = 3.1415;
//        String expected="3.1415";
        String actual = StringUtils.fromDouble(source);
        assertEquals("test From Double", expected, actual);
    }

    @Ignore("Replay testFromDouble")
    @Test
    public void testFromDouble2() {
        String actual = StringUtils.fromDouble(source);
        assertEquals("test From Double 2", expected, actual);
    }

    @Test
    public void testAssertFromDouble() {
        assertThat(StringUtils.fromDouble(source), is(expected));
    }

    @Test
    public void testToDouble() {
        assertEquals(3.2, StringUtils.toDouble("3.1415"), 0.01);
    } //failed

    @Test
    public void testIsEmpty() {
        assertTrue("Test empty", StringUtils.isEmpty(""));
    }

    @Test(expected = NumberFormatException.class)
    public void testException() {
        StringUtils.toDouble(s);
    }

    @Test
    public void TestArray() {
        assertArrayEquals("Wrong array", testArray, StringUtils.toArray(testString, ':'));
        assertNull(StringUtils.toArray(null, ':'));
    }
}
