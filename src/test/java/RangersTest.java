import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RangersTest {
    @Test
    public void createInstanceOfRangersClass_true(){
        Rangers ranger= setUpNewRanger();
        assertEquals(true,ranger instanceof Rangers);
    }
    //helper class
    private Rangers setUpNewRanger() {
        return new Rangers("Ruth","1","07123456");
    }

}

