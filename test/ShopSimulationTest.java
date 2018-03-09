import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class ShopSimulationTest {
    @Test
    public void testRandom() {
        ShopSimulation ss = new ShopSimulation(3, 20);
        Shop shop = ss.getShop();
        Random rnd = new Random(1001);

        //rd1
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(6, shop.getCounterTime(0));
        Assert.assertEquals(0, shop.getCounterTime(1));
        Assert.assertEquals(0, shop.getCounterTime(2));
        Assert.assertEquals("[ ]", shop.getQueue().toString());

        //rd2
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(6, shop.getCounterTime(0));
        Assert.assertEquals(7, shop.getCounterTime(1));
        Assert.assertEquals(0, shop.getCounterTime(2));
        Assert.assertEquals("[ ]", shop.getQueue().toString());

        //rd3
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(6, shop.getCounterTime(0));
        Assert.assertEquals(7, shop.getCounterTime(1));
        Assert.assertEquals(0, shop.getCounterTime(2));
        Assert.assertEquals("[ ]", shop.getQueue().toString());

        //rd4
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(6, shop.getCounterTime(0));
        Assert.assertEquals(7, shop.getCounterTime(1));
        Assert.assertEquals(9, shop.getCounterTime(2));
        Assert.assertEquals("[ ]", shop.getQueue().toString());

        //rd5
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(6, shop.getCounterTime(0));
        Assert.assertEquals(7, shop.getCounterTime(1));
        Assert.assertEquals(9, shop.getCounterTime(2));
        Assert.assertEquals("[ 6 ]", shop.getQueue().toString());

        //rd6
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(12, shop.getCounterTime(0));
        Assert.assertEquals(7, shop.getCounterTime(1));
        Assert.assertEquals(9, shop.getCounterTime(2));
        Assert.assertEquals("[ 5 ]", shop.getQueue().toString());

        //rd7
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(12, shop.getCounterTime(0));
        Assert.assertEquals(12, shop.getCounterTime(1));
        Assert.assertEquals(9, shop.getCounterTime(2));
        Assert.assertEquals("[ 4 ]", shop.getQueue().toString());

        //rd8
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(12, shop.getCounterTime(0));
        Assert.assertEquals(12, shop.getCounterTime(1));
        Assert.assertEquals(9, shop.getCounterTime(2));
        Assert.assertEquals("[ 4 3 ]", shop.getQueue().toString());

        //rd9
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(12, shop.getCounterTime(0));
        Assert.assertEquals(12, shop.getCounterTime(1));
        Assert.assertEquals(13, shop.getCounterTime(2));
        Assert.assertEquals("[ 3 ]", shop.getQueue().toString());

        //rd10
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(12, shop.getCounterTime(0));
        Assert.assertEquals(12, shop.getCounterTime(1));
        Assert.assertEquals(13, shop.getCounterTime(2));
        Assert.assertEquals("[ 3 1 ]", shop.getQueue().toString());

        //rd11
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(12, shop.getCounterTime(0));
        Assert.assertEquals(12, shop.getCounterTime(1));
        Assert.assertEquals(13, shop.getCounterTime(2));
        Assert.assertEquals("[ 3 1 1 ]", shop.getQueue().toString());

        //rd12
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(15, shop.getCounterTime(0));
        Assert.assertEquals(13, shop.getCounterTime(1));
        Assert.assertEquals(13, shop.getCounterTime(2));
        Assert.assertEquals("[ 1 3 ]", shop.getQueue().toString());

        //rd13
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(15, shop.getCounterTime(0));
        Assert.assertEquals(14, shop.getCounterTime(1));
        Assert.assertEquals(16, shop.getCounterTime(2));
        Assert.assertEquals("[ 5 ]", shop.getQueue().toString());

        //rd14
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(15, shop.getCounterTime(0));
        Assert.assertEquals(19, shop.getCounterTime(1));
        Assert.assertEquals(16, shop.getCounterTime(2));
        Assert.assertEquals("[ 5 ]", shop.getQueue().toString());

        //rd15
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(20, shop.getCounterTime(0));
        Assert.assertEquals(19, shop.getCounterTime(1));
        Assert.assertEquals(16, shop.getCounterTime(2));
        Assert.assertEquals("[ ]", shop.getQueue().toString());

        //rd16
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(20, shop.getCounterTime(0));
        Assert.assertEquals(19, shop.getCounterTime(1));
        Assert.assertEquals(21, shop.getCounterTime(2));
        Assert.assertEquals("[ ]", shop.getQueue().toString());

        //rd17
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(20, shop.getCounterTime(0));
        Assert.assertEquals(19, shop.getCounterTime(1));
        Assert.assertEquals(21, shop.getCounterTime(2));
        Assert.assertEquals("[ 5 ]", shop.getQueue().toString());

        //rd18
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(20, shop.getCounterTime(0));
        Assert.assertEquals(19, shop.getCounterTime(1));
        Assert.assertEquals(21, shop.getCounterTime(2));
        Assert.assertEquals("[ 5 6 ]", shop.getQueue().toString());

        //rd19
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(20, shop.getCounterTime(0));
        Assert.assertEquals(24, shop.getCounterTime(1));
        Assert.assertEquals(21, shop.getCounterTime(2));
        Assert.assertEquals("[ 6 1 ]", shop.getQueue().toString());

        //rd20
        ss.timeLapse(rnd.nextInt(7));
        Assert.assertEquals(26, shop.getCounterTime(0));
        Assert.assertEquals(24, shop.getCounterTime(1));
        Assert.assertEquals(21, shop.getCounterTime(2));
        Assert.assertEquals("[ 1 3 ]", shop.getQueue().toString());

        //Final Data
        Assert.assertEquals(20, ss.getCurrentTime());
        Assert.assertEquals(3, ss.getCounters());
        Assert.assertEquals(15, ss.getServedCustomer());
        Assert.assertEquals("1.1", String.format("%.1f", ss.getAverageQueue()));
        Assert.assertEquals(3, ss.getMaxQueue());
    }

    @Test
    public void testCustomInput() {
        ShopSimulation ss = new ShopSimulation(3, 10);
        Shop shop = ss.getShop();

        //rd1
        ss.timeLapse(5);
        Assert.assertEquals(6, shop.getCounterTime(0));
        Assert.assertEquals(0, shop.getCounterTime(1));
        Assert.assertEquals(0, shop.getCounterTime(2));
        Assert.assertEquals("[ ]", shop.getQueue().toString());

        //rd2
        ss.timeLapse(0);
        Assert.assertEquals(6, shop.getCounterTime(0));
        Assert.assertEquals(0, shop.getCounterTime(1));
        Assert.assertEquals(0, shop.getCounterTime(2));
        Assert.assertEquals("[ ]", shop.getQueue().toString());

        //rd3
        ss.timeLapse(4);
        Assert.assertEquals(6, shop.getCounterTime(0));
        Assert.assertEquals(7, shop.getCounterTime(1));
        Assert.assertEquals(0, shop.getCounterTime(2));
        Assert.assertEquals("[ ]", shop.getQueue().toString());

        //rd4
        ss.timeLapse(5);
        Assert.assertEquals(6, shop.getCounterTime(0));
        Assert.assertEquals(7, shop.getCounterTime(1));
        Assert.assertEquals(9, shop.getCounterTime(2));
        Assert.assertEquals("[ ]", shop.getQueue().toString());

        //rd5
        ss.timeLapse(1);
        Assert.assertEquals(6, shop.getCounterTime(0));
        Assert.assertEquals(7, shop.getCounterTime(1));
        Assert.assertEquals(9, shop.getCounterTime(2));
        Assert.assertEquals("[ 1 ]", shop.getQueue().toString());

        //rd6
        ss.timeLapse(2);
        Assert.assertEquals(7, shop.getCounterTime(0));
        Assert.assertEquals(7, shop.getCounterTime(1));
        Assert.assertEquals(9, shop.getCounterTime(2));
        Assert.assertEquals("[ 2 ]", shop.getQueue().toString());

        //rd7
        ss.timeLapse(2);
        Assert.assertEquals(9, shop.getCounterTime(0));
        Assert.assertEquals(9, shop.getCounterTime(1));
        Assert.assertEquals(9, shop.getCounterTime(2));
        Assert.assertEquals("[ ]", shop.getQueue().toString());

        //rd8
        ss.timeLapse(2);
        Assert.assertEquals(9, shop.getCounterTime(0));
        Assert.assertEquals(9, shop.getCounterTime(1));
        Assert.assertEquals(9, shop.getCounterTime(2));
        Assert.assertEquals("[ 2 ]", shop.getQueue().toString());

        //rd9
        ss.timeLapse(5);
        Assert.assertEquals(11, shop.getCounterTime(0));
        Assert.assertEquals(14, shop.getCounterTime(1));
        Assert.assertEquals(0, shop.getCounterTime(2));
        Assert.assertEquals("[ ]", shop.getQueue().toString());

        //rd10
        ss.timeLapse(2);
        Assert.assertEquals(11, shop.getCounterTime(0));
        Assert.assertEquals(14, shop.getCounterTime(1));
        Assert.assertEquals(12, shop.getCounterTime(2));
        Assert.assertEquals("[ ]", shop.getQueue().toString());

        //Final Data
        Assert.assertEquals(10, ss.getCurrentTime());
        Assert.assertEquals(3, ss.getCounters());
        Assert.assertEquals(9, ss.getServedCustomer());
        Assert.assertEquals("0.3", String.format("%.1f", ss.getAverageQueue()));
        Assert.assertEquals(1, ss.getMaxQueue());

    }

}
