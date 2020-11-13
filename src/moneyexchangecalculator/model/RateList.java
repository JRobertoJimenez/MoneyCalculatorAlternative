/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneyexchangecalculator.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.ComboBoxModel;

/**
 *
 * @author José Roberto Jiménez
 */
public class RateList {
    private Map<String, Rate> rateList;

    public RateList(Map<String, Rate> rateList) {
        this.rateList = rateList;
    }

    public RateList() {
        rateList= new HashMap();
    }

    public Map<String, Rate> getRateList() {
        return rateList;
    }
    
    public Rate  getRate(String ID){
        return rateList.get(ID);
    }
    
    public void putRate(Rate rate){
        rateList.put(rate.getID(), rate);
    }

    public String[] getRateForCurrency(String originCurrency) {
        List<String> list=new Vector<>();
        for (Rate rate: rateList.values()) {
             if (rate.getOriginCurrency().equals(originCurrency)){
                    list.add(rate.getDestinyCurrency());
             }
        }
        
        String [] rates=new String[list.size()];
        int i=0;
        for (String string : list) {
            rates[i]=string;
            i++;
        }
        
        
        return rates;
    }

    public double Exchange(Money money, String selectedCurrency) {
        Double exchange=money.getAmount() *
                this.getRate(money.getCurrency().getID()+"-"+selectedCurrency).getRate();
        return Math.round(exchange*100)/100.0;
       
    }
    
    

    
    
    
    
}
