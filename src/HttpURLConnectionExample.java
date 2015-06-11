import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 
import javax.net.ssl.HttpsURLConnection;
public class HttpURLConnectionExample {
	 private final String USER_AGENT = "Mozilla/5.0";
	 
	 public static void main(String[] args) throws Exception {
	 
	  HttpURLConnectionExample http = new HttpURLConnectionExample();
	 
	  System.out.println("Send Http GET request");
	  http.sendGet();
	 
	 
	 }
	 
	 private void sendGet() throws Exception {
	 
	  String url = "http://ec2-54-88-98-95.compute-1.amazonaws.com:9000/v1/mos/1";
	 
	  URL obj = new URL(url);
	  HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	 
	  con.setRequestMethod("GET");
	 
	  con.setRequestProperty("User-Agent", USER_AGENT);
	 
	  int responseCode = con.getResponseCode();
	  System.out.println("\nSending 'GET' request to URL : " + url);
	  System.out.println("Response Code : " + responseCode);
	 
	  BufferedReader in = new BufferedReader(
	          new InputStreamReader(con.getInputStream()));
	  String inputLine;
	  StringBuffer response = new StringBuffer();
	 
	  while ((inputLine = in.readLine()) != null) {
	   response.append(inputLine);
	  }
	  in.close();
	 
	  System.out.println(response.toString());
	 
	 }
}
