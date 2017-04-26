/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebankclient.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author DELL
 */
public class ServiceConnector {
    private final String serverURL="http://localhost:8080/EBankWebService/webresources/";
    
    public void sentRequest(String path,String data,String method) throws MalformedURLException,IOException,RuntimeException{

			URL url = new URL(
					serverURL+path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(method);
			conn.setRequestProperty("Content-Type", "application/json");
			OutputStream os = conn.getOutputStream();
			os.write(data.getBytes());
			os.flush();
                        
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                            if(conn.getResponseCode() !=500){
                                   throw new RuntimeException("Duplicate Entity");
                            }else{
                            throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
                            }
			}

			conn.disconnect();

		
    }
    
    public String getResponse(String path,String method,String data) throws MalformedURLException,IOException,RuntimeException{
       

			URL url = new URL(
					serverURL+path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(method);

                        if(!data.equals("")){
                       conn.setDoOutput(true);

			conn.setRequestProperty("Content-Type", "application/json");
			OutputStream os = conn.getOutputStream();
			os.write(data.getBytes());
			os.flush();

                        }else{
                        conn.setRequestProperty("Accept", "application/json");

                        }
                        
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
                        String jSonData="";
			
			while ((output = br.readLine()) != null){
                            jSonData+=output;                            
                        }
			conn.disconnect();
                        return jSonData;

		
    }
}
