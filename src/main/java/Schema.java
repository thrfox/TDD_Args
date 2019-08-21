import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Schema {

    Map<String, String> map = new HashMap<>();

    /**
     * 分解参数类型，放入map
     *
     * @param schemaDefine
     */
    public Schema(String schemaDefine) {
        String[] schema = schemaDefine.split(",");
        for (int i = 0; i < schema.length; i++) {
            String[] s = schema[i].split(":");
            String flag = s[0];
            String type = s[1];
            map.put(flag, type);
        }

    }

    public Object getTypeValue(String flag, String strValue) {
        String type = map.get(flag);
        if (strValue == null) {
            return null;
        }
        switch (type) {
            case "bool":
                return Boolean.valueOf(strValue);
            case "int":
                return new Integer(strValue);
            case "str":
                return strValue;
            default:
                return "";
        }

    }
}
