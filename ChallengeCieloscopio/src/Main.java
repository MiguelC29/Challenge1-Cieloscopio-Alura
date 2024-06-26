import helpers.APIConsult;
import models.City;
import models.CityOmbd;
import models.Weather;
import models.WeatherOmbd;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String menu = """
                \nChallenge Cieloscopio
                --------------------------------------------------------
                Elige una ciudad para obtener los datos meteorológicos:
                1. Ciudad de México - (MX)
                2. Buenos Aires - (AR)
                3. Bogotá - (CO)
                4. Lima - (PE)
                5. Santiago de Chile - (CL)
                6. Desea consultar otra ciudad
                7. Salir
                --------------------------------------------------------""";
        int option;

        System.out.println("Bienvenido al CielosCopio");

        do {
            System.out.println(menu);
            System.out.println("Ingrese una opción del menú");
            //VALIDAR QUE LO QUE INGRESE SEA UN NUMERO
            option = teclado.nextInt();
            teclado.nextLine();

            String cityName = "";
            boolean validOption;

            switch (option) {
                case 1:
                    cityName = "Ciudad de México";
                    validOption = true;
                    break;
                case 2:
                    cityName = "Buenos Aires";
                    validOption = true;
                    break;
                case 3:
                    cityName = "Bogotá";
                    validOption = true;
                    break;
                case 4:
                    cityName = "Lima";
                    validOption = true;
                    break;
                case 5:
                    cityName = "Santiago de Chile";
                    validOption = true;
                    break;
                case 6:
                    System.out.println("Escribe el nombre de la ciudad a consultar: ");
                    cityName = teclado.nextLine();
                    validOption = true;
                    break;
                case 7:
                    System.out.println("Gracias por usar el CielosCopio");
                    validOption = false;
                    break;
                default:
                    System.out.println("Opción incorrecta, por favor ingrese una opción válida");
                    validOption = false;
            }

            if (validOption && !cityName.isEmpty()) {
                APIConsult apiConsult = new APIConsult();
                CityOmbd cityOmbd = apiConsult.getCityByName(cityName);

                if (cityOmbd != null) {
                    City myCity = new City(cityOmbd);
                    System.out.println(myCity);

                    WeatherOmbd weatherOmbd = apiConsult.getCityByCoords(myCity.getLatitude(), myCity.getLongitude());
                    Weather weather = new Weather(weatherOmbd);

                    showResults(myCity, weather);
                } else {
                    System.out.println("No se pudo obtener la información de la ciudad.");
                }
            }

        } while (option != 7);
    }

    public static void showResults(City city, Weather weather) {
        System.out.println("---------------------------------------------------------");
        System.out.println("Respuesta:");
        System.out.printf("Ciudad: %s - (%s) %n", city.getName(), city.getCountry());
        System.out.println("Fecha: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Horario: " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")) + "\n");

        weather.showWeatherData();
        System.out.println("---------------------------------------------------------");
    }
}
