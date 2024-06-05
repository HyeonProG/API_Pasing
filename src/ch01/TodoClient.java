package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TodoClient {
	
	public static void main(String[] args) {

		String urlString = "https://jsonplaceholder.typicode.com/todos/1";
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			
			int responseCode = conn.getResponseCode();
			System.out.println("HTTP CODE : " + responseCode);
			BufferedReader brIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String inputLine;
			StringBuffer responseBuffer = new StringBuffer();
			
			while((inputLine = brIn.readLine()) != null) {
				responseBuffer.append(inputLine);
			}
			brIn.close();
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			Todo todoObject = gson.fromJson(responseBuffer.toString(), Todo.class);
			
			String todoStr = gson.toJson(todoObject);
			System.out.println(todoStr);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end of main

} // end of class
