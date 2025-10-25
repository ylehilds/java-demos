import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

public class FetchTodo {
    public static void main(String[] args) throws Exception {
        var client  = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create("https://jsonplaceholder.typicode.com/todos/10")).build();
        var resp    = client.send(request, HttpResponse.BodyHandlers.ofString());

        try (JsonReader reader = Json.createReader(new StringReader(resp.body()))) {
            JsonObject todo = reader.readObject();
            System.out.println("Todo #" + todo.getInt("id"));
            System.out.println("Title: " + todo.getString("title"));
            System.out.println("Completed: " + todo.getBoolean("completed"));
            System.out.println("User ID: " + todo.getInt("userId"));
        }
    }
}