package com.alura.conversormonedas.modelos;

public class ConversionSeleccionada {
    private String monedaElegida;

    public String monedaSeleccionada(int opcionUsuario){
        switch (opcionUsuario) {
            case 1:
                monedaElegida = "ARS";
                break;
            case 2:
                monedaElegida = "BOB";
                break;
            case 3:
                monedaElegida = "BRL";
                break;
            case 4:
                monedaElegida = "CLP";
                break;
            case 5:
                monedaElegida = "COP";
                break;
            case 6:
                monedaElegida = "USD";
                break;
            default:
                break;
        }
        return monedaElegida;
    }
}
