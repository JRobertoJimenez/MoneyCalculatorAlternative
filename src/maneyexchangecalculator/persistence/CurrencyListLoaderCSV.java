/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maneyexchangecalculator.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import moneyexchangecalculator.model.Currency;
import moneyexchangecalculator.model.CurrencyList;

/**
 *
 * @author José Roberto Jiménez
 */
public class CurrencyListLoaderCSV implements CurrencyListLoader{
    private final String path;

    public CurrencyListLoaderCSV(String path) {
        this.path = path;
    }
    

    @Override
    public CurrencyList load() {
        CurrencyList currencyList =new CurrencyList();
        try {
            BufferedReader br= new BufferedReader(new FileReader(path));
            String [] data;
            String line=br.readLine();
            while(line !=null){
                data=line.split(";");
                currencyList.putCurrency(new Currency(data[0], data[1]));
                line=br.readLine();
            }
        } catch (Exception e) {
            System.out.println("Se ha producido una excepcion: "+e.getMessage());
        }
        return currencyList;
    }
    
    
    
}
