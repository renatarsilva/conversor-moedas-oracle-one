import com.google.gson.Gson;
import modelo.Moedas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o valor que gostaria de converter:");
        Double valor = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite o tipo da moeda");
        String tipo = sc.nextLine();


        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/5380d28b267ab7458bb7bd84/latest/BRL");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {

            HttpClient client = HttpClient.newBuilder().build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            Moedas moedas = gson.fromJson(response.body(), Moedas.class);

            double moedaConvertida = moedas.conversion_rates().get(tipo);

            double conversao = valor * moedaConvertida;

            System.out.println(conversao);

        } catch (RuntimeException | IOException e) {
            System.out.println("Deu erro");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
