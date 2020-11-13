/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneyexchangecalculator.model;

/**
 *
 * @author José Roberto Jiménez
 */
public class Money {
    private final Currency currency;
    private final double amount;

    public Money(Currency currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return amount + " " + currency.getID(); 
    }
    
    
    
}
