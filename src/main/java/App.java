import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

            Animal newAnimal = new Animal(name, age,endangered,healthy);
            Sighting newSighting = new Sighting(location,ranger);
            newAnimal.save();
            newSighting.save();
//            System.out.println(newAnimal);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

//        get("/create/sighting",(request, response) -> {
//            Map<String,Object> model=new HashMap<String, Object>();
////            model.put("rangers",Rangers.all());
////            model.put("locations",Locations.all());
//            model.put("animals",Animal.all());
//            return new ModelAndView(model,"index.hbs");
//        },new HandlebarsTemplateEngine());
//        post("/create/sighting/new",(request, response) -> {
//            Map<String,Object> model=new HashMap<String, Object>();
//            int location_id= Integer.parseInt(request.queryParams("location"));
//            int ranger_id= Integer.parseInt(request.queryParams("ranger"));
//            int animal_id= Integer.parseInt(request.queryParams("animal"));
//            Sightings sighting=new Sightings(location_id,ranger_id,animal_id);
//            sighting.save();
//            return new ModelAndView(model,"sighting-form.hbs");
//        },new HandlebarsTemplateEngine());
////        get("/view/sightings",(request, response) -> {
////            Map<String,Object> model=new HashMap<String, Object>();
////            List<Sighting> sightings=Sighting.all();
////            ArrayList<String> animals=new ArrayList<String>();
////            ArrayList<String> types=new ArrayList<String>();
////            for (Sightings sightings : sighting){
////                String animal_name=Animal.find(sightings.getAnimal_id()).getName();
////                String animal_type=Animal.find(sightings.getAnimal_id()).getType();
////                animals.add(animal_name);
////                types.add(animal_type);
////            }
////            model.put("sightings",sightings);
////            model.put("animals",animals);
////            model.put("types",types);
////            return new ModelAndView(model,"sighting-view.hbs");
////        },new HandlebarsTemplateEngine());


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