import helpers.APIConsult;
import models.City;
import models.CityOmbd;
import models.Weather;
import models.WeatherOmbd;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;
        System.out.print("Challenge Cieloscopio \nBienvenido al CielosCopio");

        while (true) {
            showMenu();
            try {
                System.out.println("Ingrese una opción del menú");
                option = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número entero.");
                input.next(); // Limpiar el buffer del scanner.
                continue;
            }

            if (option == 7) {
                System.out.println("Saliendo del programa, Gracias por usar el CielosCopio!🧡");
                input.close();
                break;
            }

            String cityName = getCityName(option, input);

            if (!cityName.isEmpty()) makeQuery(cityName);
        }
    }

    public static void showResults(City city, Weather weather) {
        System.out.printf("""
                +------------------------Respuesta-----------------------+
                Ciudad: %s - (%s)
                Fecha: %s
                Horario: %s %n
                """, city.getName(), city.getCountry(), LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        weather.showWeatherData();
        System.out.print("+--------------------------------------------------------+");
    }

    public static void showMenu() {
        System.out.println("""
                \n
                +-----------------------Cieloscopio-----------------------+
                | Elige una ciudad para obtener los datos meteorológicos: |
                | 1. Ciudad de México - (MX)                              |
                | 2. Buenos Aires - (AR)                                  |
                | 3. Bogotá - (CO)                                        |
                | 4. Lima - (PE)                                          |
                | 5. Santiago de Chile - (CL)                             |
                | 6. Desea consultar otra ciudad                          |
                | 7. Salir                                                |
                +---------------------------------------------------------+""");
    }

    public static String getCityName(int option, Scanner input) {
        /*switch (option) {
            case 1:
                return "Ciudad de México";
            case 2:
                return "Buenos Aires";
            case 3:
                return "Bogotá";
            case 4:
                return "Lima";
            case 5:
                return "Santiago de Chile";
            case 6:
                System.out.println("Escriba el nombre de una ciudad: ");
                return input.nextLine();
            default:
                System.out.println("Opción incorrecta, por favor ingrese una opción válida");
                return "";
        }*/
        return switch (option) {
            case 1 -> "Ciudad de México";
            case 2 -> "Buenos Aires";
            case 3 -> "Bogotá";
            case 4 -> "Lima";
            case 5 -> "Santiago de Chile";
            case 6 -> {
                System.out.println("Escriba el nombre de una ciudad: ");
                yield input.nextLine();
            }
            default -> {
                System.out.println("Opción incorrecta, por favor ingrese una opción válida");
                yield "";
            }
        };
    }

    public static void makeQuery(String cityName) {
        try {
            APIConsult apiConsult = new APIConsult();

            CityOmbd cityOmbd = apiConsult.getCityByName(cityName);
            City myCity = new City(cityOmbd);

            WeatherOmbd weatherOmbd = apiConsult.getCityByCoords(myCity.getLatitude(), myCity.getLongitude());
            Weather weather = new Weather(weatherOmbd);

            showResults(myCity, weather);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
