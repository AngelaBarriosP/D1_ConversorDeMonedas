package com.alura.conversormonedas;

import com.alura.conversormonedas.modelos.*;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MainConversor {
    public static void main(String[] args) {
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        Scanner lectura = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");
        Menu menu = new Menu();
        ConversionSeleccionada conversion = new ConversionSeleccionada();

        try {
            while (true) {
                String conversionElegida = "";
                String monedaOrigen = "";
                String monedaDestino = "";

                System.out.println("""
                        *****************************************************
                        Sea bienvenido/a al Conversor de Moneda =]
                        Digite el número que corresponda con la moneda de origen:
                        """);
                menu.MenuMonedas();
                var opcionUnoUsuario = Integer.valueOf(lectura.nextLine());

                if (opcionUnoUsuario == 7){
                    break;
                }

                System.out.println("""
                        *****************************************************
                        Ahora digite el número que corresponda con la moneda de destino para realizar la conversión:
                        """);
                var opcionDosUsuario = Integer.valueOf(lectura.nextLine());
                menu.MenuMonedas();
                if (opcionDosUsuario == 7) {
                    break;
                }

                monedaOrigen = conversion.monedaSeleccionada(opcionUnoUsuario);
                monedaDestino = conversion.monedaSeleccionada(opcionDosUsuario);

                conversionElegida = monedaOrigen + "/" + monedaDestino;

                MonedaBuscada monedaBuscada = consultaMoneda.buscaMoneda(conversionElegida);
                //System.out.println(monedaBuscada);
                System.out.println("Ingrese el valor que desea convertir:");
                var valorAConvertir = Double.valueOf(lectura.nextLine());
                CalcularTasaDeCambio calculo = new CalcularTasaDeCambio();
                var resultadoConversion = calculo.calcularConversion(monedaBuscada, valorAConvertir);
                System.out.println("El valor " + df.format(valorAConvertir) + " [" + conversionElegida.substring(0, 3) + "] corresponde al valor final de =>>> " + df.format(resultadoConversion) + " [" + conversionElegida.substring(4, 7) + "]");

            }
        } catch (NumberFormatException e){
            System.out.println("Ingrese una opción válida."+e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Entrada no válida."+e.getMessage());
        }
    }
}
