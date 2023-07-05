package ufv.dis.final2022.JRJ;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {

    private static final String API_URL = "https://swapi.dev/api/%s";


    public static String getEntitySwapi(SolicitudDescarga solicitudDescarga) throws IOException, InterruptedException {

        String fullUrl = String.format(API_URL, solicitudDescarga.getPlanets());
        fullUrl = fullUrl + "/" + solicitudDescarga.getId();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fullUrl))
                .GET()
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
