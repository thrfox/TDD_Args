import org.junit.Assert;
import org.junit.Test;

public class ArgsTest {

    @Test
    public void test_parse_three() {
        String schema = "l:bool%p:int%d:str";
        String command = "-l -p 8080 -d /usr";
        Args args = new Args(schema, command);
        Assert.assertEquals(args.getValue("p"),8080);
        Assert.assertEquals(args.getValue("l"), Boolean.TRUE);
        Assert.assertEquals(args.getValue("d"), "/usr");
    }

    @Test
    public void test_parse_one() {
        String schema = "l:bool";
        String command = "-l";
        Args args = new Args(schema, command);
        Assert.assertEquals(args.getValue("l"), Boolean.TRUE);
    }

    @Test
    public void test_has_not_default_value() {
        String schema = "l:bool%p:int%d:str";
        String command = "-l -p 8080 -d /usr/qwertyuiop";
        Args args = new Args(schema, command);
        Assert.assertEquals(args.getValue("p"), 8080);
        Assert.assertEquals(args.getValue("l"), Boolean.TRUE);
        Assert.assertEquals(args.getValue("d"), "/usr/qwertyuiop");
    }
}
