package softablitz;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class HomeAPI {

    public Home HomeAPI() throws IOException, InterruptedException {
        String url = "https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true";

        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

        HttpClient client = HttpClient.newBuilder().build();

        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String JsonObject = (String) response.body();
        Home data = new Gson().fromJson(JsonObject, Home.class);
        return data;
    }
}
