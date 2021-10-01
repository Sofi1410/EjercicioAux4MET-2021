import java.util.Objects;

public class Meter extends AbstractUnit implements IUnit{

    /**
     * Constructor #1 Initialize a Meter Object Without params
     * means create a new Meter object with value set in 0
     */
    public Meter(){
        value = 0;
    }

    /**
     * Constructor #2 Inicialize a Meter Object with
     * initial double Value
     * @param (double) aValue
     */
    public Meter(double aValue){
        value = aValue;
    }

    /**
     * Passing via Double Dispatch the message to IUnit object
     * calculating the new IUnit object knowing that it's is adding
     * for a Meter object
     * @param (IUnit) anotherIUnit
     * @return message
     */
    @Override
    public IUnit add(IUnit anotherIUnit) {
        return anotherIUnit.addBeeingMeter(this);
    }

    /**
     * Adding directly knowing the param is a double
     * @param (double) aValue
     * @return (IUnit) Meter Object
     */
    @Override
    public IUnit add(double aValue) {
        return new Meter(this.value + aValue);
    }

    /**
     * Creating a new Meter Object, knowing that the call
     * is something like: Meter.add(Meter)
     * @param (IUnit) aMeter
     * @return (IUnit) Meter object
     */
    @Override
    public IUnit addBeeingMeter(Meter aMeter) {
        return new Meter(this.getValue() + aMeter.getValue());
    }

    /**
     * Creating a new Inch Object, knowing that the call
     * is something like: Inch.add(Meter)
     * @param (IUnit) aInch
     * @return Inch object
     */
    @Override
    public IUnit addBeeingInch(Inch aInch) {
        return new Inch(aInch.getValue() + (this.getValue() * 39.37));
    }
}
