public class Bond extends Asset {
    private double faceValue;
    private double maturity;

    public Bond(String name, double rate, double period, double principal, double faceValue, double maturity) {
        super(name, assetType.BOND, rate, period, principal);
        this.faceValue = faceValue;
        this.maturity = maturity;
    }

    @Override
    public void accrue() {
        double totalCoupons = faceValue * period * (rate / 100);
        if (this.isMatured()) {
            this.value = totalCoupons + faceValue;
        } else {
            this.value = totalCoupons;
        }
    }

    public double getMaturity() {
        return maturity;
    }

    public double getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(double faceValue) {
        this.faceValue = faceValue;
    }
    
    public void setMaturity(double maturity) {
        this.maturity = maturity;
    }

    public boolean isMatured() {
        return period >= maturity;
    }

    @Override
    public String toString() {
        return Bond.class.getSimpleName() + " [" +
                "name=" + name +
                ", value=" + value +
                ", type=" + type +
                ", rate=" + rate +
                ", period=" + period +
                ", principal=" + principal +
                ", faceValue=" + faceValue +
                ", maturity=" + maturity +
                ']';
    }

}
