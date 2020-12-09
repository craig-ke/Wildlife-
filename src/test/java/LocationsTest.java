import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LocationsTest {

    @Test
    public void createInstanceOfLocationsClass() {
        Locations location=setUpNewLocation();
        assertEquals(true,location instanceof Locations);
    }

    @Test
    public void allEntriesAreSaved() {
        Locations location=setUpNewLocation();
        Locations newLocation=new Locations("");
        try {
            location.save();
            assertTrue(Locations.all().get(0).equals(location));
            newLocation.save();

        }catch (IllegalArgumentException e){
            System.out.println(e);
        }

    }
    //helper function
    private Locations setUpNewLocation() {
        return new Locations("Zone A");
    }
}

