import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EndangeredAnimalsTest {
    @Test
    public void testInstanceOfEndangeredAnimalsClass_true(){
        EndangeredAnimals testAnimal= setUpNewAnimal();
        assertEquals(true,testAnimal instanceof EndangeredAnimals);
    }

    @Test
    public void allInstancesAreSaved(){
        EndangeredAnimals testAnimal=setUpNewAnimal();
        testAnimal.save();
        assertEquals(EndangeredAnimals.all().get(0).getHealth(), testAnimal.getHealth());
    }

    @Test
    public void findByIdReturnsCorrectInfo(){
        EndangeredAnimals testAnimal=setUpNewAnimal();
        testAnimal.save();
        Animals foundAnimal= Animals.find(testAnimal.getId());
        assertEquals(foundAnimal.getHealth(), testAnimal.getHealth());

    }
    @Test
    public void deleteByID(){
        EndangeredAnimals testAnimal=setUpNewAnimal();
        testAnimal.save();
        testAnimal.delete();
        assertEquals(null,Animals.find(testAnimal.getId()));

    }

    @Test
    public void ensureNameFieldCannotBeEmpty(){
        EndangeredAnimals testAnimal=new EndangeredAnimals("","endangered","","");
        try {
            testAnimal.save();
        }catch (IllegalArgumentException e){

        }
    }

    @Test
    public void deleteAllEntries(){
        EndangeredAnimals testAnimal=setUpNewAnimal();
        EndangeredAnimals otherAnimal=setUpNewAnimal();
        testAnimal.save();
        otherAnimal.save();
        Animals.deleteAll();
        List<Animals> animals=Animals.all();
        assertEquals(0,animals.size());


    }

    private EndangeredAnimals setUpNewAnimal() {
        return new EndangeredAnimals("Albino Giraffe","endangered","healthy","young");
    }
}
