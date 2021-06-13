import org.junit.*;
import static org.junit.Assert.*;

public class AnimalTest {

    @Rule
    public DatabaseRule database =new DatabaseRule();


    @Test
    public void Animal_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Duma");
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getName_animalInstantiatesWithName_Duma() {
        Animal testAnimal = new Animal("Duma");
        assertEquals("Deer", testAnimal.getName());
    }

    @Test
    public void equals_returnsTrueIfNameIsTheSame_false() {
        Animal firstAnimal = new Animal("Duma");
        Animal anotherAnimal = new Animal("Duma");
        assertTrue(firstAnimal.equals(anotherAnimal));

    }

    @Test
    public  void  save_insertsObjectIntoDatabase_animal() {
        Animal testAnimal = new Animal("Duma");
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
    }

    @Test
    public void all_returnsAllInstancesOfAnimal_false() {
        Animal firstAnimal = new Animal("Duma");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Bear");
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }

    @Test
    public  void  save_assignsIdToObject() {
        Animal testAnimal = new Animal("Duma");
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }

    @Test
    public  void find_returnAnimalWithSameId_secondAnimal() {
        Animal firstAnimal= new Animal("Duma")
        firstAnimal.save();
        Animal secondAnimal = new Animal("Bear");
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);

    }




}