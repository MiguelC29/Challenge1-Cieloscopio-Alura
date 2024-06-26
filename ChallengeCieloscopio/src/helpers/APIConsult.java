package helpers;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import models.CityOmbd;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class APIConsult {
    public CityOmbd getCityByName(String cityName) {
        URI url = URI.create("http://api.openweathermap.org/geo/1.0/direct?appid=24b427e1bdc32c4d61cd3eb9256359e8&limit=1&q=" +
                URLEncoder.encode(cityName, StandardCharsets.UTF_8));

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Deserializar la respuesta en una lista de CityOmbd
            List<CityOmbd> cities = gson.fromJson(response.body(), new TypeToken<List<CityOmbd>>(){}.getType());

            // Retornar el primer elemento de la lista si existe
            if (cities != null && !cities.isEmpty()) {
                return cities.get(0);
            } else {
                throw new RuntimeException("No se encontraron ciudades.");
            }
        } catch (Exception e) {
            throw new RuntimeException("No se encontro la ciudad especificada ");
        }
    }

    public void getCityByCoords() {

    }
}
