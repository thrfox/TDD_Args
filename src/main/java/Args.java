import java.util.stream.Stream;

public class Args {

    private Schema schema;
    private Command command;

    public Args(String schema, String command) {
        this.schema = new Schema(schema);
        this.command = new Command(command);
    }

    public Object getValue(String flag){
        return schema.getTypeValue(flag, command.getValueByFlag(flag));
    }
}
