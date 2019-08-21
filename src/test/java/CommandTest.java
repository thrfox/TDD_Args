import org.junit.Assert;
import org.junit.Test;

public class CommandTest {

    @Test
    public void test() {
        Command command = new Command("-l true -p 8080 -d /usr");
        Assert.assertEquals(command.getValueByFlag("l"),"true");
    }

    @Test
    public void test_port() {
        Command command = new Command("-l true -p 8080 -d /usr");
        Assert.assertEquals(command.getValueByFlag("p"), new Integer("8080"));
    }
    @Test
    public void test_d() {
        Command command = new Command("-l true -p 8080 -d /usr");
        Assert.assertEquals(command.getValueByFlag("d"),"/usr");
    }
}
