import java.util.Objects;


public class Meter implements IUnit {
    private double value ;
    public Meter(double medida) {
        value=medida;
    }

    //metroA.add(metroB) -> 2 m + 4 m

    // metroA.add(inchb) -> 2m + 1 inch
    public Meter add(IUnit unidad){
        return unidad.addToAMeter(this);

    }

    public Meter add(Inch pulgada) {
        Meter resultado= new Meter(
                value+ pulgada.getValue()* 0.0254 ) ;
        return resultado;
    }

    //nos estamos sumando con un metro
    public Meter addToAMeter(Meter meter) {
        Meter resultado= new Meter(
                value+ meter.getValue()) ;
        return resultado;
    }


    // Meter + Inch

    @Override
    public Inch addToAInch(Inch inch) {
        Inch result = new Inch(inch.getValue() + this.value*39.37);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meter)) return false;
        Meter meter = (Meter) o;
        return Double.compare(meter.value, value) == 0;
    }


    public double getValue() {
        return value;

    }
}
