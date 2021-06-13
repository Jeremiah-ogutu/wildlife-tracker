//import org.junit.*;
//import static org.junit.Assert.*;
//
//public class AnimalTest {
//
//    @Rule
//    public DatabaseRule database = new DatabaseRule();
//
//    @Test
//    public void Animal_instantiatesCorrectly_false() {
//        Animal testAnimal = new Animal("Elephant");
//        assertEquals(true, testAnimal instanceof Animal);
//    }
//
//    @Test
//    public void getName_animalInstantiatesWithName_Elephant(){
//        Animal testAnimal = new Animal("Elephant");
//        assertArrayEquals("Elephant",testAnimal.getName());
//    }
//
//    private void assertArrayEquals(String elephant, String name) {
//    }
//
//    @Test
//    public void equals_returnsTrueIfNameTheSame_false(){
//        Animal firstAnimal= new Animal("Elephant");
//        Animal anotherAnimal = new Animal("Elephant");
//        assertTrue(firstAnimal.equals(anotherAnimal));
//    }
//
//    @Test
//    public void save_insertIdToObjectAndSavesObjectToDatabase() {
//        Animal testAnimal = new Animal("Elephant");
//        testAnimal.save();
//        assertTrue(Animal.All().get(0).equals(testAnimal));
//    }
//
//    @Test
//    public void  all_returnsAllInstancesOfAnimal_true(){
//        Animal firstAnimal = new Animal("Elephant");
//        firstAnimal.save();
//        Animal secondAnimal = new Animal("Elephant");
//        secondAnimal.save();
//        assertEquals(true,Animal.all().get(0).equals(firstAnimal));
//        assertEquals(true,Animal.all().get(1).equals(firstAnimal));
//
//    }
//
//    @Test
//    public  void  save_assignsIdObject(){
//        Animal testAnimal = new Animal("Elephant");
//        testAnimal.save();
//        Animal savedAnimal = Animal.all().get(0);
//        assertEquals(testAnimal.getId(), savedAnimal.getId());
//    }
//
//    @Test
//    public  void save_assignsIdToObject() {
//        Animal testAnimal = new Animal("Elephant");
//        testAnimal.save();
//        Animal savedAnimal = Animal.all().get(0);
//        assertEquals(testAnimal.getId(), savedAnimal.getId());
//    }
//
//}
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class AnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_false() {
        Animal testAnimal = new Animal("Deer");
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getName_animalInstantiatesWithName_Deer() {
        Animal testAnimal = new Animal("Deer");
        assertEquals("Deer", testAnimal.getName());
    }

    @Test
    public void equals_returnsTrueIfNameIsTheSame_false() {
        Animal firstAnimal = new Animal("Deer");
        Animal anotherAnimal = new Animal("Deer");
        assertTrue(firstAnimal.equals(anotherAnimal));
    }

    @Test
    public void save_assignsIdToObjectAndSavesObjectToDatabase() {
        Animal testAnimal = new Animal("Deer");
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }

    @Test
    public void all_returnsAllInstancesOfAnimal_false() {
        Animal firstAnimal = new Animal("Deer");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Black Bear");
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Animal firstAnimal = new Animal("Deer");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Black Bear");
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }

    @Test
    public void delete_deletesAnimalFromDatabase_0() {
        Animal testAnimal = new Animal("Deer");
        testAnimal.save();
        testAnimal.delete();
        assertEquals(0, Animal.all().size());
    }

    public void updateName_updatesAnimalNameInDatabase_String() {
        Animal testAnimal = new Animal("Deer");
        testAnimal.save();
        testAnimal.updateName("Buck");
        assertEquals("Buck", testAnimal.getName());
    }

    @Test
    public void find_returnsNullWhenNoAnimalFound_null() {
        assertTrue(Animal.find(999) == null);
    }

}

