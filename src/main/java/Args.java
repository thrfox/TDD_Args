import lombok.Data;

@Data
public class Args {

    private String flag;
    private String type;
    private Object value;

    public Args(String flag, String type, String strValue) {
        // strValue根据type转换成对应的类型，并成为一个entity实体
        this.flag = flag;
        switch (type) {
            case "bool":
                this.value = Boolean.valueOf(strValue == null ? "true" : strValue);
                break;
            case "int":
                this.value = Integer.valueOf(strValue == null ? "8080" : strValue);
                break;
            case "str":
                this.value = strValue;
                break;
            default:
                this.value = null;
                break;
        }
        // 最后从实体中取出最终的value值
    }
}
