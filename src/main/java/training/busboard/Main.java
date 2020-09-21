package training.busboard;
import apple.laf.JRSUIConstants;
import javafx.event.EventDispatchChain;
import org.glassfish.jersey.jackson.JacksonFeature;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Main GetAndPost;
    public static void main(String args[]) throws IOException {
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();

//        List<JRSUIConstants.Widget> widgets = client
//                .path("/widgets")
//                    .request(MediaType.APPLICATION_JSON_TYPE)
//                    .get(new GenericType<List<JRSUIConstants.Widget>>() {
//                    });

        GetAndPost.MyGETRequest();
    }

    public static void MyGETRequest() throws IOException {
        //get pokemon from user
        System.out.println("Please enter a pokemon name: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next().toLowerCase();
        String link = "https://pokeapi.co/api/v2/pokemon/" + input; //adds it to the link for info on that pokemon

        //add a user agent
        URL urlForGetRequest = new URL("https://pokeapi.co/api/v2/pokemon/ditto"); //replace with link later
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        connection.addRequestProperty("User-Agent", "Cheese");

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
            System.out.println("JSON String Result " + response.toString());
            //GetAndPost.POSTRequest(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }
    }
}	
