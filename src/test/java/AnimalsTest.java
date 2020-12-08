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
    @Test
    public void ensureEntryIsUpdatedCorrectly() {
        Animals testAnimal=setUpNewAnimal();
        Animals otherAnimal=testAnimal;
        testAnimal.save();
        try {
            testAnimal.update(testAnimal.getId(),"endangered","ill","newborn");
            Animals updatedAnimal=  Animals.find(testAnimal.getId());
            assertEquals(updatedAnimal.getId(),otherAnimal.getId());
            assertNotEquals(updatedAnimal.getHealth(),otherAnimal.getHealth());
        }catch (IllegalArgumentException e){

        }
    }

    @Test
    public void findByIdReturnsCorrectInfo() {
        Animals testAnimal=setUpNewAnimal();
        testAnimal.save();
        Animals foundAnimal= Animals.find(testAnimal.getId());
        assertTrue(foundAnimal.equals(testAnimal));
    }

    @Test
    public void deleteById() {
        Animals testAnimal=setUpNewAnimal();
        testAnimal.save();
        testAnimal.delete();
        assertEquals(null,Animals.find(testAnimal.getId()));
    }

    private Animals setUpNewAnimal() {
        return new Animals ( "Antelope","normal");
    }
}
