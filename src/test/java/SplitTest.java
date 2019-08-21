import org.junit.Assert;
import org.junit.Test;

public class SplitTest {

    @Test
    public void split_mutil_command_to_one_args() {
        String fullCommand = "-l true -p 8080 -d /usr";
        String[] commandByValue = SplitUtils.splitCommand(fullCommand);
        Assert.assertArrayEquals(commandByValue, new String[]{"-l true", "-p 8080", "-d /usr"});
    }

    @Test
    public void test_split_schema() {
        String schemaRule = "l:bool%p:int";
        String[] schema = SplitUtils.splitSchemaRule(schemaRule);
        Assert.assertArrayEquals(schema, new String[]{"l:bool", "p:int"});
    }
}
