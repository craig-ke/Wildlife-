import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalsTest {
    @Test
    public void testInstanceOfAnimalsClass_true(){
        Animals testAnimal= setUpNewAnimal();
        assertEquals(true,testAnimal instanceof Animals);
    }

    private Animals setUpNewAnimal() {
        return new Animals ( "Antellope","normal");
    }
}
