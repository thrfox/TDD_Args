import org.junit.Assert;
import org.junit.Test;

public class ParseTest {

    @Test
    public void test_split_flag_and_value_1() {
        String command = "-l true";
        Parse parse = new Parse(command);
        Assert.assertEquals(parse.getValue(), "true");
    }

    @Test
    public void test_split_flag_and_value_2() {
        String command = "-p 8080";
        Parse parse = new Parse(command);
        Assert.assertEquals(parse.getValue(), "8080");
    }
}
