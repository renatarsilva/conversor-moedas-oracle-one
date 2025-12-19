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


        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/5380d28b267ab7458bb7bd84/latest/BRL");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {

            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
        Gson gson =  new Gson();
        Moedas moedas = gson.fromJson(response.body(), Moedas.class);
            System.out.println(moedas);
        } catch(RuntimeException | IOException e){
            System.out.println("Deu erro");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
