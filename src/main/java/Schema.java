import lombok.Data;

@Data
public class Schema {

    private String flag;
    private String type;

    public Schema(String schemaRule) {
        String[] flagType = schemaRule.split(":");
        flag = flagType[0];
        type = flagType[1];
    }

}
