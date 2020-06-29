package microservicesTestCase;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GetRequest {
	private static Long templeteGet(String url) throws IOException, InterruptedException {		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		var temp = HttpResponse.BodyHandlers.ofString();
		
		Long timestamp = ((Long) System.currentTimeMillis());
		HttpResponse<String> response = client.send(request, temp);
		return ((Long) System.currentTimeMillis()) - timestamp;
	}
	
	public static Long simpleGet() throws IOException, InterruptedException {
		return templeteGet("http://localhost:8040/authorization/access/user/to/patient-service");
	}
	
	public static Long complexGet() throws IOException, InterruptedException {
		return templeteGet("http://localhost:8040/user/medical-history/name/Alice");
	}
	
	public static Long breakTheGlassGet() throws IOException, InterruptedException {
		return templeteGet("http://localhost:8040/authorization/btg/for/user");
	}
}
