package org.example;

import org.example.service.ManejarOpcionesService;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        String opcion;
        List<String> historialConversiones = new ArrayList<>();

        do {

            System.out.println("********************************");
            System.out.println("Sea bienvenido/a al conversor de moneda\n");
            do{
                System.out.println("1) Obtener Lista de Paices con codigo ISO 4217\n" +
                                "2) Escoger Paices para realizar convercion\n" +
                                "3) Obtener historial de conversiones\n" +
                                "4) Salir");
                System.out.print("Elija una opcion valida: ");
                opcion = scanner.nextLine();
                System.out.println();

                System.out.println("********************************\n");
                if (opcion.matches("^[1-4]$")){
                    break;
                }
                System.out.print("¡OPCION INVALIDA!\n");
                System.out.println("Las copciones correctas son: \n");
            } while (!opcion.matches("^[1-4]$"));

            int opcionInt = Integer.parseInt(opcion);

            ManejarOpcionesService.hacerSegunOpcion(opcionInt, historialConversiones);

            if (historialConversiones.contains("SALIR")){
                break;
            }

        } while (opcion.matches("^[1-4]$"));

        System.out.println("¡Gracias por usar el conversor de monedas!");

    }
}