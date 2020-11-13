
package moneyexchangecalculator.model;

public class Currency {
    private final String ID;
    private final String name;

    public Currency(String ID, String name) {
        this.ID = ID;
        this.name = name;
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
