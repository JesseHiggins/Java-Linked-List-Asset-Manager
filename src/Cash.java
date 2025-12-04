public class Cash extends Asset {
    public Cash(String name, double rate, double period, double principal, double age) {
        super(name, assetType.CASH, rate, period, principal);
    }

    @Override
    public void accrue() {
        this.value = principal * Math.pow((1 + rate / 100), period);
    }

    @Override
    public String toString() {
        return Cash.class.getSimpleName() + "  [" +
                "name=" + name +
                ", value=" + value +
                ", type=" + type +
                ", rate=" + rate +
                ", period=" + period +
                ", principal=" + principal +
                ']';
    }
    
}
