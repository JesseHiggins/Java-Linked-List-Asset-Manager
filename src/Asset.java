public abstract class Asset implements Accrueable {
    protected String name;
    protected double value;
    protected assetType type;
    protected double rate;
    protected double period;
    protected double principal;
    protected double age;


    public Asset(String name, double value, assetType type, double rate, double period, double principal, double age) {
        this.name = name;
        this.value = value;
        this.type = type;
        this.rate = rate;
        this.period = period;
        this.principal = principal;
        this.age = age;

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

    public double getAge() {
        return age;
    }


}
