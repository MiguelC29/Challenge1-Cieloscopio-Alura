package models;

public class Weather {
    private String currentTemperature;
    private String weatherCondition;
    private String maxTemperature;
    private String minTemperature;

    public Weather(WeatherOmbd weatherOmbd) {
        this.currentTemperature = weatherOmbd.main().get("temp");
        this.weatherCondition = weatherOmbd.weather().get(0).get("description");
        this.maxTemperature = weatherOmbd.main().get("temp_max");
        this.minTemperature = weatherOmbd.main().get("temp_min");
    }

    public void showWeatherData() {
        System.out.println("Temperatura actual: " + currentTemperature);
        System.out.println("Condición Climática: " + weatherCondition);
        System.out.println("");
        System.out.println("Temperatura mínima: " + minTemperature);
        System.out.println("Temperatura máxima: " + maxTemperature);
    }
}
