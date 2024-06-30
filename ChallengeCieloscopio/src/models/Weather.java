package models;

public class Weather {
    private final String currentTemperature;
    private final String weatherCondition;
    private final String maxTemperature;
    private final String minTemperature;
    private String precipitation;

    public Weather(WeatherOmbd weatherOmbd) {
        this.currentTemperature = weatherOmbd.main().get("temp");
        this.weatherCondition = weatherOmbd.weather().get(0).get("description");
        this.maxTemperature = weatherOmbd.main().get("temp_max");
        this.minTemperature = weatherOmbd.main().get("temp_min");

        // Si no existe la clave rain, mandamos un mensaje por defecto, de lo contrario obtenemos el valor
        if (weatherOmbd.rain() == null) {
            this.precipitation = "Valor no informado";
        } else {
            if (!weatherOmbd.rain().get("1h").isEmpty()) {
                this.precipitation = weatherOmbd.rain().get("1h");
            } else if (!weatherOmbd.rain().get("3h").isEmpty()) {
                this.precipitation = weatherOmbd.rain().get("3h");
            }
        }
    }

    public void showWeatherData() {
        System.out.println("Temperatura actual: " + currentTemperature + "°C");
        System.out.println("Condición climática: " + weatherCondition.toUpperCase().charAt(0) + weatherCondition.substring(1) + "\n");
        System.out.println("Temperatura mínima: " + minTemperature + "°C");
        System.out.println("Temperatura máxima: " + maxTemperature + "°C");
        System.out.println("Precipitación: " + precipitation);
    }
}
