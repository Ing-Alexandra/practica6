/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */ 

package com.mycompany.chucknorrisjokeclient;

/**
 *
 * @author Ale's
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ChuckNorrisJokeClient {

    public static void main(String[] args) {
        try {
            // URL del endpoint del API de Chuck Norris Jokes
            String apiUrl = "https://api.chucknorris.io/jokes/random";

            // Crear una conexión HTTP
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Obtener la respuesta del servidor
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Leer la respuesta del servidor
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Crear un HashMap para almacenar la respuesta en formato clave-valor
                Map<String, Object> jokeMap = new HashMap<>();
                jokeMap.put("chiste", response.toString());

                // Imprimir el HashMap
                System.out.println("Respuesta del servicio web:");
                System.out.println(jokeMap);
            } else {
                System.out.println("Error al realizar la solicitud. Código de respuesta: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


