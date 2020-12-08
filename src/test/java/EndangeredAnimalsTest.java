import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EndangeredAnimalsTest {
    @Test
    public void testInstanceOfEndangeredAnimalsClass_true(){
        EndangeredAnimals testAnimal= setUpNewAnimal();
        assertEquals(true,testAnimal instanceof EndangeredAnimals);
    }
    private EndangeredAnimals setUpNewAnimal() {
        return new EndangeredAnimals("Albino Giraffe","endangered","healthy","young");
    }
}
