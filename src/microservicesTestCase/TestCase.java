package microservicesTestCase;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class TestCase {
	private static int[] interactionNumbers = {1,10,20,30,40,50};
	private static int loop = 60;
	private static String policyNumber = "2";
	private static int ratio = 5;

	public static void senario1() throws IOException, InterruptedException {	
		for (int n : interactionNumbers) {
			FileControl.enterTitle("Policy  " + policyNumber + " - Senario 1 - " + Integer.toString(n));
			
			for (int i=1 ;  i <= loop ; i++) {
				FileControl.mendEverything();
				Long accumulatedTime = 0L;
				
				accumulatedTime += PostRequest.authenticatePost();

				
				for (int j=1 ; j<n+1 ; j++) {
					accumulatedTime += GetRequest.simpleGet();
				}
				
				System.out.println("Policy " + policyNumber + " - Senario 1 - " + Integer.toString(n) + " - " + Integer.toString(i));
				FileControl.enterTiming(accumulatedTime);
			}
		}
	}
	
	public static void senario2() throws IOException, InterruptedException {		
		for (int n : interactionNumbers) {
			FileControl.enterTitle("Policy " + policyNumber + " - Senario 2 - " + Integer.toString(n));
			
			for (int i=1 ;  i <= loop ; i++) {
				FileControl.mendEverything();
				Long accumulatedTime = 0L;
				
				accumulatedTime += PostRequest.authenticatePost();
				accumulatedTime += GetRequest.breakTheGlassGet();
				
				for (int j=1 ; j<n+1 ; j++) {
					accumulatedTime += GetRequest.complexGet();
					TimeUnit.MILLISECONDS.sleep(50);
				}
				System.out.println("Policy " + policyNumber + " - Senario 2 - " + Integer.toString(n) + " - " + Integer.toString(i));
				FileControl.enterTiming(accumulatedTime);
			}
		}
	}
	
	public static void senario3() throws IOException, InterruptedException {	
		for (int n : interactionNumbers) {
			FileControl.enterTitle("Policy " + policyNumber + " - Senario 3 - " + Integer.toString(n));
			
			for (int i=1 ;  i <= loop ; i++) {
				
				ArrayList<Integer> actionType = new ArrayList<Integer>();
				for (int m = 1 ; m <= n/ratio ; m++) { actionType.add(1); }
				for (int m = 1 ; m <= n-(n/ratio) ; m++) { actionType.add(0); }
				
				Random generator = new Random(i);
				
				FileControl.mendEverything();
				Long accumulatedTime = 0L;
				
				accumulatedTime += PostRequest.authenticatePost();
				accumulatedTime += GetRequest.breakTheGlassGet();
				
				for (int j=n ; j>0 ; j--) {
					int k = generator.nextInt(j);
					if (actionType.get(k) == 0) {
						accumulatedTime += GetRequest.simpleGet();
					} else {
						accumulatedTime += GetRequest.complexGet();
					}
					actionType.remove(k);
				}
				System.out.println("Policy " + policyNumber + " - Senario 3 - " + Integer.toString(n) + " - " + Integer.toString(i));
				FileControl.enterTiming(accumulatedTime);
			}
			
		}
	}
	
	public static void senario4() throws IOException, InterruptedException {	
		for (int n : interactionNumbers) {
			FileControl.enterTitle("Policy " + policyNumber + " - Senario 4 - " + Integer.toString(n));
			
			for (int i=1 ;  i <= loop ; i++) {
				
				ArrayList<Integer> actionType = new ArrayList<Integer>();
				for (int m = 1 ; m <= n/ratio ; m++) { actionType.add(1); }
				for (int m = 1 ; m <= n-(n/ratio) ; m++) { actionType.add(0); }
				
				Random generator = new Random(i);
				
				FileControl.mendEverything();
				Long accumulatedTime = 0L;
								
				for (int j=n ; j>0 ; j--) {
					int k = generator.nextInt(j);
					if (actionType.get(k) == 0) {
						accumulatedTime += PostRequest.authenticatePost();
						accumulatedTime += GetRequest.simpleGet();
					} else {
						accumulatedTime += PostRequest.authenticatePost();
						accumulatedTime += GetRequest.breakTheGlassGet();
						accumulatedTime += GetRequest.complexGet();
					}
					TimeUnit.MILLISECONDS.sleep(100);
					actionType.remove(k);
				}
				System.out.println("Policy " + policyNumber + " - Senario 4 - " + Integer.toString(n) + " - " + Integer.toString(i));
				FileControl.enterTiming(accumulatedTime);
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		//senario1();
		senario2();
		//senario3();
		//senario4();
	}

}
