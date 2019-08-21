import java.util.ArrayList;
import java.util.List;

public class Analyst {

    private List<Args> argsEntities = new ArrayList<>();

    private List<Schema> schemas = new ArrayList<>();
    private List<Parse> parses = new ArrayList<>();

    public Analyst(String schemaRules, String commands) {
        // 将所有规则匹配放入argsEntities
        String[] schemaRule = SplitUtils.splitSchemaRule(schemaRules);
        String[] command = SplitUtils.splitCommand(commands);
        for (String rule : schemaRule) {
            schemas.add(new Schema(rule));
        }

        for (String c : command) {
            parses.add(new Parse(c));
        }

        for (Schema schema : schemas) {
            for (Parse pars : parses) {
                if (schema.getFlag().equals(pars.getFlag())) {
                    argsEntities.add(new Args(pars.getFlag(), schema.getType(), pars.getValue()));
                }
            }
        }
    }

    public Object getValue(String flag) {
        // 从entitis中取出最终值
        Object result = argsEntities.stream().filter(args -> flag.equals(args.getFlag())).findFirst().get().getValue();
        return result;
    }
}
