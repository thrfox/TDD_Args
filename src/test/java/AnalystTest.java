import org.junit.Assert;
import org.junit.Test;

public class AnalystTest {

    @Test
    public void test() {
        String schemaRule = "l:bool%p:int";
        String command = "-l true -p 8080";
        Analyst analyst = new Analyst(schemaRule, command);
        Assert.assertEquals(analyst.getValue("l"), Boolean.TRUE);
        Assert.assertEquals(analyst.getValue("p"), 8080);

    }
}
