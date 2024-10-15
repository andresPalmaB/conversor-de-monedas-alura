package org.example.model;

public enum Moneda {
    COP,
    BRL,
    ARS,
    SALIR;

    public static String getMoneda(int numero){
        switch (numero){
            case 1, 2:
                return ARS.toString();
            case 3, 4:
                return BRL.toString();
            case 5, 6:
                return COP.toString();
            default:
                return SALIR.toString();
        }
    }
}
