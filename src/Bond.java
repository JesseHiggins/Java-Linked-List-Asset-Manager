public class Bond extends Asset {
    double faceValue;
    double maturity;

    public Bond(String name, double value, double rate, double period, double principal, double age, double faceValue, double maturity) {
        super(name, value, assetType.BOND, rate, period, principal);
        this.faceValue = faceValue;
        this.maturity = maturity;
    }

    @Override
    public double accrue() {
        double totalCoupons = rate * faceValue * period;
        double maturityValue = faceValue - principal;
        if (period >= maturity) {
            return totalCoupons + maturityValue;
        }
        return totalCoupons;
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

}
