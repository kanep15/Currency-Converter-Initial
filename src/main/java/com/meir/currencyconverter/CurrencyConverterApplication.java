package com.meir.currencyconverter;

import com.meir.currencyconverter.model.CurrencyPair;
import com.meir.currencyconverter.utility.RateFileReader;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class CurrencyConverterApplication {
    //eg uk to us £10
    // Argument 1 contains the base pair, Argument 2 contains the rate pair and
    // Argument three contains the quantity to exchange

    public static void main(String[] args) {
        //if (args.length < 3) {
            //throw new IllegalArgumentException("There must be three arguments passed to this application");
        //}
        
        System.out.println(run(args));
    }

    public static BigDecimal run(String[] args){
        System.out.println("test");
         RateFileReader reader = new RateFileReader("rate-pairs.txt");

         List<CurrencyPair> rates = reader.readFile();
         String origCurr = args[0];
         String newCurr = args[2];



         BigDecimal ammount = BigDecimal.valueOf(Integer.parseInt(args[1]));

        BigDecimal coverter = BigDecimal.valueOf(0);

        for (CurrencyPair rate : rates) {
            if (Objects.equals(origCurr, rate.getBaseCurrency()) && Objects.equals(newCurr, rate.getRateCurrency())) {
                coverter = rate.convertAmountOfBaseCurrency(ammount);
            }
        }

        return coverter.setScale(0, RoundingMode.DOWN);


        // Find the correct pair from the list or throw an error

        // Perform the calculation and return the value

        //throw new  RuntimeException("Not yet implemented");
    }
}
