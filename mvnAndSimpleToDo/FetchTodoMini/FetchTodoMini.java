// FetchTodoMini.java
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FetchTodoMini {
    public static void main(String[] args) throws Exception {
        var client  = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create("https://jsonplaceholder.typicode.com/todos/1")).build();
        var resp    = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = resp.body();

        // crude extraction without any library
        String id        = extract(json, "\"id\":", ",");
        String title     = extract(json, "\"title\":", ",");
        String completed = extract(json, "\"completed\":", ",");
        String userId    = extract(json, "\"userId\":", "}");

        System.out.println("Todo #" + id);
        System.out.println("Title: " + title.replaceAll("\"", "").trim());
        System.out.println("Completed: " + completed.trim());
        System.out.println("User ID: " + userId.trim());
    }

    // helper to pull value between a key and the next delimiter
    private static String extract(String json, String key, String endDelim) {
        int start = json.indexOf(key);
        if (start == -1) return "N/A";
        start += key.length();
        int end = json.indexOf(endDelim, start);
        if (end == -1) end = json.length();
        return json.substring(start, end).trim();
    }
}