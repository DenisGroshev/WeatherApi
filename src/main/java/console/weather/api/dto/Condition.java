package console.weather.api.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Condition {
    private String text;
    private String icon;
    private Integer code;

}

