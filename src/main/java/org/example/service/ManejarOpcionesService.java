package org.example.service;

import org.example.model.Moneda;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public final class ManejarOpcionesService {

    public static void hacerSegunOpcion(int opcion, List<String> historialConversion) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        switch (opcion){
            case 1:
                Moneda.imprimirListaMonedas();
                break;
            case 2:
                double resultadoConversion;

                System.out.print("Introduce la moneda que tienes (por ejemplo, USD, EUR, etc.): ");
                String monedaOrigenInput = scanner.nextLine().toUpperCase();

                System.out.print("Introduce la moneda a la que deseas cambiar (por ejemplo, USD, EUR, etc.): ");
                String monedaDestinoInput = scanner.nextLine().toUpperCase();

                System.out.printf("Introduce cantidad a cambiar en %s:", monedaOrigenInput);
                double valor = scanner.nextDouble();
                scanner.nextLine();
                System.out.println();

                resultadoConversion = CambioMoneda.getCambio(valor, monedaOrigenInput, monedaDestinoInput);

                historialConversion.add(valor + " " + monedaOrigenInput + " =>>> "
                        + resultadoConversion + " " + monedaDestinoInput);
                break;
            case 3:
                if (historialConversion.isEmpty()){
                    System.out.println("No se han hecho conversiones");
                    break;
                }
                historialConversion.forEach(System.out::println);
                System.out.println();
                break;
            case 4:
                historialConversion.clear();
                historialConversion.add("SALIR");
                break;
        }
    }
}
