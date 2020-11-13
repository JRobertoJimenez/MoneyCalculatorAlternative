/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maneyexchangecalculator.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import moneyexchangecalculator.model.Rate;
import moneyexchangecalculator.model.RateList;

/**
 *
 * @author José Roberto Jiménez
 */
public class RateListLoaderCSV implements RateListLoader{
    private final String path;

    public RateListLoaderCSV(String path) {
        this.path = path;
    }

    @Override
    public RateList load() {
        RateList rateList= new RateList();
        try {
            BufferedReader br= new BufferedReader(new FileReader(path));
            String [] data;
            String line=br.readLine();
            while(line !=null){
                data=line.split(";");
                rateList.putRate(new Rate(Double.parseDouble(data[0]),data[1], data[2]));
                line=br.readLine();
            }
        } catch (Exception e) {
            System.out.println("Se ha producido una excepcion: "+e.getMessage());
        }
        return rateList;
    }
    
    
    
    
    
}
