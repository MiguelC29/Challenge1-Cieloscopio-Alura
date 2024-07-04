package models;

import java.util.List;
import java.util.Map;

public record WeatherOmbd(
        List<Map<String, String>> weather,
        Map<String, String> main,
        Map<String, String> wind,
        Map<String, String> rain,
        String dt_txt
) {
}
