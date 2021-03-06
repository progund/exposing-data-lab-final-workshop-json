package se.itu.brewdog.main;

import se.itu.brewdog.beer.Beer;
import se.itu.brewdog.net.JSONFetcher;
import static se.itu.brewdog.json.BeerParser.parse;

public class BrewdogBeerLookup {

  
  public static void main(String[] args) {

    System.setProperty("http.agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
    
    String query = "";
    if (args.length != 0) {
      query = args[0];
    }
    JSONFetcher fetcher = new JSONFetcher();
    String json = fetcher.fetch(query);

    for (Beer beer : parse(json)) {
      System.out.println("===================");
      System.out.println(beer);        
    }
  }

}
