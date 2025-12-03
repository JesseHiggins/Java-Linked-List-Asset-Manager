public class Stock extends Asset {
    private double price;
    private double shares;

    public Stock(String name, double rate, double period, double principal, double price) {
        super(name, assetType.STOCK, rate, period, principal);
        this.price = price;
        this.shares = principal / price;
    }

    @Override
    public void accrue() {
        this.value = principal * Math.pow((1 + rate / 100), period);
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
    
    @Override
    public String toString() {
        return Stock.class.getSimpleName() + " [" +
                "name=" + name +
                ", value=" + value +
                ", type=" + type +
                ", rate=" + rate +
                ", period=" + period +
                ", principal=" + principal +
                ", price=" + price +
                ", shares=" + shares +
                ']';
    }
}
