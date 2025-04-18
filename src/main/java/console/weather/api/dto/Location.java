package console.weather.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    @Override
    public String toString() {
        return "Location{" +
                "This is city: '" + name + '\'' + "\n"+
                "In the region: '" + region + '\'' + "\n" +
                "This city of country: '" + country + '\'' + "\n"+
                "UTC from: '" + tz_id + '\'' +"\n"+
                "Local time in this city is: " + localtime + '\'' +"\n"+
                '}';
    }

    private String name;
    private String region;
    private String country;
    private Double lat;
    private Double lon;
    @SerializedName("tz_id")
    private String tz_id;
    @SerializedName("localtime_epoch")
    private Long localtime_epoch;
    private String localtime;
}
