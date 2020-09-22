package training.busboard.web;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import training.busboard.Pokemon;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.Scanner;

@Controller
@EnableAutoConfiguration
public class Website {

    @RequestMapping("/")
    ModelAndView home() {
        return new ModelAndView("index");
    }

    @RequestMapping("/pokemonInfo")
    ModelAndView pokemonInfo(@RequestParam("pokemon") String pokemon) {
        //takes the info from the page and creates a new pokemon object
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
        String link = "https://pokeapi.co/api/v2/pokemon/" + pokemon; //adds it to the link for info on that pokemon
        Pokemon newPokemon = client
                .target(link)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(Pokemon.class);
        return new ModelAndView("info", "pokemonInfo", newPokemon) ;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Website.class, args);
    }

}