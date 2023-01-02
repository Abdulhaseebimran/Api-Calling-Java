import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Apicalling {
    public static void main(String[] args) throws Exception {
        // Set the API's URL
        String apiURL = "https://jsonplaceholder.typicode.com/todos";

        // Create an HTTP request object
        URL url = new URL(apiURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method and any necessary request properties
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer 123456");

        // Send the request and receive the response
        connection.connect();
        StringBuilder response;
        // Process the response
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            // Process the response
            response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        // Print the response
        System.out.println(response.toString());
    }
}