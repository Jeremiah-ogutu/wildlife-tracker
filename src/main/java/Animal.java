//import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.sql20.Connection;


public class Animal{
    public String name;
    public int id;

    public Animal(String name) {
        this.name =name;
        this.id =id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof  Animal)) {
            return false;
        }else{
            Animal newAnimal =(Animal) otherAnimal;
            return this.getName().equals(newAnimal.getName());
        }
    }

    public void  save() {
        try(Connection con = DB.sql2o.open()) {
            String sql ="INSERT INTO animals (name) VALUE (:name);";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name",this.name)
                    .executeUpdate()
                    .getKey;
        }
    }

    public  static List<Animal> all() {
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animal.class);
        }
    }
    public  static  Animal find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql =  "SELECT * FROM animals where id= :id";
            Animal animal= con.createQuery(sql)
            .ddParameter("id")
            .executeAndFetchFirst(Animal.class);
            return  animal;
        }
    }

}