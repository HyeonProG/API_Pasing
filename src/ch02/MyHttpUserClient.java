package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyHttpUserClient {
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/users/1");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			int responseCode = conn.getResponseCode();
			System.out.println("response code : " + responseCode);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			while((inputLine = in.readLine()) != null) {
				buffer.append(inputLine);
			}
			in.close();
			// System.out.println(buffer.toString());
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			User user = gson.fromJson(buffer.toString(), User.class);
			String userStr = gson.toJson(user);
			System.out.println(userStr);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end of main

} // end of class
