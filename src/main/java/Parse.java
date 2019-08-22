import lombok.Data;

@Data
public class Parse {

    private String flag;
    private String value;

    /**
     * 解析flag和str的值
     *
     * @param command
     */
    public Parse(String command) {
        String[] flagValue = command.split("\\s+");
        flag = flagValue[0].substring(1);
        if (flagValue.length > 1) {
            value = flagValue[1];
        }
    }

}
