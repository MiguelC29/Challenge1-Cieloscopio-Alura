package models;

public class Weather {
    private final String currentTemperature;
    private final String weatherCondition;
    private final String maxTemperature;
    private final String minTemperature;
    private final String humidity;
    private final String thermalSensation;
    private final String atmosphericPressure;
    private final String wind;
    private String precipitation;
    private String datePrediction;

    public Weather(WeatherOmbd weatherOmbd) {
        this.currentTemperature = weatherOmbd.main().get("temp");
        this.weatherCondition = weatherOmbd.weather().get(0).get("description");
        this.maxTemperature = weatherOmbd.main().get("temp_max");
        this.minTemperature = weatherOmbd.main().get("temp_min");
        this.humidity = weatherOmbd.main().get("humidity");
        this.thermalSensation = weatherOmbd.main().get("feels_like");
        this.atmosphericPressure = weatherOmbd.main().get("pressure");
        this.wind = weatherOmbd.wind().get("speed");

        // Si no existe la clave rain, mandamos un mensaje por defecto, de lo contrario obtenemos el valor
        if (weatherOmbd.rain() == null) {
            this.precipitation = "Valor no informado";
        } else {
            if (weatherOmbd.rain().get("1h") != null) {
                this.precipitation = weatherOmbd.rain().get("1h") + " mm";
            } else if (weatherOmbd.rain().get("3h") != null) {
                this.precipitation = weatherOmbd.rain().get("3h") + " mm";
            }
        }

        //Date Prediction
        if (weatherOmbd.dt_txt() != null) {
            this.datePrediction = weatherOmbd.dt_txt();
        }
    }

    public void showWeatherData() {
        System.out.println("----------------------------------------------------------");
        System.out.println("|                  Reporte del Clima                     |");
        System.out.println("----------------------------------------------------------");
        System.out.printf("| %-25s : %23s °C |\n", "Temperatura actual", currentTemperature);
        System.out.printf("| %-25s : %26s |\n", "Condición climática", capitalizeFirstLetter(weatherCondition));
        System.out.println("----------------------------------------------------------");
        System.out.printf("| %-25s : %23s °C |\n", "Temperatura mínima", minTemperature);
        System.out.printf("| %-25s : %23s °C |\n", "Temperatura máxima", maxTemperature);
        System.out.printf("| %-25s : %23s °C |\n", "Sensación térmica", thermalSensation);
        System.out.println("----------------------------------------------------------");
        System.out.printf("| %-25s : %23s %%  |\n", "Humedad", humidity);
        System.out.printf("| %-25s : %22s hPa |\n", "Presión atmosférica", atmosphericPressure);
        System.out.println("----------------------------------------------------------");
        System.out.printf("| %-25s : %22s m/s |\n", "Viento", wind);
        System.out.printf("| %-25s : %26s |\n", "Precipitación", precipitation);
        System.out.println("----------------------------------------------------------");
    }

    public void showWeatherPredictionData() {
        System.out.printf("| %-25s : %26s |\n", "Fecha", datePrediction.substring(0, 10));
        System.out.printf("| %-25s : %26s |\n", "Condición climática", capitalizeFirstLetter(weatherCondition));
        System.out.println("----------------------------------------------------------");
        System.out.printf("| %-25s : %23s °C |\n", "Temperatura", currentTemperature);
        System.out.printf("| %-25s : %23s °C |\n", "Temperatura mínima", minTemperature);
        System.out.printf("| %-25s : %23s °C |\n", "Temperatura máxima", maxTemperature);
        System.out.printf("| %-25s : %23s °C |\n", "Sensación térmica", thermalSensation);
    }

    private String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
