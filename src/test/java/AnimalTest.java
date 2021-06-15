
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("lion", "young", "true", "true");
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getName_animalInstantiatesWithName_lion() {
        Animal testAnimal = new Animal("lion", "young","true","true");
        assertEquals("lion", testAnimal.getName());

    }

    @Test
    public void save_assignsIdToAnimal() {
        Animal testAnimal = new Animal("lion", "young","true","true");
        testAnimal.save();
        Animal savedAnimal = Animal.all().get(4);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }
}

