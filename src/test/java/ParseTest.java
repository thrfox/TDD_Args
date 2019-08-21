import org.junit.Assert;
import org.junit.Test;

/**
 * 解析类，解析command
 */
public class ParseTest {

    @Test
    public void test_with_one_args() {
        String command = "-p 8080";
        Parse parse = new Parse(command);
        Assert.assertEquals(parse.getValue("p"), "8080");
    }


    @Test
    public void test_with_two_args() {
        String command = "-p 8080 -d /usr";
        Parse parse = new Parse(command);
        Assert.assertEquals(parse.getValue("p"), "8080");
        Assert.assertEquals(parse.getValue("d"), "/usr");
    }

    @Test
    public void test_args_is_default() {
        String command = "-l -p";
        Parse parse = new Parse(command);
        Assert.assertNull(parse.getValue("l"));
        Assert.assertNull(parse.getValue("p"));
    }
}
