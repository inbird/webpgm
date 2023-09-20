package study.webpgm.json;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class LineDTO {
    private String lineNumber;
    private String lineName;

}
