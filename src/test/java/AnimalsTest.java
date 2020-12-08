import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalsTest {
    @Test
    public void testInstanceOfAnimalsClass_true(){
        Animals testAnimal= setUpNewAnimal();
        assertEquals(true,testAnimal instanceof Animals);
    }

    @Test
    public void allInstancesAreSaved() {
        Animals testAnimal=setUpNewAnimal();
        testAnimal.save();
        assertTrue(Animals.all().get(0).equals(testAnimal));
    }

    private Animals setUpNewAnimal() {
        return new Animals ( "Antelope","normal");
    }
}
