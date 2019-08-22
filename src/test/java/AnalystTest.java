import org.junit.Assert;
import org.junit.Test;

public class AnalystTest {

    @Test
    public void test_has_not_value() {
        String schemaRule = "l:bool%lt:bool";
        String command = "-l false -lt";
        Analyst analyst = new Analyst(schemaRule, command);
        Assert.assertEquals(analyst.getValue("l"), Boolean.FALSE);
        Assert.assertEquals(analyst.getValue("lt"), Boolean.TRUE);
    }


    @Test
    public void test_1() {
        String schemaRule = "l:bool";
        String command = "-l true";
        Analyst analyst = new Analyst(schemaRule, command);
        Assert.assertEquals(analyst.getValue("l"), Boolean.TRUE);
    }

    @Test
    public void test_int_edit_value() {
        String schemaRule = "l:bool%p:int";
        String command = "-l true -p 5858";
        Analyst analyst = new Analyst(schemaRule, command);
        Assert.assertEquals(analyst.getValue("l"), Boolean.TRUE);
        Assert.assertEquals(analyst.getValue("p"), 5858);

    }


    @Test
    public void test_int_has_default() {
        String schemaRule = "l:bool%p:int%d:str";
        String command = "-l true -p -d /usr";
        Analyst analyst = new Analyst(schemaRule, command);
        Assert.assertEquals(analyst.getValue("l"), Boolean.TRUE);
        Assert.assertEquals(analyst.getValue("p"), 8080);
        Assert.assertEquals(analyst.getValue("d"), "/usr");
    }
}
