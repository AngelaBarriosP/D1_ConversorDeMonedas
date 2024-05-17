package com.alura.conversormonedas.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public MonedaBuscada buscaMoneda(String conversionElegida){
        String apiKey = "37a275ffe4c7ae305e7422af";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/37a275ffe4c7ae305e7422af/pair/"+conversionElegida);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), MonedaBuscada.class);
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
