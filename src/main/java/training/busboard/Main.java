package training.busboard;
import apple.laf.JRSUIConstants;
import javafx.event.EventDispatchChain;
import org.glassfish.jersey.jackson.JacksonFeature;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Main GetAndPost;
    public static void main(String args[]) throws IOException {
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        System.out.println("Please enter a pokemon name: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next().toLowerCase();
        String link = "https://pokeapi.co/api/v2/pokemon/" + input; //adds it to the link for info on that pokemon
        Pokemon newPokemon = client
                .target(link)
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get(Pokemon.class);
        System.out.println(newPokemon);
        //GetAndPost.MyGETRequest();
    }

    public static void MyGETRequest() throws IOException {
        //get pokemon from user
        System.out.println("Please enter a pokemon name: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next().toLowerCase();
        String link = "https://pokeapi.co/api/v2/pokemon/" + input; //adds it to the link for info on that pokemon

        //add a user agent
        URL urlForGetRequest = new URL(link); //replace with link later
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        connection.addRequestProperty("User-Agent", "Cheese");

        ArrayList<String> info = new ArrayList<>();


        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in .readLine()) != null) { //whilst the line has information...
                response.append(readLine);
            } in .close();
            // print result
            //info.add(response.toString().split(","));
            System.out.println(input);

            System.out.println(info.get(0));

        } else {
            System.out.println("GET NOT WORKED");
        }
    }
}
