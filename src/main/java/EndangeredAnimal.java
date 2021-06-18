import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimal {
    private String name;
    private String age;
    private String endangered;
    private String healthy;
//    private String ranger;
    private int id;

    public EndangeredAnimal(String name, String age, String endangered,String  healthy) {
        this.name = name;
        this.age = age;
        this.endangered = endangered;
        this.healthy = healthy;
//        this.ranger = ranger;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }



    public String getEndangered() {
        return endangered;
    }

    public String getHealthy() {
        return healthy;
    }

    @Override
    public boolean equals(Object otherEndangeredAnimal){
        if (!(otherEndangeredAnimal instanceof EndangeredAnimal)) {
            return false;
        } else {
            EndangeredAnimal newAnimal = (EndangeredAnimal) otherEndangeredAnimal;
            return this.getName().equals(newAnimal.getName()) &&
                    this.getAge().equals(newAnimal.getAge())&&
                    this.getEndangered().equals(newAnimal.getEndangered())&&
                    this.getHealthy().equals(newAnimal.getHealthy());
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, age,endangered,healthy) VALUES (:name, :age,:endangered,:healthy)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("age", this.age)
                    .addParameter("endangered", this.endangered)
                    .addParameter("healthy", this.healthy)
//                    .addParameter("ranger", this.ranger)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM endangeredanimal";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(EndangeredAnimal.class);
        }
    }

    public static EndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            EndangeredAnimal EndangeredAnimal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return EndangeredAnimal;
        }
    }


}
