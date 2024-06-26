package models;

public class City {
    private String name;
    private String country;
    private String latitude;
    private String longitude;

    public City(CityOmbd cityOmbd) {
        this.name = (cityOmbd.local_names() != null) ? cityOmbd.local_names().get("es") : cityOmbd.name(); // Obtener el nombre en español si existe, de lo contrario usar el nombre original
        this.country = cityOmbd.country();
        this.latitude = cityOmbd.lat();
        this.longitude = cityOmbd.lon();
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Ciudad ='" + name + '\'' +
                ", país=" + country +
                ", latitud=" + latitude +
                ", longitud=" + longitude;
    }
}
