package helpers;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import models.CityOmbd;
import models.WeatherOmbd;
import models.WeatherPredictionOmbd;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class APIConsult {
    // Configuramos un objeto Gson para deserializar JSON con nombres de campos en minúsculas y guiones bajos
    private final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    // Creamos un cliente HTTP que se utilizará para enviar solicitudes
    private static final HttpClient client = HttpClient.newHttpClient();
    private final String BASE_URL = "http://api.openweathermap.org/";

    // Método para obtener información de una ciudad por su nombre
    public CityOmbd getCoordsByCityName(String cityName) {
        // Construimos la URL para la solicitud HTTP utilizando el nombre de la ciudad y la clave de la API desde las variables de entorno
        URI url = URI.create(BASE_URL + "geo/1.0/direct?appid=" +
                System.getenv("WEATHER_API_KEY") +
                "&limit=1&q=" + URLEncoder.encode(cityName, StandardCharsets.UTF_8));

        // Creamos la solicitud HTTP utilizando la URL generada
        var request = createRequest(url);

        try {
            // Enviamos la solicitud HTTP y obtenemos la respuesta
            var response = sendRequest(request);

            // Deserializamos la respuesta JSON en una lista de objetos CityOmbd
            List<CityOmbd> cities = gson.fromJson(response.body(), new TypeToken<List<CityOmbd>>(){}.getType());

            // Retornamos el primer elemento de la lista si existe, o lanzamos una excepción si no se encontraron ciudades
            if (cities != null && !cities.isEmpty()) {
                return cities.get(0);
            } else {
                throw new RuntimeException("No se encontraron ciudades.");
            }
        } catch (Exception e) {
            // Lanzamos una excepción si ocurre algún error durante la solicitud o deserialización
            throw new RuntimeException("No se encontro la ciudad especificada.");
        }
    }

    // Método para obtener el clima de una ciudad utilizando sus coordenadas (latitud y longitud)
    public WeatherOmbd getWeatherByCoords(String lat, String lon) {
        // Construimos la URL para la solicitud HTTP utilizando las coordenadas y la clave de la API desde las variables de entorno
        URI url = URI.create(BASE_URL + "data/2.5/weather?appid=" +
                System.getenv("WEATHER_API_KEY") +
                "&lang=es&units=metric&lat=" + lat + "&lon=" + lon);

        // Creamos la solicitud HTTP utilizando la URL generada
        var request = createRequest(url);

        try {
            // Enviamos la solicitud HTTP y obtenemos la respuesta
            var response = sendRequest(request);
            // Deserializamos la respuesta JSON en un objeto WeatherOmbd y lo retornamos
            return gson.fromJson(response.body(), WeatherOmbd.class);
        } catch (Exception e) {
            // Lanzamos una excepción si ocurre algún error durante la solicitud o deserialización
            throw new RuntimeException("No se encontraron los datos del clima de la ciudad especificada ");
        }
    }

    public WeatherPredictionOmbd getWeatherPredictionsByCoords(String lat, String lon) {
        // Construimos la URL para la solicitud HTTP utilizando las coordenadas y la clave de la API desde las variables de entorno
        URI url = URI.create(BASE_URL + "data/2.5/forecast?appid=" +
                System.getenv("WEATHER_API_KEY") +
                "&lang=es&units=metric&cnt=20&lat=" + lat + "&lon=" + lon);

        // Creamos la solicitud HTTP utilizando la URL generada
        var request = createRequest(url);

        try {
            // Enviamos la solicitud HTTP y obtenemos la respuesta
            var response = sendRequest(request);
            return gson.fromJson(response.body(), WeatherPredictionOmbd.class);
        }  catch (Exception e) {
            // Lanzamos una excepción si ocurre algún error durante la solicitud o deserialización
            throw new RuntimeException("No se encontraron los datos de la predicción del clima de la ciudad especificada " + e.getMessage());
        }
    }

    // Método estático para crear una solicitud HTTP
    public static HttpRequest createRequest(URI url) {
        return HttpRequest.newBuilder()
                .uri(url)
                .build();
    }

    // Método estático para enviar una solicitud HTTP y obtener la respuesta
    public static HttpResponse<String> sendRequest(HttpRequest request) throws IOException, InterruptedException {
        return client
                .send(request, HttpResponse.BodyHandlers.ofString());
    }
}
