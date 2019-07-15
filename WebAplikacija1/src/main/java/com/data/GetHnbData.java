package com.data;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.TecajPOJO;

public class GetHnbData {
	private String streamToString(InputStream input) {
		String text = new Scanner(input, "UTF-8").useDelimiter("\\Z").next();
		return text;
	}

	public TecajPOJO[] jsonGetRequest() throws IOException {
		String json = null;
		String s = null;
		try {
			URL url = new URL("http://api.hnb.hr/tecajn/v1");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("charset", "utf-8");
			connection.connect();
			InputStream inStream = connection.getInputStream();
			json = streamToString(inStream); // input stream to string
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return object(json);
	}

	public TecajPOJO[] object(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		TecajPOJO[] tecajPOJO = mapper.readValue(json, TecajPOJO[].class);
		return tecajPOJO;
	}
}
