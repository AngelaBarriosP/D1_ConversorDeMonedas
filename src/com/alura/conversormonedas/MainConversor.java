package com.alura.conversormonedas;

import com.alura.conversormonedas.modelos.CalcularTasaDeCambio;
import com.alura.conversormonedas.modelos.ConsultaMoneda;
import com.alura.conversormonedas.modelos.MonedaBuscada;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MainConversor {
    public static void main(String[] args) {
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        Scanner lectura = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");

        try {
            while (true) {
                String conversionElegida = "";
                System.out.println("""
                        *****************************************************
                        Sea bienvenido/a al Conversor de Moneda =]
                        1)	Dólar =>> Peso argentino
                        2)	Peso argentino =>> Dólar
                        3)	Dólar =>> Real brasileño
                        4)	Real brasileño =>> Dólar
                        5)	Dólar =>> Peso colombiano
                        6)	Peso colombiano =>> Dólar
                        7)	Salir
                        Elija una opción válida:
                        *****************************************************
                        """);
                var opcionUsuario = Integer.valueOf(lectura.nextLine());

                switch (opcionUsuario) {
                    case 1:
                        conversionElegida = "USD/ARS";
                        break;
                    case 2:
                        conversionElegida = "ARS/USD";
                        break;
                    case 3:
                        conversionElegida = "USD/BRL";
                        break;
                    case 4:
                        conversionElegida = "BRL/USD";
                        break;
                    case 5:
                        conversionElegida = "USD/COP";
                        break;
                    case 6:
                        conversionElegida = "COP/USD";
                        break;
                    case 7:
                        System.out.println("¡Gracias por usar nuestros servicios!");
                        break;
                    default:
                        break;
                }
                if (opcionUsuario == 7) {
                    break;
                }
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
