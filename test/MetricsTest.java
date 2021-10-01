import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MetricsTest {
    private IUnit aInch;
    private IUnit aMeter;

    @Before
    public void setUp(){
        aInch = new Inch();
        aMeter = new Meter();
    }

    /**
     * Init Testing
     */
    @Test
    public void initTest(){
        assertEquals(new Inch(), aInch);
        assertEquals(new Meter(), aMeter);
        assertNotEquals(new Inch(5), aInch);
        assertNotEquals(new Meter(5), aMeter);
    }

    /**
     * Adding meter + meter testing
     */
    @Test
    public void meterAddTest(){
        Meter anotherMeter = new Meter(5);
        assertEquals(5, (aMeter.add(anotherMeter)).getValue(), 0.0f);
        assertEquals(25.085, (aMeter.add(25.085)).getValue(), 0.0f);
    }

    /**
     * Adding inch + inch testing
     */
    @Test
    public void inchAddTest(){
        Inch anotherInch = new Inch(5);
        assertEquals(5, aInch.add(anotherInch).getValue(), 0.0f);
        assertEquals(25.085, (aInch.add(25.085)).getValue(), 0.0f);
    }

    /**
     * Testing Homework cases
     */
    @Test
    public void casesInHomeworkTest(){
        IUnit otherInch = new Inch(39);
        IUnit otherMeter = new Meter(1);

        assertEquals(aMeter.getClass(), (otherMeter.add(otherInch)).getClass());
        assertEquals(aInch.getClass(), (otherInch.add(otherMeter)).getClass());

        Inch i10 = new Inch(10);
        Inch i3 = new Inch(3);
        Meter m2 = new Meter(2);
        Meter m3 = new Meter(3);
        Meter m5 = new Meter(5);

        assertEquals(1.9906, (otherMeter.add(otherInch)).getValue(), 0.0f);
        assertEquals(88.74, (i10.add(m2)).getValue(), 0.0f);
        assertEquals(8, (m5.add(m3)).getValue(), 0.0f);
        assertEquals(13, (i3.add(i10)).getValue(), 0.0f);
    }

    /**
     * Testing adding n times diferents orders of inch or meter together
     */
    @Test
    public void nAddingsTest(){
        IUnit i1 = new Inch(1);
        IUnit i2 = new Inch(2);
        IUnit i3 = new Inch(3);

        IUnit m1 = new Meter(1);
        IUnit m2 = new Meter(2);
        IUnit m3 = new Meter(3);

        IUnit otherInch = i1.add(i2).add(i3); // expected: 6 inchs
        assertEquals(6, otherInch.getValue(), 0.0f);

        IUnit otherMeter = m1.add(m2).add(m3); // expected: 6 metters
        assertEquals(6, otherMeter.getValue(), 0.0f);

        IUnit inchWithALotOfAdds = i1.add(m1).add(m2).add(i2).add(i3).add(m3); // expected: 242.22 inchs
        assertEquals(242.22,inchWithALotOfAdds.getValue(), 0.01);

        IUnit meterWithALotOfAdds = m1.add(i3).add(i1).add(m2).add(i2).add(m3); // expected: 6.1524 metters
        assertEquals(6.1524, meterWithALotOfAdds.getValue(), 0.01);
    }
}
