import Entity.SchemaEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Schema {

    /**
     * 解析出来可使用的schema
     */
    private List<SchemaEntity> canBeUsedSchema = new ArrayList<>();

    public Schema(String schema) {
        String[] elements = schema.split("%");
        for (int i = 0; i < elements.length; i++) {
            SchemaEntity schemaEntity = new SchemaEntity();
            String e = elements[i];
            String[] flag_TypeDefault = e.split(":");
            String[] type_default = flag_TypeDefault[1].split(">");
            schemaEntity.setFlag(flag_TypeDefault[0]);
            schemaEntity.setType(type_default[0]);
            canBeUsedSchema.add(schemaEntity);
        }
    }

    /**
     * 取得标记的值,定义类型
     *
     * @param flag
     * @return
     */
    public Object getValue(String flag, String value) {
        for (int i = 0; i < canBeUsedSchema.size(); i++) {
            SchemaEntity schema = canBeUsedSchema.get(i);
            if (flag.equals(schema.getFlag())) {
                switch (schema.getType()) {
                    case "bool":
                        return Boolean.valueOf(value == null ? "true" : value);
                    case "int":
                        return Integer.valueOf(value == null ? "8080" : value);
                    case "str":
                        return value == null ? "/usr" : value;
                    case "list":
                        return value == null ? Collections.EMPTY_LIST.toArray() : Arrays.asList(value.replaceAll("[\\[\\]\"']", "").split(",")).toArray();
                    default:
                        throw new RuntimeException("解析错误:" + schema.getType());
                }

            }
        }
        return null;
    }

}
