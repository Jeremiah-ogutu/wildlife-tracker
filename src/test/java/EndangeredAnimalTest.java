////import org.junit.*;
////import static org.junit.Assert.*;
////import org.sql2o.*;
////
////public class EndangeredAnimalTest {
////    @Rule
////    public DatabaseRule database = new DatabaseRule();
////
////
////
////    @Test
////    public void  endangeredAnimal_instantiatesCorrectly_true() {
////        EndangeredAnimal testEndangered = new EndangeredAnimal("Tigger","Healthy", "Young");
////        assertEquals(true,testEndangeredAnimal instanceof EndangeredAnimal);
////
////    }
////
////    @Test
////    public  void  EndageredAnimal_instatiatesWithName_String() {
////        EndangeredAnimal testEndangeredAnimal =new EndangeredAnimal("Tigger","Healthy", "Young");
////        assertEquals("Healthy", testEndangeredAnimal.getHealth());
////    }
//import org.junit.*;
//import static org.junit.Assert.*;
//import org.sql2o.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Arrays;
//
//public class EndangeredAnimalTest {
//    @Rule
//    public DatabaseRule database = new DatabaseRule();
//
//    @Test
//    public void endangeredAnimal_instantiatesCorrectly_true() {
//        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Rhino", "Healthy", "Young");
//        assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);
//    }
//
//    @Test
//    public void getHealth_returnsHealthAttribute_true() {
//        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Rhino", "Healthy", "Young");
//        assertEquals("Healthy", testEndangeredAnimal.getHealth());
//    }
//
//    @Test
//    public void save_assignsIdAndSavesObjectToDatabase() {
//        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Rhino", "Healthy", "Young");
//        testEndangeredAnimal.save();
//        EndangeredAnimal savedEndangeredAnimal = EndangeredAnimal.all().get(0);
//        assertEquals(testEndangeredAnimal.getId(), savedEndangeredAnimal.getId());
//    }
//
//    @Test
//    public void all_returnsAllInstancesOfEndangeredAnimal_true() {
//        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Rhino", "Healthy", "Young");
//        firstEndangeredAnimal.save();
//        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Cub", "Okay", "Young");
//        secondEndangeredAnimal.save();
//        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstEndangeredAnimal));
//        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondEndangeredAnimal));
//    }
//
//    @Test
//    public void find_returnsAnimalWithSameId_secondAnimal() {
//        EndangeredAnimal firstEndangeredAnimal = new EndangeredAnimal("Rhino", "Healthy", "Young");
//        firstEndangeredAnimal.save();
//        EndangeredAnimal secondEndangeredAnimal = new EndangeredAnimal("Cub", "Okay", "Young");
//        secondEndangeredAnimal.save();
//        assertEquals(EndangeredAnimal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
//    }
//
//    @Test
//    public void update_updatesHealthAttribute_true() {
//        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Rhino", "Healthy", "Young");
//        testEndangeredAnimal.save();
//        testEndangeredAnimal.updateHealth("ill");
//        assertEquals("ill", EndangeredAnimal.find(testEndangeredAnimal.getId()).getHealth());
//    }
//
//    @Test
//    public void update_updatesAgeAttribute_true() {
//        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Rhino", "Healthy", "Young");
//        testEndangeredAnimal.save();
//        testEndangeredAnimal.updateAge("Adult");
//        assertEquals("Adult", EndangeredAnimal.find(testEndangeredAnimal.getId()).getAge());
//    }
//
//}
//
////
////
////
////
////
////
////
////
////
////}