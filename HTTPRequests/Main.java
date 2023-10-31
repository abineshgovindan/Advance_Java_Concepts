package org.example.HTTPRequests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public  static  void GET(String urlText) throws IOException {
        URL url;
        try {
            url = new URL(urlText);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int statusCode = con.getResponseCode();
            System.out.println("GET Status Code -> "+ statusCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();




        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) throws IOException {
        final String URL = "https://api.github.com/users/google";
        try {
            GET(URL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
