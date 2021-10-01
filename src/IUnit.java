public interface IUnit {
    public double getValue();
    public IUnit add(IUnit anotherIUnit);
    public IUnit add(double aValue);
    public IUnit addBeeingMeter(Meter aMeter);
    public IUnit addBeeingInch(Inch aInch);
}
