package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class MyHttpUserListClient {

	public static void main(String[] args) {

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/users");
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");

			int responseCode = conn.getResponseCode();
			System.out.println("response code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				buffer.append(inputLine);
			}
			in.close();
			// System.out.println(buffer.toString());

			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			Type userType = new TypeToken<List<User>>() {
			}.getType();

			List<User> userList = gson.fromJson(buffer.toString(), userType);
	
//			String userStr = gson.toJson(userList);
//			System.out.println(userStr);
			
			System.out.println(userList.size());
			for (User a : userList) {
				System.out.println(a.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of main

} // end of class
