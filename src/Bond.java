public class Bond extends Asset {
    double coupon;
    double faceValue;
    double maturity;
    double price;
    double ytm;

    public Bond(String name, double value, double rate, double period, double principal, double age, double coupon, double faceValue, double maturity) {
        super(name, value, assetType.BOND, rate, period, principal, age);
        this.coupon = coupon;
        this.faceValue = faceValue;
        this.maturity = maturity;
        this.ytm = getYieldToMaturity();
        this.price = getCurrentPrice();
    }

    @Override
    public double accrue() {
        double totalCoupons = coupon * period;
        double maturityValue = faceValue - principal;
        return totalCoupons + maturityValue;
    }

    public double getMaturity() {
        return maturity;
    }

    public double getCoupon() {
        return coupon;
    }

    public double getFaceValue() {
        return faceValue;
    }

    public void setCoupon(double coupon) {
        this.coupon = coupon;
    }

    public void setFaceValue(double faceValue) {
        this.faceValue = faceValue;
    }
    
    public void setMaturity(double maturity) {
        this.maturity = maturity;
    }

    public double getYieldToMaturity() {
        double ytm = (coupon + (faceValue - principal) / maturity) / ((faceValue + principal) / 2);
        return ytm * 100;
    }

    public double getCurrentPrice() {
        double price = (coupon * (1 - Math.pow(1 + rate / 100, -maturity)) / (rate / 100)) + (faceValue / Math.pow(1 + rate / 100, maturity));
        return price;
    }
}
