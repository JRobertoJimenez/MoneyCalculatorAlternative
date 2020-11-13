
package moneyexchangecalculator.model;


public class Rate {
    private final double rate;
    private final String originCurrency;
    private final String destinyCurrency;
    private final String ID;

    public Rate(double rate, String originCurrency, String destinyCurrency) {
        this.rate = rate;
        this.originCurrency = originCurrency;
        this.destinyCurrency = destinyCurrency;
        ID= originCurrency+"-"+destinyCurrency;
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

    Object getOriginCurrency() {
        return originCurrency;
    }

    String getDestinyCurrency() {
        return destinyCurrency;
    }
      
}
