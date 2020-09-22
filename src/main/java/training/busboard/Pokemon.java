package training.busboard;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.imageio.plugins.png.PNGImageReader;

import java.awt.image.BufferedImage;
import java.util.LinkedHashMap;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    public String name;
    public List<Object> abilities;
    public int id;
    public LinkedHashMap sprites;

    public String getSpriteURL(){
        return(String) sprites.get("front_default");
    }
   //public String species;
}
