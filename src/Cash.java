public class Cash extends Asset {
    public Cash(String name, double value, double rate, double period, double principal, double age) {
        super(name, value, assetType.CASH, rate, period, principal, age);
    }

    @Override
    public double accrue() {
        return principal * Math.pow((1 + rate / 100), period) - principal;
    }
    
}
