import org.junit.Assert;
import org.junit.Test;

public class SchemaTest {

    @Test
    public void test_schema_1() {
        String schemaRule = "l:bool";
        Schema schema = new Schema(schemaRule);
        Assert.assertEquals(schema.getType(), "bool");
    }

    @Test
    public void test_schema_2() {
        String schemaRule = "l:int";
        Schema schema = new Schema(schemaRule);
        Assert.assertEquals(schema.getType(), "int");
    }

}
