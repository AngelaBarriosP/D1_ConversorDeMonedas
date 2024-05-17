package com.alura.conversormonedas.modelos;

public class CalcularTasaDeCambio {

    public double calcularConversion(MonedaBuscada monedaBuscada, double valorAConvertir){
        double resultadoConversion = valorAConvertir * monedaBuscada.conversion_rate();
        return resultadoConversion;
    }
}
