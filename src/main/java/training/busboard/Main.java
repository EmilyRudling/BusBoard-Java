package training.busboard;
import apple.laf.JRSUIConstants;
import javafx.event.EventDispatchChain;
import org.glassfish.jersey.jackson.JacksonFeature;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.print.PrintService;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.awt.image.RenderedImage;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
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
//        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
//        System.out.println("Please enter a pokemon name: ");
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.next().toLowerCase();
//        String link = "https://pokeapi.co/api/v2/pokemon/" + input; //adds it to the link for info on that pokemon
//        Pokemon newPokemon = client
//                .target(link)
//                .request(MediaType.APPLICATION_JSON_TYPE)
//                .get(Pokemon.class);
//        System.out.println(newPokemon.getSpriteURL());




        //print off the sprite for a pokemon
        //URL url = new URL("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + newPokemon.id + ".png");
        //InputStream inputStream = url.openStream();
       // Scanner s = new Scanner(inputStream);

        //getMyImage();
        //ImageIO.write(BufferedImage, "PNG", "132.png");

        //print off the attributes
//        for(int i = 0; i < newPokemon.size(); i++)
//        {
//            System.out.println(newPokemon.abilities.get(i));
//        }

        //System.out.println(newPokemon);
        //GetAndPost.MyGETRequest();
    }

//    private static BufferedImage getMyImage() {
//        try {
//            // retrieve image
//            BufferedImage bi = getMyImage();
//            File outputfile = new File("132.png");
//            ImageIO.write(bi, "png", outputfile);
//        } catch (IOException e) {
//        }
//        return getMyImage();
//    }
}


        //old attempt,,,, ignore me
//    public static void MyGETRequest() throws IOException {
//        //get pokemon from user
//        System.out.println("Please enter a pokemon name: ");
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.next().toLowerCase();
//        String link = "https://pokeapi.co/api/v2/pokemon/" + input; //adds it to the link for info on that pokemon
//
//        //add a user agent
//        URL urlForGetRequest = new URL(link); //replace with link later
//        String readLine = null;
//        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
//        connection.setRequestMethod("GET");
//        connection.addRequestProperty("User-Agent", "Cheese");
//
//        ArrayList<String> info = new ArrayList<>();
//
//
//        int responseCode = connection.getResponseCode();
//        System.out.println(responseCode);
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(connection.getInputStream()));
//            StringBuffer response = new StringBuffer();
//            while ((readLine = in .readLine()) != null) { //whilst the line has information...
//                response.append(readLine);
//            } in .close();
//            // print result
//            //info.add(response.toString().split(","));
//            System.out.println(input);
//
//            System.out.println(info.get(0));
//
//        } else {
//            System.out.println("GET NOT WORKED");
//        }
//    }

