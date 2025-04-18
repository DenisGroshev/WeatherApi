package console.weather.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirQuality {
    private Double co;
    private Double no2;
    private Double o3;
    private Double so2;
    private Double pm2_5;
    private Double pm10;
    @SerializedName("us-epa-index")
    private Double usEpaIndex;
    @SerializedName("gb-defra-index")
    private Double gbDefraIndex;

    @Override
    public String toString() {
        return "AirQuality{" +
                "co=" + co +
                ", no2=" + no2 +
                ", o3=" + o3 +
                ", so2=" + so2 +
                ", pm2_5=" + pm2_5 +
                ", pm10=" + pm10 +
                ", usEpaIndex=" + usEpaIndex +
                ", gbDefraIndex=" + gbDefraIndex +
                '}';
    }
}

