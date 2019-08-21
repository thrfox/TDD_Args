public class Args {

    private Schema schema;

    private Parse parse;

    /**
     * 用户使用该类进行操作
     *
     * @param schema  用户可自定义输入的标记与类型
     * @param command 用户输入的命令
     */
    public Args(String schema, String command) {
        this.schema = new Schema(schema);
        this.parse = new Parse(command);
    }

    public Object getValue(String flag) {
        return schema.getValue(flag, parse.getValue(flag));
    }
}
