public class Bond extends Asset {
    double faceValue;
    double maturity;
    double price;

    public Bond(String name, double value, double rate, double period, double principal, double age, double coupon, double faceValue, double maturity) {
        super(name, value, assetType.BOND, rate, period, principal, age);
        this.faceValue = faceValue;
        this.maturity = maturity;
        this.price = getCurrentPrice();
    }

    @Override
    public double accrue() {
        double totalCoupons = rate * faceValue * period;
        double maturityValue = faceValue - principal;
        return totalCoupons + maturityValue;
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

    public double getCurrentPrice() {
        double price = ((rate * faceValue * period) * (1 - Math.pow(1 + rate / 100, -maturity)) / (rate / 100)) + (faceValue / Math.pow(1 + rate / 100, maturity));
        return price;
    }
}
