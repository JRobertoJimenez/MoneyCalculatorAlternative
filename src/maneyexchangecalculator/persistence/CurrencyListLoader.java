/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maneyexchangecalculator.persistence;

import moneyexchangecalculator.model.CurrencyList;

/**
 *
 * @author José Roberto Jiménez
 */
public interface CurrencyListLoader{

    public CurrencyList load();
    
    
}
