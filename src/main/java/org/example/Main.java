package org.example;

import org.example.model.Moneda;
import org.example.service.CambioMoneda;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {

            System.out.println("********************************");
            System.out.println("Sea bienvenido/a al conversor de moneda\n");
            do{
                System.out.println("1) Dolar =>>> Peso Argentino\n" +
                                "2) Peso Argentino =>>> Dolar\n" +
                                "3) Dolar =>>> Real Brasileño\n" +
                                "4) Real Brasileño =>>> Dolar\n" +
                                "5) Dolar =>>> Peso Colombiano\n" +
                                "6) Peso Colombiano =>>> Dolar\n" +
                                "7) Salir");
                System.out.print("Elija una opcion valida: ");
                opcion = scanner.nextLine();
                System.out.println();

                System.out.println("********************************\n");
                if (opcion.matches("^[1-7]$")){
                    break;
                }
                System.out.print("¡OPCION INVALIDA!\n");
                System.out.println("Las copciones correctas son: \n");
            } while (!opcion.matches("^[1-7]$"));

            int opcionInt = Integer.parseInt(opcion);

            String moneda = Moneda.getMoneda(opcionInt);

            if (moneda.equals("SALIR")){
                break;
            }

            System.out.print("Ingrese el valor que desea convertir: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();
            System.out.println();

            double cambioMoneda = CambioMoneda.getCambio(valor, moneda, opcionInt);

            if ( opcionInt % 2 != 0){
                System.out.printf("El valor %.2f [USD] corresponde al valor final de =>>> %.2f [%s]%n%n",
                        valor, cambioMoneda, moneda);
            } else {
                System.out.printf("El valor %.2f [%s] corresponde al valor final de =>>> %.2f [USD]%n%n",
                        valor, moneda, cambioMoneda);
            }


        } while (opcion.matches("^[1-7]$"));

        System.out.println("¡Gracias por usar el conversor de monedas!");

    }
}