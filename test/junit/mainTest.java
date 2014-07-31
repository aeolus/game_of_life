import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: chengwei
 * Date: 30/07/14
 * Time: 11:44
 * To change this template use File | Settings | File Templates.
 */

public class mainTest {
    @Test
    public void testRuleOne() {
        world w = new world(3);
        w.seed(1, 1);
        w.tick();
        assertEquals(false, w.isAlive(1, 1));
    }

    @Test
    public void testRuleTwo() {
        world w = new world(3);
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
        world w = new world(3);
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
        world w = new world(3);
        w.seed(0, 1);
        w.seed(1, 0);
        w.seed(1, 2);
        w.tick();
        assertEquals(true, w.isAlive(1, 1));

    }
}
