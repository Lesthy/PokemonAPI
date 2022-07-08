import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String URL = "https://pokeapi.co/api/v2/pokemon/ditto"; //link to retrieve info from

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("name", "application/json")
                .uri(URI.create(URL)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); //method for retrieving
        //client and response

        JsonObject jsonObject = new JsonParser().parse(response.body()).getAsJsonObject(); //converted body to Json object

        System.out.println(jsonObject.get("name")); //get Json object property key "name"
    }
}