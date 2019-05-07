package se.itu.brewdog.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

/*
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.*;

import se.itu.brewdog.beer.Beer;
*/
public class FetchJson {

  /* The END_POINT and QUERY static final String:s here */
  
  public static void main(String[] args) {
    System.setProperty("http.agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
    /*
    Write out a status message to standard out saying 
    that we'll connect to the Punk API and what URL you will use
    ( which is END_POINT + QUERY )
    Start a try-catch
      Create a URL object (name the reference url) and feed END_POINT + QUERY
      to its constuctor
      Create a new StringBuilder called response (for the Punk API response
      with its JSON)
      Create a new BufferedReader called reader, and give its constructor a
      new InputStreamReader and give that one's constructor url.openStream()
      Start a for-each-loop on a String line in the list created by
      reader.lines().collect(Collectors.toList())
         append each line to response
         Print response to standard out
    catch (IOException e) and print the message to stderr
    */
  }

  /* Write the parse method here, later */
  
}
