package console.weather.api;
import console.weather.api.dto.Current;
import console.weather.api.dto.WeatherResponse;
import retrofit2.Response;

import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Weather Api you dit Hello!");
        Scanner scanner = new Scanner(System.in);


        while(true) {
            System.out.println("");
            System.out.print("Enter your city (or click ctrl+c for exit): ");
            String str = scanner.nextLine();

            Response<WeatherResponse> response = null;
            try {
                response = Weather.instance().current(Weather.KEY, str).execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(response.isSuccessful()){
                Current current = response.body().getCurrent();
                System.out.println("Temperature is " + current.getTempC() + " and it feels like " + current.getFeelslikeC());
            } else {
                System.out.println("Something went wrong");
            }
        }
    }
}
