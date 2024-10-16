package org.example.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.*;

public final class CambioMoneda {

    public static Double getCambio(double valor,String monedaOrigenInput, String monedaDestinoInput) throws IOException, InterruptedException {

        String url = "https://v6.exchangerate-api.com/v6/8b15bb5843d03119213936ff/latest/" + monedaOrigenInput;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(response.body());

        double factorCambio = rootNode.path("conversion_rates").path(monedaDestinoInput).asDouble();

        double resultado = valor * factorCambio;

        System.out.printf("El valor %.2f [%s] corresponde al valor final de =>>> %.2f [%s]%n%n",
                    valor, monedaOrigenInput, resultado, monedaDestinoInput);

        return resultado;

    }
}
