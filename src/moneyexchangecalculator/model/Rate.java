
package moneyexchangecalculator.model;


public class Rate {
    private final double rate;
    private final Currency originCurrency, destinyCurrency;
    private final String ID;

    public Rate(Currency originCurrency, Currency destinyCurrency, double rate) {
        this.rate = rate;
        this.originCurrency = originCurrency;
        this.destinyCurrency = destinyCurrency;
        ID= originCurrency.getID()+"-"+destinyCurrency.getID();
    }

    public double getRate() {
        return rate;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Un "+originCurrency+" es igual a "+
                rate+" "+destinyCurrency;
    }

    public String getOriginCurrency() {
        return originCurrency.getID();
    }

    public String getDestinyCurrency() {
        return destinyCurrency.getID();
    }
      
}
