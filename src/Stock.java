public class Stock extends Asset {
    double price;
    double shares;

    public Stock(String name, double value, double rate, double period, double principal, double age, double price) {
        super(name, value, assetType.STOCK, rate, period, principal);
        this.price = price;
        this.shares = principal / price;
    }

    @Override
    public double accrue() {
        return principal * Math.pow((1 + rate / 100), period) - principal;
    }

    public double getPrice() {
        return price;
    }

    public double getShares() {
        return shares;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
