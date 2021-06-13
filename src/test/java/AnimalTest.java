import org.junit.*;
import static org.junit.Assert.*;

public class AnimalTest {
    @Test
    public void Animal_instantiatesCorrectly_false() {
        Animal testAnimal = new Animal("Elephant");
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getName_animalInstantiatesWithName_Elephant(){
        Animal testAnimal = new Animal("Elephant");
        assertArrayEquals("Elephant",testAnimal.getName());
    }

    private void assertArrayEquals(String elephant, String name) {
    }

    @Test
    public void equals_returnsTrueIfNameTheSame_false(){
        Animal firstAnimal= new Animal("Elephant");
        Animal anotherAnimal = new Animal("Elephant");
        assertTrue(firstAnimal.equals(anotherAnimal));
    }

    @Test
    public void save_insertIdToObjectAndSavesObjectToDatabase() {
        Animal testAnimal = new Animal("Elephant");
        testAnimal.save();
        assertTrue(Animal.All().get(0).equals(testAnimal));
    }

}
