package se.itu.brewdog.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class JSONFetcher {

  private static final String END_POINT = "https://api.punkapi.com/v2/";
  private static final String DEFAULT_QUERY = "beers?page=1&per_page=10";
  
  public String fetch(String query) {
    if (query == null || query.equals("")) {
      query = DEFAULT_QUERY;
    }
    String result = "";
    try {
      System.out.println("Connecting to the punk api");
      System.out.println("Using this url: " + END_POINT + query);
      URL url = new URL(END_POINT + query);
      StringBuilder response = new StringBuilder();
      BufferedReader reader =
        new BufferedReader(new InputStreamReader
                           (url.openStream()));

      for(String line : reader.lines().collect(Collectors.toList())) {
        response.append(line);
      }
      result = response.toString();
    } catch (IOException e) {
      throw new RuntimeException("Problem fetching JSON: " +
                                 e.getMessage(), e);
    }
    return result;
  }
}
