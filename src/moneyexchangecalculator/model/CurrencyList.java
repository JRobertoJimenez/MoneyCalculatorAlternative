/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneyexchangecalculator.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author José Roberto Jiménez
 */
public class CurrencyList {
    private Map<String,Currency> currencyList;

    public CurrencyList(Map< String,Currency> currencyList) {
        this.currencyList = currencyList;
    }

    public CurrencyList() {
        currencyList= new HashMap();
    }

    public Map< String, Currency> getCurrencyList() {
        return currencyList;
    }
    
    public Currency getCurrency (String ID){
        return currencyList.get(ID);
    }
    
    public void putCurrency(Currency currency){
        currencyList.put(currency.getID(), currency);
    }
    
    public String [] getCurrencies(){
        String [] currencies= new String[currencyList.size()];
        int i=0;
        for (String currency : currencyList.keySet()) {
            currencies[i]= currency;
            i++;
        }
        return currencies;
    }
    
    @Override
    public String toString(){
        String aux="";
        for (Currency currency : currencyList.values()) {
            aux+=currency.toString()+"\n";
        }
        return aux;
    }
}
