import Entity.ArgsEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parse {

    private List<ArgsEntity> argsEntityList = new ArrayList<>();

    public Parse(String command) {
        List<String> flagValue = Arrays.asList(command.split("\\s+"));
        for (int i = 0; i < flagValue.size(); i++) {
            String e = flagValue.get(i);
            // 判断是有-即为flag
            if (e.charAt(0) == '-') {
                String flag = flagValue.get(i).substring(1);
                String value = null;
                if (i + 1 < flagValue.size() && flagValue.get(i + 1).charAt(0) != '-') {
                    value = flagValue.get(i = ++i);
                }
                ArgsEntity entity = ArgsEntity.builder().flag(flag).value(value).build();
                argsEntityList.add(entity);
            }
        }
    }

    public String getValue(String flag) {
        for (ArgsEntity e : argsEntityList) {
            if (flag.equals(e.getFlag())) {
                return e.getValue();
            }
        }
        return null;
    }
}
