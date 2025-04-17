package console.weather.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Current {
    private Long last_updated_epoch;

    @SerializedName("last_updated")
    private String lastUpdated;

    @SerializedName("temp_c")
    private Double tempC;

    @SerializedName("temp_f")
    private Double tempF;

    @SerializedName("is_day")
    private Integer isDay;

    private Condition condition;

    @SerializedName("wind_mph")
    private Double windMph;

    @SerializedName("wind_kph")
    private Double windKph;

    @SerializedName("wind_degree")
    private Integer windDegree;

    @SerializedName("wind_dir")
    private String windDir;

    @SerializedName("pressure_mb")
    private Double pressureMb;

    @SerializedName("pressure_in")
    private Double pressureIn;

    @SerializedName("precip_mm")
    private Double precipMm;

    @SerializedName("precip_in")
    private Double precipIn;

    private Integer humidity;
    private Integer cloud;

    @SerializedName("feelslike_c")
    private Double feelslikeC;

    @SerializedName("feelslike_f")
    private Double feelslikeF;

    @SerializedName("vis_km")
    private Double visKm;

    @SerializedName("vis_miles")
    private Double visMiles;

    private Double uv;

    @SerializedName("gust_mph")
    private Double gustMph;

    @SerializedName("gust_kph")
    private Double gustKph;

    @SerializedName("air_quality")
    private AirQuality airQuality;

    public Long getLast_updated_epoch() {
        return last_updated_epoch;
    }

    public void setLast_updated_epoch(Long last_updated_epoch) {
        this.last_updated_epoch = last_updated_epoch;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Double getTempC() {
        return tempC;
    }

    public void setTempC(Double tempC) {
        this.tempC = tempC;
    }

    public Double getTempF() {
        return tempF;
    }

    public void setTempF(Double tempF) {
        this.tempF = tempF;
    }

    public Integer getIsDay() {
        return isDay;
    }

    public void setIsDay(Integer isDay) {
        this.isDay = isDay;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Double getWindMph() {
        return windMph;
    }

    public void setWindMph(Double windMph) {
        this.windMph = windMph;
    }

    public Double getWindKph() {
        return windKph;
    }

    public void setWindKph(Double windKph) {
        this.windKph = windKph;
    }

    public Integer getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(Integer windDegree) {
        this.windDegree = windDegree;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public Double getPressureMb() {
        return pressureMb;
    }

    public void setPressureMb(Double pressureMb) {
        this.pressureMb = pressureMb;
    }

    public Double getPressureIn() {
        return pressureIn;
    }

    public void setPressureIn(Double pressureIn) {
        this.pressureIn = pressureIn;
    }

    public Double getPrecipMm() {
        return precipMm;
    }

    public void setPrecipMm(Double precipMm) {
        this.precipMm = precipMm;
    }

    public Double getPrecipIn() {
        return precipIn;
    }

    public void setPrecipIn(Double precipIn) {
        this.precipIn = precipIn;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getCloud() {
        return cloud;
    }

    public void setCloud(Integer cloud) {
        this.cloud = cloud;
    }

    public Double getFeelslikeC() {
        return feelslikeC;
    }

    public void setFeelslikeC(Double feelslikeC) {
        this.feelslikeC = feelslikeC;
    }

    public Double getFeelslikeF() {
        return feelslikeF;
    }

    public void setFeelslikeF(Double feelslikeF) {
        this.feelslikeF = feelslikeF;
    }

    public Double getVisKm() {
        return visKm;
    }

    public void setVisKm(Double visKm) {
        this.visKm = visKm;
    }

    public Double getVisMiles() {
        return visMiles;
    }

    public void setVisMiles(Double visMiles) {
        this.visMiles = visMiles;
    }

    public Double getUv() {
        return uv;
    }

    public void setUv(Double uv) {
        this.uv = uv;
    }

    public Double getGustMph() {
        return gustMph;
    }

    public void setGustMph(Double gustMph) {
        this.gustMph = gustMph;
    }

    public Double getGustKph() {
        return gustKph;
    }

    public void setGustKph(Double gustKph) {
        this.gustKph = gustKph;
    }

    public AirQuality getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(AirQuality airQuality) {
        this.airQuality = airQuality;
    }
}