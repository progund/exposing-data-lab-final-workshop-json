package se.itu.brewdog.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.*;

import se.itu.brewdog.beer.Beer;

public class FetchJson {

  private static final String END_POINT = "https://api.punkapi.com/v2/";
  private static final String QUERY = "beers?page=1&per_page=10";
  
  public static void main(String[] args) {

    System.setProperty("http.agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
    System.out.println("Connecting to the punk api");
    System.out.println("Using this url: " + END_POINT + QUERY);

    try {
      URL url = new URL(END_POINT + QUERY);
      StringBuilder response = new StringBuilder();
      BufferedReader reader =
        new BufferedReader(new InputStreamReader
                           (url.openStream()));

      for(String line : reader.lines().collect(Collectors.toList())) {
        response.append(line);
      }
      for (Beer beer : parse(response.toString())) {
        System.out.println("===================");
        System.out.println(beer);        
      }
    } catch (IOException e) {
      System.err.println("Error fetching JSON: " + e.getMessage());
    }
    
  }

  static List<Beer> parse(String json) {

    JSONArray jsonArray = new JSONArray(json);
    List<Beer> beers = new ArrayList<>();
    
    for(int i = 0; i < jsonArray.length(); i++) {
      
      JSONObject jsonObject = jsonArray.getJSONObject(i);
      String name = jsonObject.getString("name");
      String description = jsonObject.getString("description");
      double alcohol = jsonObject.getDouble("abv");
      JSONArray foodsJson = (JSONArray)jsonObject.get("food_pairing");
      ArrayList<String> foodStrings = new ArrayList<>();

      for(int j = 0; j < foodsJson.length(); j++) {
        foodStrings.add(foodsJson.getString(j));
      }

      beers.add(new Beer(name,
                         description,
                         alcohol,
                         foodStrings)
                );
      /*
        beers.add(new Beer("Buzz",
        "A light, crisp and bitter IPA brewed with English" +
        " and American hops. A small batch brewed only once.",
        4.5,
        Arrays.asList(new String[] {"Spicy chicken tikka masala",
        "Grilled chicken quesadilla",
        "Caramel toffee cake"})
        )
        );
      */
    }
    return beers;
  }
  
}
