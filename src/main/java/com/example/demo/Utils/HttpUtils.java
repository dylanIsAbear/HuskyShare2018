package com.example.demo.Utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {

    public static String executePost(String targetURL, String urlParameters){
        HttpURLConnection connection = null;
        try{
            //Create connections
            URL url = new URL(targetURL);
            connection = (HttpURLConnection)url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("name", "dylan");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(false);

            //Send request
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(urlParameters);
            out.close();

            //Get response
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder response = new StringBuilder();

            String line;
            while((line=reader.readLine()) != null){
                response.append(line);
                response.append('\r');
            }

            reader.close();
            connection.disconnect();
            return response.toString();


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
