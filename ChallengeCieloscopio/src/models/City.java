package models;

public class City {
    private String name;
    private double latitude;
    private double longitude;

    public City(CityOmbd cityOmbd) {
        this.name = cityOmbd.local_names().getOrDefault("es", cityOmbd.name()); // Obtener el nombre en español si existe, de lo contrario usar el nombre original
        this.latitude = Double.parseDouble(cityOmbd.lat());
        this.longitude = Double.parseDouble(cityOmbd.lon());
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void showData() {
        System.out.println("Ciudad: " + name);
        System.out.println("Longitud: " + longitude);
        System.out.println("Latitud: " + latitude);
    }

    @Override
    public String toString() {
        return "Ciudad ='" + name + '\'' +
                ", latitud=" + latitude +
                ", longitud=" + longitude;
    }
}
