package se.itu.brewdog.json;

import java.util.List;
import java.util.ArrayList;

import se.itu.brewdog.beer.Beer;

import org.json.JSONArray;
import org.json.JSONObject;

public class BeerParser {

  public static List<Beer> parse(String json) {

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
    }
    return beers;
  }  

}
