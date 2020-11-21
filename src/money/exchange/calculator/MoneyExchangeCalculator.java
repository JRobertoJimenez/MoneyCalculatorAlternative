
package money.exchange.calculator;

import maneyexchangecalculator.persistence.CurrencyListLoaderCSV;
import maneyexchangecalculator.persistence.RateLoader;
import maneyexchangecalculator.persistence.RateLoaderWeb;
import moneyexchangecalculator.model.CurrencyList;
import moneyexchangecalculator.model.Money;
import moneyexchangecalculator.model.Rate;
import moneyexchangecalculator.view.View;


public class MoneyExchangeCalculator {

   private static final String fileNameCurrencies="Currencies.txt";
   private static final String urlRates="http://api.fixer.io/latest?base=@&symbols=@";
   private static CurrencyList currencies;
   private static RateLoader rates;
   private static View view;
    public static void main(String[] args) {
        input();
        view();
        
        
      
    } 
    
    private static void input(){
        currencies=new CurrencyListLoaderCSV(fileNameCurrencies).load();
        
        rates=new RateLoaderWeb(urlRates);
        
    }
    
    private static void view(){
        view = new View();
        view.setCurrencies(currencies.getCurrencies());
        view.setVisible(true);
    }
    
    public static void process(String args[]){
        Money money =
                new Money(currencies.getCurrency(args[0]),
                        Double.parseDouble(args[2]));
        Rate rate=
                rates.load(money.getCurrency(),
                        currencies.getCurrency(args[1]) );
        

        String [] aux={rate.getRate()+"", rate.getDestinyCurrency()};
        view.setValueExchanged(aux);
                    
    }
    
    public static void update(){
        input();
        view.setCurrencies(currencies.getCurrencies());
    }
    
}
