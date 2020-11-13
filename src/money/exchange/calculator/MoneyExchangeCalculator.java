
package money.exchange.calculator;

import maneyexchangecalculator.persistence.CurrencyListLoaderCSV;
import maneyexchangecalculator.persistence.RateListLoaderCSV;
import moneyexchangecalculator.model.CurrencyList;
import moneyexchangecalculator.model.Money;
import moneyexchangecalculator.model.RateList;
import moneyexchangecalculator.view.View;


public class MoneyExchangeCalculator {

   private static  final String fileNameCurrencies="Currencies.txt";
   private static  final String fileNameRates="Rates.txt";
   private static CurrencyList currencies;
   private static RateList rates;
   private static View view;
    public static void main(String[] args) {
        input();
        view();
        
        
      
    } 
    
    private static void input(){
        currencies=new CurrencyListLoaderCSV(fileNameCurrencies).load();
        
        rates=new RateListLoaderCSV(fileNameRates).load();
        
    }
    
    private static void view(){
        view = new View();
        view.setOriginCurrencies(currencies.getCurrencies());
        view.setVisible(true);
    }
    
    public static void process(String args[]){
        String cod=args[0];
        if(cod.equals("jCB1")){
        view.setDestinyCurrencies(rates.getRateForCurrency(args[1]));

        }else{
            if(cod.equals("jB1")){
                double rate=rates.Exchange( (new Money(currencies.getCurrency((String) args[1]),
                Double.parseDouble(args[3]))),
                        args[2]);

                String [] aux={rate+"", args[2]};
                view.setValueExchanged(aux);
            }
        }
    }
    
    public static void update(){
        input();
        view.setOriginCurrencies(currencies.getCurrencies());
    }
    
}
