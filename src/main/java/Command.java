import java.util.Arrays;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class Command {

    Map<String, String> flagMap = new HashMap<>();

    public Command(String command) {
        ListIterator<String> commandIter = Arrays.asList(command.split("\\s+")).listIterator();
        while (commandIter.hasNext()) {
            String flag = commandIter.next();
            if (commandIter.hasNext()) {
                String name = flag.replace("-", "");
                if (flag.charAt(0) == '-') {
                    String value = commandIter.next();
                    flagMap.put(name, value);

                }
            }
        }
    }

    public String getValueByFlag(String flag) {
        return flagMap.get(flag);
    }
}
