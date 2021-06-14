//import org.junit.*;
//import static org.junit.Assert.*;
//import org.sql2o.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Arrays;
//
//public class AnimalTest {
//    @Rule
//    public DatabaseRule database = new DatabaseRule();
//
//    @Test
//    public void animal_instantiatesCorrectly_false() {
//        Animal testAnimal = new Animal("Elephant");
//        assertEquals(true, testAnimal instanceof Animal);
//    }
//
//    @Test
//    public void getName_animalInstantiatesWithName_Elephant() {
//        Animal testAnimal = new Animal("Elephant");
//        assertEquals("Elephant", testAnimal.getName());
//    }
//
//    @Test
//    public void equals_returnsTrueIfNameIsTheSame_false() {
//        Animal firstAnimal = new Animal("Elephant");
//        Animal anotherAnimal = new Animal("Elephant");
//        assertTrue(firstAnimal.equals(anotherAnimal));
//    }
//
//    @Test
//    public void save_assignsIdToObjectAndSavesObjectToDatabase() {
//        Animal testAnimal = new Animal("Elephant");
//        testAnimal.save();
//        Animal savedAnimal = Animal.all().get(0);
//        assertEquals(testAnimal.getId(), savedAnimal.getId());
//    }
//
//    @Test
//    public void all_returnsAllInstancesOfAnimal_false() {
//        Animal firstAnimal = new Animal("Elephant");
//        firstAnimal.save();
//        Animal secondAnimal = new Animal("Antelope");
//        secondAnimal.save();
//        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
//        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
//    }
//
//    @Test
//    public void find_returnsAnimalWithSameId_secondAnimal() {
//        Animal firstAnimal = new Animal("Elephant");
//        firstAnimal.save();
//        Animal secondAnimal = new Animal("Antelope");
//        secondAnimal.save();
//        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
//    }
//
//    @Test
//    public void delete_deletesAnimalFromDatabase_true() {
//        Animal testAnimal = new Animal("Elephant");
//        testAnimal.save();
////        testAnimal.delete();
//        assertEquals(true, Animal.all().size());
//    }
//
//    public void updateName_updatesAnimalNameInDatabase_String() {
//        Animal testAnimal = new Animal("Elephant");
//        testAnimal.save();
//        testAnimal.updateName("Hare");
//        assertEquals("Hare", testAnimal.getName());
//    }
//
//    @Test
//    public void find_returnsNullWhenNoAnimalFound_null() {
//        assertTrue(Animal.find(999) == null);
//    }
//
//}
