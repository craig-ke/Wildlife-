import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocationsTest {

    @Test
    public void createInstanceOfLocationsClass() {
        Locations location=setUpNewLocation();
        assertEquals(true,location instanceof Locations);
    }
    //helper function
    private Locations setUpNewLocation() {
        return new Locations("Zone A");
    }
}

