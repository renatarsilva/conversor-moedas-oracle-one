import com.google.gson.Gson;
import modelo.ExchangeService;
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


        try {

            ExchangeService exchangeService = new ExchangeService();
            double moedaConvertida = exchangeService.recuperarMoeda(tipo);

            double conversao = valor * moedaConvertida;
            System.out.println(conversao);

        } catch (RuntimeException | IOException e) {
            System.out.println("Deu erro");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
