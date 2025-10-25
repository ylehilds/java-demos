package dev.lehi.todo;

// FetchTodoJackson.java
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

// A simple record to hold the JSON response
record Todo(int userId, int id, String title, boolean completed) {}

public class FetchTodoJackson {
    public static void main(String[] args) throws Exception {
        // 1) Make HTTP request
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(
            URI.create("https://jsonplaceholder.typicode.com/todos/1")
        ).build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // 2) Parse JSON into a Todo object
        ObjectMapper mapper = new ObjectMapper();
        Todo todo = mapper.readValue(response.body(), Todo.class);

        // 3) Display the result
        System.out.printf("""
            Todo #%d
            Title: %s
            Completed: %s
            UserId: %d
            """, todo.id(), todo.title(), todo.completed(), todo.userId());
    }
}