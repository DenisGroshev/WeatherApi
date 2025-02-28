package console.weather.api;

import console.weather.api.dto.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI{


    @GET("/v1/current.json")
    Call<WeatherResponse> current(@Query("KEY") String key, @Query("q") String query);

}
