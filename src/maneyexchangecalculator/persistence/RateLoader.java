/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maneyexchangecalculator.persistence;

import moneyexchangecalculator.model.Currency;
import moneyexchangecalculator.model.Rate;


/**
 *
 * @author José Roberto Jiménez
 */
public interface RateLoader{

    
    public Rate load(Currency from, Currency to);
    
    
}
