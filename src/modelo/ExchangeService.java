package modelo;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeService {
    public double recuperarMoeda(String tipo) throws IOException, InterruptedException {

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/5380d28b267ab7458bb7bd84/latest/BRL");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        HttpClient client = HttpClient.newBuilder().build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        Moedas moedas = gson.fromJson(response.body(), Moedas.class);
        double moedaConvertida = moedas.conversion_rates().get(tipo.toUpperCase());
        return moedaConvertida;

    }
}
