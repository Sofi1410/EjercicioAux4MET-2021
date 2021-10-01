import java.util.Objects;

public class Inch implements IUnit {

    private double value;

    public Inch(double medida) {
        value=medida;
    }

    public double getValue() {
        return value;
    }


    //Inch + algo -> Inch
    public Inch add(IUnit unit) {
        return unit.addToAInch(this);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inch)) return false;
        Inch inch = (Inch) o;
        return Double.compare(inch.value, value) == 0;
    }


    // metro a + Inch b
    //a.add(b) -> b.addToAMeter(a)
    // b this
    @Override
    public Meter addToAMeter(Meter meter) {
                            // 2 m  + value*0.0254
        Meter result= new Meter(meter.getValue()+value*0.254);
        return result;
    }

    //Inch algo, Inch + Inch

    @Override
    public Inch addToAInch(Inch inch) {
        Inch result= new Inch( inch.getValue()+ this.value);
        return result;
    }
}
