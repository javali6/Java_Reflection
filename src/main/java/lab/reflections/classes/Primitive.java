package lab.reflections.classes;

public class Primitive {

    private int number;
    private double aDouble;
    private String someName;

    public Primitive() {
        number = 21;
        aDouble = 37.2;
        someName = "Name";
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getaDouble() {
        return aDouble;
    }

    public void setaDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    public String getSomeName() {
        return someName;
    }

    public void setSomeName(String someName) {
        this.someName = someName;
    }

    @Override
    public String toString() {
        return "Primitive{" +
                "number=" + number +
                ", aDouble=" + aDouble +
                ", someName='" + someName + '\'' +
                '}';
    }
}
