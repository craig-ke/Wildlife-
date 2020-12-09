import org.junit.Test;

import static org.junit.Assert.*;

public class RangersTest {
//    Teat 1
    @Test
    public void createInstanceOfRangersClass_true(){
        Rangers ranger= setUpNewRanger();
        assertEquals(true,ranger instanceof Rangers);
    }
//Test 2
    @Test
    public void allEntriesAreSaved() {
        Rangers ranger= setUpNewRanger();
        ranger.save();
        assertTrue(Rangers.all().get(0).equals(ranger));

    }
//test 3
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
//test 4
    @Test
    public void findById() {
        Rangers ranger= setUpNewRanger();
        Rangers otherRanger=new Rangers("Sylvia","2","0726108898");
        ranger.save();
        otherRanger.save();
        Rangers foundRanger=Rangers.find(ranger.getId());
        assertTrue(foundRanger.equals(ranger));

    }
//Test 5
    @Test
    public void entryIsUpdatedCorrectly() {
        Rangers ranger= setUpNewRanger();
        Rangers otherRanger=ranger;
        ranger.save();
        try {
            ranger.update(ranger.getId(),"Ruth Mwangi","0714735954");
            Rangers foundRanger=Rangers.find(ranger.getId());
            assertNotEquals(foundRanger,otherRanger);
            assertEquals(foundRanger.getId(),otherRanger.getId());

        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }
//Test 6
    @Test
    public void entriesAreDeleted() {
        Rangers ranger= setUpNewRanger();
        Rangers otherRanger=new Rangers("Sylvia","2","0726108898");
        ranger.save();
        otherRanger.save();
        ranger.delete();
        assertEquals(null,Rangers.find(ranger.getId()));

    }


    //helper class
    private Rangers setUpNewRanger() {
        return new Rangers("Ruth","1","07123456");
    }

}

