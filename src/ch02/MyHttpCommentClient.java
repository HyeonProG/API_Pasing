package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyHttpCommentClient {
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/comments/");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
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
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Comment[] commentDTO = gson.fromJson(buffer.toString(), Comment[].class);
			
			String commentStr = gson.toJson(commentDTO);
			System.out.println(commentStr);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end of main

} // end of class
