import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 参数解析类
 */
public class ArgsAnalyst {

    /**
     * 解析参数
     *
     * @param argsString
     */
    public Map<String, ?> analyst(String argsString) {
        Map<String, Object> returnMap = new HashMap();
        // 不为空则解析
        String[] split = argsString.split("-");
        for (int i = 0; i < split.length; i++) {
            String arg = split[i].trim();
            int splitIndex = arg.indexOf(" ");
            if (splitIndex != -1) {
                // 如果有空格分隔
                returnMap.put(arg.substring(0, splitIndex), arg.substring(splitIndex + 1, arg.length()));
                if (splitIndex + 1 == arg.length()) {
                    returnMap.put(arg.substring(0, splitIndex), true);
                }
            }
        }
        // 检查默认值
        checkDefault(returnMap);
        return returnMap;
    }

    private void checkDefault(Map<String, Object> returnMap) {
        Map<String, Object> defaultMap = new HashMap<>();
        defaultMap.put("p", "8080");
        defaultMap.put("l", false);
        defaultMap.put("d", 30);
        defaultMap.entrySet().forEach(x -> {
            if (!returnMap.containsKey(x.getKey())) {
                returnMap.put(x.getKey(),x.getValue());
            }
        });
    }


}
