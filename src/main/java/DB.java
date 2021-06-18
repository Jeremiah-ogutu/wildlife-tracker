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
//public static Sql2o sql2o = new Sql2o( "postgres://yhwodeeynxzitz:531f0bbedca5d3401cefde339b38bf9d34968c08324c703fd6fa24b8e49d7059@ec2-3-234-22-132.compute-1.amazonaws.com:5432/deagsm1bbcmosr");
};
