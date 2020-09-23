package training.busboard;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.imageio.plugins.png.PNGImageReader;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    public String name;
    public List<Object> abilities;
    public int id;
    public LinkedHashMap sprites;

    //this gets the pokemon sprite
    public String getSpriteURL(){
        return(String) sprites.get("front_default");
    }

//    //these return the abilities
//    public Object getAbilities(int i) {
//        return abilities.get(i);
//    }
//    public String getAbility(int i){
//        return getAbilities(i).get("ability");
//    }
//    public String getAbilityName(){
//        String abilityString = "";
//        for (int i = 0; i < abilities.size(); i++){
//            String x = getAbility(i).get("name");
//            abilityString = abilityString + " " + x;
//        }
//        return abilityString;
//        //this returns the abilities in an easy to read string
//    }

    //finds the species of the pokemon
     public String species(){
          return null;
     }
}
