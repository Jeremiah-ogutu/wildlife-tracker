//import org.sql2o.*;
//
//public class DB {
//    //public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "moringa", "Access");
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-174-129-253-86.compute-1.amazonaws.com:5432/d5tkf3dsmrb98s", "moringa", "Access");
//}
import org.graalvm.compiler.nodes.memory.Access;
import org.sql2o.*;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "moringa", "Access");
}
