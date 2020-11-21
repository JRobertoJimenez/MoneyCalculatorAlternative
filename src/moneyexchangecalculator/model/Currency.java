
package moneyexchangecalculator.model;

public class Currency {
    private final String ID, name, symbol;

    public Currency(String ID, String name, String symbol) {
        this.ID = ID;
        this.name = name;
        this.symbol=symbol;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return ID +" corresponde a "+name;
    }
    
    
    
}
