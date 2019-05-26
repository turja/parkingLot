import com.gojek.parkinglot.HashMapTest;
import com.gojek.parkinglot.ParkingLot;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tushar on 5/26/19.
 */
public class ParkingTest {
    @Test
    public void ParkingLot1Test() {
        ParkingLot parkingLot = new ParkingLot(); // MyClass is tested

        // assert statements
        //assertEquals(0, parkingLot.multiply(10, 0), "10 x 0 must be 0");
    }

    @Test
    public void HashReferenceTest() {
        HashMapTest hashMapTest = new HashMapTest(); // MyClass is tested

        // assert statements
        hashMapTest.TestHash("Car1");
        assertEquals("Car1 returned 3", 3, hashMapTest.getCarList("Car1"));
    }
}
