public abstract class Asset implements Accrueable {
    protected String name;
    protected double value;
    protected assetType type;
    protected double rate;
    protected double period;
    protected double principal;


    public Asset(String name, assetType type, double rate, double period, double principal) {
        this.name = name;
        this.type = type;
        this.rate = rate;
        this.period = period;
        this.principal = principal;

    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public assetType getType() {
        return type;
    }

    public double getRate() {
        return rate;
    }

    public double getPeriod() {
        return period;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPeriod(double period) {
        this.period = period;
    }


}
