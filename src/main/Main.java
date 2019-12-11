package main;

import java.io.IOException;

import model.Basket;
import model.Receipt;

/**
 *
 * @author mcorekci
 */
public class Main {

    public static void main(String[] args) throws IOException {
/*
 *  We could have get the path from arguments which needs to be passed 
 *  as a parameter when executing assuming that it's the first parameter
 */
//      String path = args[0];

//      String path=".\\files\\basket1.txt";
//      String path=".\\files\\basket2.txt";
//      String path=".\\files\\basket3.txt";
    	String path=".\\files\\basket4.txt";
        Basket basket=new Basket(path);
        Receipt receipt=new Receipt(basket);
        receipt.printReceipt();
    }
    
    

    
  
    
    
}
