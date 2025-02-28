package console.weather.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Weather {
    public static final String HOST = "https://api.weatherapi.com/";
    public static final String KEY = "5d04976167084b02a41150936241810";

    public static WeatherAPI api;
    public static WeatherAPI init(){
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HOST)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        WeatherAPI api = retrofit.create(WeatherAPI.class);
        return api;
    }

    public static WeatherAPI instance(){
        if (api == null){
            return api = init();
        }
        return api;
    }
}
