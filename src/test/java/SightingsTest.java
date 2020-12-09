import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SightingsTest {

    @Test
    public void createInstanceOfSightingsClass_true() {

        Sightings sighting= setUpNewSighting();
        assertEquals(true,sighting instanceof Sightings);
    }
//    @Test
//    public void allInstancesAreSaved() {
//        Sightings sightings=setUpNewSighting();
//        Sightings otherSighting=new Sightings(-1,1,1);
//        try {
//            sightings.save();
//            otherSighting.save();
//            assertTrue(Sightings.find(sightings.getId()).equals(sightings));
//        }catch (IllegalArgumentException e){
//            System.out.println(e);
//        }
//    }

//    @Test
//    public void findSightingByID() {
//        Sightings sighting=setUpNewSighting();
//        sighting.save();
//        Sightings foundSighting=Sightings.find(sighting.getId());
//        assertEquals(foundSighting, sighting);
//
//    }

    //helper
    private Sightings setUpNewSighting() {
        return new Sightings(1,1,1);
    }
}
