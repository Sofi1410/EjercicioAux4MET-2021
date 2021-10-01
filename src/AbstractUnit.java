import java.util.Objects;

public abstract class AbstractUnit implements IUnit{
    protected double value;

    @Override
    public double getValue() {
        return value;
    }
    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractUnit that = (AbstractUnit) o;
        return Double.compare(that.value, value) == 0;
    }
}
