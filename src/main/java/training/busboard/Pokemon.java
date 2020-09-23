package training.busboard;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.imageio.plugins.png.PNGImageReader;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    public String name;
    public List<LinkedHashMap> abilities;
    public int id;
    public LinkedHashMap evolution_chain;
    public LinkedHashMap species;
    public LinkedHashMap sprites;

    //this gets the pokemon sprite
    public String getSpriteURL(){
        return(String) sprites.get("front_default");
    }

    //these return the abilities
    public LinkedHashMap getAbilities(int i) {
        return abilities.get(i);
    }
    public LinkedHashMap getAbility(int i){
        return (LinkedHashMap) getAbilities(i).get("ability");
    }
    public String getAbilityName(){
        String abilityString = "";
        for (int i = 0; i < abilities.size(); i++){
            String x = (String) getAbility(i).get("name");
            abilityString = abilityString + " " + x;
        }
        return abilityString;
        //this returns the abilities in an easy to read string
    }

    //finds the species of the pokemon
     public String getSpeciesURL(){
         return(String) species.get("url");
     }
    // finds the evolution chain
    public String getChainURL(){
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        String link2= getSpeciesURL(); //adds it to the link for info on that pokemon
        Pokemon newPokemon = client
                .target(link2)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(Pokemon.class);
        return(String) evolution_chain.get("url");
    }

}



