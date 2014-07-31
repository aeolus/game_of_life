import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Rules {
    @Test
    public void testRuleOne() {
        World w = new World(3);
        w.seed(1, 1);
        w.tick();
        assertEquals(false, w.isAlive(1, 1));
    }

    @Test
    public void testRuleTwo() {
        World w = new World(3);
        w.seed(1, 1);
        w.seed(0, 1);
        w.seed(2, 1);
        w.tick();
        assertEquals(true, w.isAlive(1, 1));
        assertEquals(false, w.isAlive(0, 1));
        assertEquals(false, w.isAlive(2, 1));
    }

    @Test
    public void testRuleThree() {
        World w = new World(3);
        w.seed(0, 0);
        w.seed(0, 1);
        w.seed(1, 0);
        w.seed(1, 1);
        w.seed(2, 1);
        w.tick();
        assertEquals(true, w.isAlive(0, 0));
        assertEquals(true, w.isAlive(0, 1));
        assertEquals(true, w.isAlive(0, 0));
        assertEquals(false, w.isAlive(1, 0));
        assertEquals(false, w.isAlive(1, 1));
        assertEquals(true, w.isAlive(2, 1));
    }

    @Test
    public void testRuleFour() {
        World w = new World(3);
        w.seed(0, 1);
        w.seed(1, 0);
        w.seed(1, 2);
        w.tick();
        assertEquals(true, w.isAlive(1, 1));

    }
}
