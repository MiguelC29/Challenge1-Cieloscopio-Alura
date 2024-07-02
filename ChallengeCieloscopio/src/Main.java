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
    private static final Scanner input = new Scanner(System.in);
    // LISTA DE CIUDADES POR DEFECTO
    private static final String[] cities = {
            "Ciudad de México", "Buenos Aires", "Bogotá", "Lima", "Santiago de Chile",
            "Quito", "Asunción", "Montevideo", "Caracas", "Panamá", "Sucre"
    };

    public static void main(String[] args) {
        System.out.print("Challenge Cieloscopio \nBienvenido al CielosCopio");

        while (true) {
            int option;
            showMenu();
            try {
                System.out.println("Ingrese una opción del menú");
                option = input.nextInt();
                input.nextLine(); // Limpiar el buffer del scanner
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número entero.");
                input.next(); // Limpiar el buffer del scanner.
                continue; // Volver al inicio del bucle
            }

            // Salir del programa si la opción es 0
            if (option == 0) {
                System.out.println("Saliendo del programa, Gracias por usar el CielosCopio!🧡");
                input.close();
                break;
            }

            // Obtener el nombre de la ciudad según la opción seleccionada
            String cityName = getCityName(option);

            // Realizar la consulta si se obtuvo un nombre de ciudad válido
            if (!cityName.isEmpty()) makeQuery(cityName);
        }
    }

    // Método para mostrar los resultados del clima
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

    // Método para mostrar el menú de opciones
    public static void showMenu() {
        System.out.println("""
                \n
                +-----------------------Cieloscopio-----------------------+
                | Elige una ciudad para obtener los datos meteorológicos: |
                |  1. Ciudad de México - (MX)                              |
                |  2. Buenos Aires - (AR)                                  |
                |  3. Bogotá - (CO)                                        |
                |  4. Lima - (PE)                                          |
                |  5. Santiago de Chile - (CL)                             |
                |  6. Quito - (EC)                                         |
                |  7. Asunción - (PY)                                      |
                |  8. Montevideo - (UY)                                    |
                |  9. Caracas - (VE)                                       |
                | 10. Panamá - (PA)                                       |
                | 11. Sucre - (BO)                                       |
                | 12. Desea consultar otra ciudad                          |
                |  0. Salir                                                |
                +---------------------------------------------------------+""");
    }

    // Método para obtener el nombre de la ciudad según la opción seleccionada
    public static String getCityName(int option) {
        // Verifica si la opción está en el rango de las opciones predefinidas (1 a 11)
        if (option >= 1 && option <= 11) {
            return cities[option -1]; // Retorna el nombre de la ciudad correspondiente a la opción seleccionada
        } else if (option == 12) {     // Si la opción es 12, se pide al usuario que ingrese el nombre de una ciudad
            System.out.println("Escriba el nombre de una ciudad: ");
            return input.nextLine(); // Lee y retorna el nombre de la ciudad ingresada por el usuario
        } else {     // Si la opción no es válida (fuera del rango 0-12)
            System.out.println("Opción incorrecta, por favor ingrese una opción válida");
            // Retorna una cadena vacía indicando que la opción no es válida
            return "";
        }
    }

    // Método para realizar la consulta a la API y mostrar los resultados
    public static void makeQuery(String cityName) {
        try {
            APIConsult apiConsult = new APIConsult();

            // Obtener información de la ciudad por nombre
            CityOmbd cityOmbd = apiConsult.getCoordsByCityName(cityName);
            City myCity = new City(cityOmbd);

            // Obtener el clima de la ciudad utilizando las coordenadas de la ciudad
            WeatherOmbd weatherOmbd = apiConsult.getWeatherByCoords(myCity.getLatitude(), myCity.getLongitude());
            Weather weather = new Weather(weatherOmbd);

            // Mostrar los resultados
            showResults(myCity, weather);
        } catch (RuntimeException e) {
            // Manejar errores y mostrar mensaje
            System.out.println(e.getMessage());
        }
    }
}
