import com.google.gson.Gson;
import modelo.Moedas;

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

        URI endereco = URI.create("https://www.exchangerate-api.com/docs/java-currency-api");


        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        HttpResponse<String> response = HttpClient
                .newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());




        System.out.println(response.statusCode());
        System.out.println(response.body());




    }
}
