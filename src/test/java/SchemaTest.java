import org.junit.Assert;
import org.junit.Test;

public class SchemaTest {

    @Test
    public void test(){
        // 抽离参数的类型
        Schema schema = new Schema("l:bool");
        Assert.assertEquals(schema.getTypeValue("l","true"),Boolean.TRUE);
        Assert.assertEquals(schema.getTypeValue("l","false"),Boolean.FALSE);
        Assert.assertNull(schema.getTypeValue("l",null));
    }

    @Test
    public void test_is_number(){
        Schema schema = new Schema("l:int");
        Assert.assertEquals(schema.getTypeValue("l","5"), 5);
    }

    @Test
    public void test_with_number_str(){
        Schema schema = new Schema("d:str,p:int");
        Assert.assertEquals(schema.getTypeValue("p","5"), 5);
        Assert.assertEquals(schema.getTypeValue("d","/usr"), "/usr");
    }
}
