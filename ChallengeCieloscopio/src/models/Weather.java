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
            if (!weatherOmbd.rain().get("1h").isEmpty()) {
                this.precipitation = weatherOmbd.rain().get("1h") + " mm";
            } else if (!weatherOmbd.rain().get("3h").isEmpty()) {
                this.precipitation = weatherOmbd.rain().get("3h") + " mm";
            }
        }
    }

    public void showWeatherData() {
        System.out.println("Temperatura actual: " + currentTemperature + "°C");
        System.out.println("Condición climática: " + weatherCondition.toUpperCase().charAt(0) + weatherCondition.substring(1) + "\n");

        System.out.println("Temperatura mínima: " + minTemperature + "°C");
        System.out.println("Temperatura máxima: " + maxTemperature + "°C");
        System.out.println("Sensación térmica: " + thermalSensation + "°C\n");

        System.out.println("Humedad: " + humidity + "%");
        System.out.println("Presión atmosférica: " + atmosphericPressure + " hPa\n");

        System.out.println("Viento: " + wind + " m/s");
        System.out.println("Precipitación: " + precipitation);
    }
}
