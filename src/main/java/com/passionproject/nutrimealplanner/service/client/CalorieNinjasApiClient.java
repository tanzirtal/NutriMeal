//package com.passionproject.nutrimealplanner.service.client;
//
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.URLEncoder;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.nio.charset.StandardCharsets;
//
//@Service
//public class CalorieNinjasApiClient {
//
//    private final String apiKey;
//    private final String nutritionUrl = "https://api.calorieninjas.com/v1/nutrition?query=";
//    private final String recipeUrl = "https://api.calorieninjas.com/v1/recipe?query=";
//    private final HttpClient httpClient = HttpClient.newBuilder().build();
//
//    public CalorieNinjasApiClient(@Value("${calorieninjas.api.key}") String apiKey) {
//        this.apiKey = apiKey;
//    }
//
//    public String getNutritionInfo(String query) throws IOException, InterruptedException{
//        return sendApiRequest(nutritionUrl, query);
//    }
//
//    public String getRecipeInfo(String query) throws IOException, InterruptedException{
//        return sendApiRequest(recipeUrl, query);
//    }
//
//    private String sendApiRequest(String baseUrl, String query) throws IOException, InterruptedException {
//        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
//        String requestUrl = baseUrl + encodedQuery;
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(requestUrl))
//                .header("X-Api-Key", apiKey)
//                .GET()
//                .build();
//
//        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//        if (response.statusCode() == 200) {
//            return response.body();
//        } else {
//            throw new IOException("API request failed with status code: " + response.statusCode() + " and body: " + response.body());
//        }
//    }
//
//
//
//
//
//}
