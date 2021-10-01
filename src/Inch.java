public class Inch extends AbstractUnit implements IUnit{

    /**
     * Constructor #1 Initialize a Inch Object Without params
     * means create a new Inch object with value set in 0
     */
    public Inch(){
        super.value = 0;
    }

    /**
     * Constructor #2 Inicialize a Inch Object with
     * initial double Value
     * @param  aValue (double)
     */
    public Inch(double aValue){
        super.value = aValue;
    }

    /**
     * Passing via Double Dispatch the message to IUnit object
     * calculating the new IUnit object knowing that it's is adding
     * for a Inch object
     * @param anotherIUnit '(IUnit)'
     * @return message
     */
    @Override
    public IUnit add(IUnit anotherIUnit) {
        return anotherIUnit.addBeeingInch(this);
    }

    /**
     * Adding directly knowing the param is a double
     * @param  aValue (double)
     * @return (IUnit) Inch Object
     */
    @Override
    public IUnit add(double aValue) {
        return new Inch(this.value + aValue);
    }

    /**
     * Creating a new Meter Object, knowing that the call
     * is something like: Meter.add(Inch)
     * @param aMeter  (IUnit)
     * @return (IUnit) Meter object
     */
    @Override
    public IUnit addBeeingMeter(Meter aMeter) {
        return new Meter(aMeter.getValue() + this.getValue() * 0.0254);
    }

    /**
     * Creating a new Inch Object, knowing that the call
     * is something like: Inch.add(Inch)
     * @param  aInch (IUnit)
     * @return Inch object
     */
    @Override
    public IUnit addBeeingInch(Inch aInch) {
        return new Inch(this.getValue() + aInch.getValue());
    }

}
