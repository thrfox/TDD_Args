import lombok.Data;

@Data
public class Args {

    private String flag;
    private String type;
    private Object value;

    public Args(String flag, String type, String strValue) {
        // strValue根据type转换成对应的类型，并成为一个entity实体

        // 最后从实体中取出最终的value值
    }
}
