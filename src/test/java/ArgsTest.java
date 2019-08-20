import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ArgsTest {

    @Test
    public void should_args_has_one_arg_is_ports_eq_8080(){
        String args = "-p 8080";
        Map<String, Object> expect = new HashMap<String, Object>();

        expectResult(args, expect);
        expect.put("l", false);
        analystArg(args, expect);
    }

    private void expectResult(String args, Map<String, Object> expectMap) {
        // 期望值为Map为p:8080
        expectMap.put("p", "8080");
        expectMap.put("l", true);
        expectMap.put("d", 30);

    }

    private void analystArg(String args, Map<String, Object> expect) {
        // 处理类
        ArgsAnalyst argsAnalyst = new ArgsAnalyst();
        Assert.assertEquals(expect, argsAnalyst.analyst(args));
    }

    @Test
    public void should_args_has_two_arg_are_ports_eq_8080_and_list_eq_boolean_default(){
        String args = "-l -p 8080";
        HashMap<String, Object> expect = new HashMap<String, Object>();
        expectResult(args,expect);
        analystArg(args,expect);
    }
}
