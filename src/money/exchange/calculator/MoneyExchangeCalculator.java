
package money.exchange.calculator;

import maneyexchangecalculator.persistence.CurrencyListLoaderCSV;
import maneyexchangecalculator.persistence.RateListLoaderCSV;
import moneyexchangecalculator.model.CurrencyList;
import moneyexchangecalculator.model.RateList;
import moneyexchangecalculator.view.View;


public class MoneyExchangeCalculator {

   private static  final String fileNameCurrencies="Currencies.txt";
   private static  final String fileNameRates="Rates.txt";
    public static void main(String[] args) {
        CurrencyList currencies=new CurrencyListLoaderCSV(fileNameCurrencies).load();
        
        RateList rates=new RateListLoaderCSV(fileNameRates).load();
        
        new View(currencies, rates).setVisible(true);
      
    } 
    
}
