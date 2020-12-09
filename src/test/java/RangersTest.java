import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RangersTest {
    @Test
    public void createInstanceOfRangersClass_true(){
        Rangers ranger= setUpNewRanger();
        assertEquals(true,ranger instanceof Rangers);
    }

    @Test
    public void allEntriesAreSaved() {
        Rangers ranger= setUpNewRanger();
        ranger.save();
        assertTrue(Rangers.all().get(0).equals(ranger));

    }

    @Test
    public void emptyFieldsAreNotSaved() {
        Rangers ranger=new Rangers("","","0713245678");
        try{
            ranger.save();
            assertTrue(Rangers.all().get(0).equals(ranger));
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }

    //helper class
    private Rangers setUpNewRanger() {
        return new Rangers("Ruth","1","07123456");
    }

}

