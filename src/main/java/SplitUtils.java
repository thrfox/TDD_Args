import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class SplitUtils {
    public static String[] splitCommand(String command) {
        ListIterator<String> commandIter = Arrays.asList(command.split("\\s+")).listIterator();

        List<String> result = new ArrayList<>();
        while (commandIter.hasNext()) {
            StringBuilder commandBuild = new StringBuilder();
            String next = commandIter.next();
            commandBuild.append(next);
            if (commandIter.hasNext()) {
                String nextValue = commandIter.next();
                if (nextValue.charAt(0) != '-') {
                    commandBuild.append(" ").append(nextValue);
                } else {
                    commandIter.previous();
                }
            }
            result.add(commandBuild.toString());
        }
        return result.toArray(new String[0]);
    }

    public static String[] splitSchemaRule(String schemaRule) {
        return schemaRule.split("%");
    }
}
