import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class MetricsTest {
    private Inch prueba1;
    private Meter prueba2;

    @Before
    public void setUp(){
        //prueba1 = new Inch();
        //prueba2= new Meter();
    }

    @Test
    public void addInch(){
        Meter nuevoMetro= new Meter(1);
        Inch nuevaPulgada= new Inch(39);
        Meter resultado = nuevoMetro.add(nuevaPulgada);
        Meter expected= new Meter(1.9906 );
        assertTrue(expected.equals(resultado));
    }

    @Test
    public void addMeter(){
        Meter nuevoMetro= new Meter(2);
        Inch nuevaPulgada= new Inch(10);
        Inch resultado= nuevaPulgada.add(nuevoMetro);
        Inch expected= new Inch(88.74);
        assertTrue(expected.equals(resultado));
    }

    @Test
    public void  MeteraddMeter(){
        Meter nuevoMetro= new Meter(5);
        Meter nuevoMetro2= new Meter(3);
        Meter resultado = nuevoMetro.add(nuevoMetro2);
        Meter expected= new Meter(8);
        assertTrue(expected.equals(resultado));
    }

    @Test
    public void InchaddInch(){
        Inch nuevaPulgada= new Inch(3);
        Inch nuevaPulgada2= new Inch(10);
        Inch resultado= nuevaPulgada.add(nuevaPulgada2);
        Inch expected= new Inch(13);
        assertTrue(expected.equals(resultado));
    }



}
