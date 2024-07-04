import helpers.APIConsult;
import models.*;

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
            "Quito", "San Salvador", "Montevideo", "Caracas", "Panamá", "La Habana"
    };

    public static void main(String[] args) {
        System.out.println("Challenge Cieloscopio \nBienvenido al CielosCopio\n");
        while (true) {
            int option = getUserOption(); // Obtener la opción seleccionada por el usuario

            // Salir del programa si la opción es 0
            if (option == 0) {
                System.out.println("Saliendo del programa... ¡Gracias por usar el CielosCopio!💛");
                input.close();
                break;
            }

            // Obtener el nombre de la ciudad según la opción seleccionada
            String cityName = getCityName(option);

            // Realizar la consulta si se obtuvo un nombre de ciudad válido
            boolean isValidQuery = makeQuery(cityName,false); // Realizar consulta sin predicción

            if (isValidQuery) {
                int optionPrediction = getPredictionOption(); // Obtener la opción de predicción del usuario

                // Si la opción es 1, mostrar predicción del clima
                if (optionPrediction == 1) {
                    makeQuery(cityName,true); // Realizar consulta con predicción
                    System.out.println("\nVolviendo al menú principal..");
                }
            }
        }
    }

    // Método para obtener la opción seleccionada por el usuario del menú principal
    private static int getUserOption() {
        while (true) {
            showMenu(); // Mostrar el menú principal
            try {
                System.out.println("Ingrese una opción del menú");
                int option = input.nextInt();
                input.nextLine(); // Limpiar el buffer del scanner

                // Verifica si la opción está en el rango de las opciones predefinidas (0 a 12)
                if (option >= 0 && option <= 12) {
                    return option;
                } else { // Si la opción no es válida (fuera del rango 0-12)
                    System.err.println("Opción incorrecta ingrese una opción del menú");
                }
            } catch (InputMismatchException e) {
                System.err.println("Entrada inválida. Por favor, introduce un número entero.");
                input.next(); // Limpiar el buffer del scanner.
            }
        }
    }

    // Método para obtener la opción seleccionada por el usuario del submenú de predicción
    private static int getPredictionOption() {
        while (true) {
            System.out.println("\n1. Mostrar predicción del clima de los proximos 3 días \n0. Volver");
            System.out.println("Nota: Los datos de las predicciones corresponden al mediodía (12:00 PM).");

            try {
                System.out.println("Ingrese una opción del menú");
                int option = input.nextInt();
                input.nextLine(); // Limpiar el buffer del scanner

                if (option == 1 || option == 0){
                    return option;
                } else {
                    System.err.println("Opción incorrecta ingrese una opción del menú");
                }
            } catch (InputMismatchException e) {
                System.err.println("Entrada inválida. Por favor, introduce un número entero.");
                input.next(); // Limpiar el buffer del scanner.
            }
        }
    }

    // Método para obtener el nombre de la ciudad según la opción seleccionada
    private static String getCityName(int option) {
        String cityName = "";
        // Verifica si la opción está en el rango de las opciones predefinidas (1 a 11)
        if (option >= 1 && option <= 11) {
            cityName = cities[option -1]; // Retorna el nombre de la ciudad correspondiente a la opción seleccionada
        } else if (option == 12) {     // Si la opción es 12, se pide al usuario que ingrese el nombre de una ciudad
            do {
                System.out.println("Escriba el nombre de una ciudad: ");
                cityName = input.nextLine(); // Retorna el nombre de la ciudad ingresada por teclado
            } while (cityName.isEmpty());
        }
        return cityName;
    }

    // Método para realizar la consulta a la API y mostrar los resultados
    private static boolean makeQuery(String cityName, boolean givePrediction) {
        boolean foundCity;
        try {
            APIConsult apiConsult = new APIConsult();
            CityOmbd cityOmbd;

            // Obtener información de la ciudad por nombre
            cityOmbd = apiConsult.getCoordsByCityName(cityName);
            foundCity = true;

            City myCity = new City(cityOmbd);
            // Obtener el clima de la ciudad utilizando las coordenadas de la ciudad
            WeatherOmbd weatherOmbd = apiConsult.getWeatherByCoords(myCity.getLatitude(), myCity.getLongitude());
            Weather weather = new Weather(weatherOmbd);

            // Mostrar los resultados
            if (givePrediction) {
                showWeatherPrediction(myCity);
            } else {
                showResults(myCity, weather);
            }
        } catch (RuntimeException e) {
            // Manejar errores y mostrar mensaje
            System.err.println(e.getMessage());
            foundCity = false;
        }
        return foundCity;
    }

    // Método para mostrar los resultados del clima
    private static void showResults(City city, Weather weather) {
        System.out.println("----------------------------------------------------------");
        System.out.println("|                        Resultado                       |");
        System.out.println("----------------------------------------------------------");
        System.out.printf("| %-25s : (%s) - %-19s |\n", "Ciudad", city.getCountry(), city.getName());
        System.out.printf("| %-25s : %-26s |\n", "Fecha", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.printf("| %-25s : %-26s |\n", "Horario", LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        weather.showWeatherData();
    }

    // Método para mostrar el menú de opciones
    private static void showMenu() {
        System.out.println("------------------------------------------------------------");
        System.out.println("|                        Cieloscopio                       |");
        System.out.println("------------------------------------------------------------");
        System.out.println("""
                | Elige una ciudad para obtener los datos meteorológicos:  |
                |  1. Ciudad de México - (MX)                              |
                |  2. Buenos Aires - (AR)                                  |
                |  3. Bogotá - (CO)                                        |
                |  4. Lima - (PE)                                          |
                |  5. Santiago de Chile - (CL)                             |
                |  6. Quito - (EC)                                         |
                |  7. San Salvador - (SV)                                  |
                |  8. Montevideo - (UY)                                    |
                |  9. Caracas - (VE)                                       |
                | 10. Panamá - (PA)                                        |
                | 11. La Habana - (CU)                                     |
                | 12. Desea consultar otra ciudad                          |
                |  0. Salir                                                |
                ------------------------------------------------------------""");
    }

    // Método para mostrar la predicción del clima
    private static void showWeatherPrediction(City myCity) {
        try {
            APIConsult apiConsult = new APIConsult();
            // Obtener la predicción del clima para los próximos días usando las coordenadas de la ciudad
            WeatherPredictionOmbd weatherPredictionOmbd = apiConsult.getWeatherPredictionsByCoords(myCity.getLatitude(), myCity.getLongitude());
            System.out.println("----------------------------------------------------------");
            System.out.println("|                  Predicción del Clima                  |");
            System.out.println("----------------------------------------------------------");
            // Iterar sobre la lista de predicciones y mostrar solo los datos del mediodía
            for (WeatherOmbd weather1 : weatherPredictionOmbd.list()) {
                if (weather1.dt_txt().substring(11).equals("12:00:00")) {
                    Weather weatherPrediction1 = new Weather(weather1);
                    weatherPrediction1.showWeatherPredictionData();
                    System.out.println("+--------------------------------------------------------+");
                }
            }
        } catch (RuntimeException e) {
            // Manejar errores y mostrar mensaje
            System.err.println(e.getMessage());
        }
    }
}
