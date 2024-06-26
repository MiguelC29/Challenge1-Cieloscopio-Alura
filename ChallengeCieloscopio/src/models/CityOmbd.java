package models;

import java.util.Map;

public record CityOmbd(
        String name,
        String lat,
        String lon,
        Map<String, String> local_names
) {
}
