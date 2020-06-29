package microservicesTestCase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileControl {
	static String localDBPath = "/home/sep/Desktop/src_microservice/spring-boot-microservice-patient-service/src/main/resources/local-db.txt";
	static String remoteDBPath = "/home/sep/Desktop/src_microservice/spring-boot-microservice-patient-service/src/main/resources/remote-db.txt";
	static String logDBPath = "/home/sep/Desktop/src_microservice/spring-boot-microservice-patient-service/src/main/resources/log-db.txt";
	static String authorizationLocalDB = "/home/sep/Desktop/src_microservice/spring-boot-microservice-authorization-service/src/main/resources/local-db.txt";
	static String authenticationLocalDB = "/home/sep/Desktop/src_microservice/spring-boot-microservice-authentication-service/src/main/resources/local-db.txt";
	static String simulationLocalDB = "/home/sep/eclipse-workspace/microservicesTestCase/src/microservicesTestCase/SimulationTiming.txt";
	
	private static void emptyFile(String path) throws IOException{
		PrintWriter writer = new PrintWriter(path);
		writer.print("");
		writer.close();
	}
	
	public static void enterTiming(Long time) throws IOException{
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(simulationLocalDB, true)));;
		writer.println(time.toString());
		writer.close();
	}
	
	public static void enterTitle(String title) throws IOException{
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(simulationLocalDB, true)));;
		writer.println();
		writer.println(title);
		writer.close();
	}
	
	public static void mendEverything() throws IOException {
		emptyFile(localDBPath);
		emptyFile(remoteDBPath);
		emptyFile(logDBPath);
		emptyFile(authorizationLocalDB);
		emptyFile(authenticationLocalDB);
	}
	
	
}
