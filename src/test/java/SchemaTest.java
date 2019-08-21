import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

/**
 * 参数结构：
 * 标记值:标记类型>缺省值
 */
public class SchemaTest {

    @Test
    public void test_schema() {
        Schema schema = getSchema("l:bool%p:int%d:str");
        Assert.assertEquals(schema.getValue("l", "true"), Boolean.TRUE);
        Assert.assertEquals(schema.getValue("p", "8080"), 8080);
        Assert.assertEquals(schema.getValue("d", "/usr"), "/usr");
    }

    @Test
    public void test_schema_is_correct_type() {
        Schema schema = getSchema("l:bool%p:int");
        Assert.assertEquals(schema.getValue("l", "true"), Boolean.TRUE);
        Assert.assertEquals(schema.getValue("p", "8080"), 8080);
    }

    @Test
    public void test_schema_has_default_value() {
        Schema schema = getSchema("l:bool%p:int");
        Assert.assertEquals(schema.getValue("p", "8080"), 8080);
    }

    @Test
    public void test_schema_l_is_not_bool() {
        Schema schema = getSchema("l:int");
        Assert.assertEquals(schema.getValue("l", "8080"), 8080);
    }

    //    @Test
    public void test_list() {
        Schema schema = getSchema("g:list");
        Assert.assertEquals(schema.getValue("g", "[]"), Collections.EMPTY_LIST);
    }

    private Schema getSchema(String s) {
        String schemaStr = s;
        return new Schema(schemaStr);
    }

}
