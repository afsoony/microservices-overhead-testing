package microservicesTestCase;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostRequest {

	public static Long authenticatePost() throws IOException, InterruptedException {
		
		String requestBody = "username=user&password=pass";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.POST(HttpRequest.BodyPublishers.ofString(requestBody))
				.uri(URI.create("http://localhost:8040/auth"))
				.setHeader("User-Agent", "Java 11 HttpClient Bot")
				.header("Content-Type", "application/x-www-form-urlencoded")
				.build();
		var temp = HttpResponse.BodyHandlers.ofString();
		
		Long timestamp = ((Long) System.currentTimeMillis());
		HttpResponse<String> response = client.send(request, temp);
		return ((Long) System.currentTimeMillis()) - timestamp;
	}
}
