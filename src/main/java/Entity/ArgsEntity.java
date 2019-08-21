package Entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 参数实体
 */
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ArgsEntity {
    private String flag;
    private String value;
}
