import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[]args) {
//        staticFileLocation( "/public");

        get("/", (request, response) -> {

            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Animal> allAnimals = (ArrayList<Animal>) Animal.all();
            ArrayList<Sighting> allSighting = (ArrayList<Sighting>) Sighting.all();

            model.put("allSighting", allSighting);
            model.put("allAnimals", allAnimals);

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/post_sighting", (request, response) -> { //new
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String healthy = request.queryParams("healthy");
            String endangered = request.queryParams("endangered");
            String location = request.queryParams("location");
            String ranger = request.queryParams("ranger");

            Animal newAnimal = new Animal(name, age,endangered,healthy,ranger);
            Sighting newSighting = new Sighting(location,ranger);
            newAnimal.save();
            newSighting.save();
//            System.out.println(newAnimal);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get to show all animals
        get("/animals/new",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            ArrayList<Animal> allAnimals = (ArrayList<Animal>) Animal.all();
            ArrayList<Sighting> allSighting = (ArrayList<Sighting>) Sighting.all();
            model.put("allSighting", allSighting);
            model.put("allAnimals", allAnimals);
            return new ModelAndView(model, "Animal-detail.hbs");
        }, new HandlebarsTemplateEngine());


    }


}