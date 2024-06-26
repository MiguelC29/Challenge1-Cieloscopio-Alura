import helpers.APIConsult;
import models.City;
import models.CityOmbd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido");

        System.out.println("Escribe el nombre de la ciudad a consultar: ");
        var cityName = teclado.nextLine();

        APIConsult apiConsult = new APIConsult();
        CityOmbd cityOmbd = apiConsult.getCityByName(cityName);

        if (cityOmbd != null) {
            City myCity = new City(cityOmbd);
            System.out.println(myCity);
        } else {
            System.out.println("No se pudo obtener la información de la ciudad.");
        }


    }
}
