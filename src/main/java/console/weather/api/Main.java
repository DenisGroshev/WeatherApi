package console.weather.api;
import console.weather.api.dto.*;
import retrofit2.Response;

import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Weather Api you dit Hello!");
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("");
            System.out.print("Enter your city (or click ctrl+c for exit): ");
            String str = scanner.nextLine();

            Response<WeatherResponse> response = null;
            try {
                response = Weather.instance().current(Weather.KEY, str).execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (response.isSuccessful()) {
                Current current = response.body().getCurrent();
                Condition condition = response.body().getCurrent().getCondition();
                AirQuality airQuality=response.body().getCurrent().getAirQuality();
                Location location=response.body().getLocation();

                System.out.println("Input what you want to take: " + "\n 1. Temperature in celcium \n 2. Wind direction \n 3. Temperature in fahrenheit"+"\n 4. If you want to skip this");
                Integer i = scanner.nextInt();
                switch (i) {
                    case 1:
                    System.out.println("Temperature in your city is: " + current.getTempC());
                    break;
                    case 2:
                    System.out.println("Wind have the direction in: " + current.getWindDir());
                    break;
                    case 3:
                    System.out.println("Temperature in fahrenheit in this city: " + current.getTempF());
                    break;
                    case 4:
                    break;
                    default: System.out.println("Something went wrong");
                }

                System.out.println("What you want more? \n 1. Get code of the city \n 2. Get condition of the city \n 3. Get icon of the city "+
                        "\n 4. And press this if you don't want anymore");
                Integer b = scanner.nextInt();
                switch(b){
                    case 1:
                    System.out.println("Code of this city is: " + condition.getCode());
                    break;
                    case 2:
                        System.out.println("Condition of the city is: " + condition.getText());
                        break;
                    case 3:
                        System.out.println("Icon of this city is: " + condition.getIcon());
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Something went wrong");
                        break;
                }

                System.out.println("Do you want to know more informance of this town? : "+"\n 1. Yes "+" \n 2. No");
                Integer g=scanner.nextInt();

                switch(g){
                    case 1:
                        System.out.println("All informance is: ");
                        System.out.println(location.toString());
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Something went wrong");
                        break;

                }

                // This module is broken
                System.out.println("Do you want know Air Quality in this town?: \n 1. Yes \n 2. No");
                Integer e=scanner.nextInt();
                switch (e){
                    case 1:
                        System.out.println("Air Quality in this town is: "+airQuality.toString());
                    case 2:
                        break;
                    default:
                        System.out.println("Something went wrong");
                }
            }
        }
    }
}
