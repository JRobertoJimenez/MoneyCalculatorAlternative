/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maneyexchangecalculator.persistence;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import moneyexchangecalculator.model.Currency;
import moneyexchangecalculator.model.Rate;

/**
 *
 * @author José Roberto Jiménez
 */
public class RateLoaderWeb implements RateLoader{
    private final String url;

    public RateLoaderWeb(String url) {
        this.url=url;
    }

    @Override
    public Rate load(Currency from, Currency to) {
        try {
            return new Rate(from, to, read(from.getID(),to.getID()));
            
        } catch (MalformedURLException e) {
            System.out.println("Se ha producido una excepcion: "+e.getMessage());
            return null;
        } catch (IOException e) {
            System.out.println("Se ha producido una excepcion en el acceso web: "+e.getMessage());
            return null;
        }
    }
    
    
    private double read(String from, String to) throws MalformedURLException, IOException{
        String [] lines =url.split("@");
        String line =read(new URL(lines[0]+from+lines[1]+to));
        return Double.parseDouble(
                line.substring(line.indexOf(to)+5,line.indexOf("}")));
    }

    private String read(URL url) throws IOException {
        InputStream is = url.openStream();
        byte[] buffer= new byte[1024];
        int len;
        String aux="";
        while ((len = is.read(buffer)) > 0) {
            aux+=new String (buffer,0,len);
        }
        System.out.println(aux);
        return aux;
    }
    
}
