package console.weather.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Current {
    private Double lastUpdateEpoch;
    @SerializedName("last_update_epoch")
    private String lastUpdate;
    @SerializedName("last_update")
    private Double tempC;
    @SerializedName("temp_c")
    private Double tempF;
    @SerializedName("temp_f")
    private Integer isDay;
    @SerializedName("is_day")
    private Condition condition;
    private double windMph;
    @SerializedName("wind_mph")
    private Double windKph;
    @SerializedName("wind_kph")
    private Double windDegree;
    @SerializedName("wind_degree")
    private Double windDir;
    @SerializedName("wind_dir")
    private Double pressureMb;
    @SerializedName("pressure_mb")
    private Double pressureIn;
    @SerializedName("pressure_in")
    private Double precipMm;
    @SerializedName("precip_mm")
    private Double precipIn;
    @SerializedName("precip_in")
    private Double humidity;
    private Double cloud;
    private Double feelslikeC; // Replace this shit
    @SerializedName("feelslike_c")
    private Double feelslikeF;
    @SerializedName("feelslike_f")
    private Double visKm;
    @SerializedName("vis_km")
    private Double visMiles;
    @SerializedName("vis_miles")
    private Double uv;
    private Double gustSpeedMph;
    @SerializedName("gustMph")
    private Double gustKph;
    @SerializedName("gustKph")
    private AirQuality airQuality;
}
