

package designpat.bakery;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * just class for JUnit test, to check if the code is behaving as expected
 * @author Pavel Detvan & Martin Popov
 */
public class cakeTesting {
    @Test
    public void testVanillaCake() {
        Cake cake = new VanillaCake();
        assertEquals(10, cake.getCost());
        assertEquals("Vanilla cake ", cake.getDescription());
    }

    @Test
    public void testChocolateCake() {
        Cake cake = new ChocolateCake();
        assertEquals(10, cake.getCost());
        assertEquals("Chocolate cake ", cake.getDescription());
    }

    @Test
    public void testMultiLayeredCake() {
        Cake cake = new MultiLayered(new VanillaCake());
        assertEquals(15, cake.getCost());
        assertEquals("Multi-Layered Vanilla cake ", cake.getDescription());
    }

    @Test
    public void testSprinklesCake() {
        Cake cake = new Sprinkles(new VanillaCake());
        assertEquals(12, cake.getCost());
        assertEquals("Vanilla cake with sprinkles ", cake.getDescription());
    }

    @Test
    public void testSayingCake() {
        Cake cake = new Saying(new VanillaCake(), "PLAIN!");
        assertEquals(10, cake.getCost());
        assertEquals("Vanilla cake with saying \"PLAIN!\" ", cake.getDescription());
    }

    @Test
    public void testStrawberryCake() {
        Cake cake = new StrawberryCake();
        assertEquals(20, cake.getCost());
        assertEquals("Strawberry cake ", cake.getDescription());
    }
}
