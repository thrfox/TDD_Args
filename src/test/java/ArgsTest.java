import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class ArgsTest {

    @Test
    public void test(){
        Args args = new Args("l:bool,p:int,d:str","-l true -p 8080 -d /usr");
        Assert.assertEquals(args.getValue("p"),8080);
    }
}
