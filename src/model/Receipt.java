package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import service.ExemptData;

/**
 *
 * @author mcorekci
 */
public class Receipt {
    private List<Good> products;
    private double totalPrice;
    private double totalSalesTaxes;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    
    public Receipt(Basket basket) {
        this.products = new ArrayList<Good>();
        if(basket != null){
            this.validateBasket(basket);            
        }
    }
    /*
     * this method gets the basket as a parameter and turn them into goods 
     */
    private void validateBasket(Basket basket) {
        for(String s : basket.getGoods()){
            Good g=this.stringToGood(s);
            this.products.add(g);
        }
        this.calculateTotalPrice();
        this.calculateTotalSalesTaxes();
    }
    /*
     * this method splits the lines to good objects
     */
    private Good stringToGood(String strGood){
        int piece = Integer.valueOf((strGood.split(" at ")[0]).substring(0,strGood.split(" at ")[0].indexOf(' ')));
        String name=(strGood.split(" at ")[0]).substring(strGood.split(" at ")[0].indexOf(' '));
        Double value=piece*Double.valueOf(strGood.split(" at ")[1]);
        
        boolean isExempt=ExemptData.isInExemptList(name);
        boolean isImported=name.toLowerCase().contains("imported");
        
        Good g = new Good(piece,name,value,isExempt,isImported);
        return g;
    }
    private void calculateTotalSalesTaxes(){
        this.totalSalesTaxes=0;
        for(Good g : this.products){
            this.totalSalesTaxes+=g.getSalesTax();
        }
    }
    private void calculateTotalPrice(){
        this.totalPrice=0;
        for(Good g : this.products){
            this.totalPrice+=g.getValue()+g.getSalesTax();
        }
    }
    public void printReceipt(){
        if(!this.products.isEmpty()){
            this.products.forEach((g) -> {
                System.out.println(g);
            });
            System.out.println("Sales Taxes: "+ df2.format(this.totalSalesTaxes));
            System.out.println("Total: "+ df2.format(this.totalPrice));            
        }else{
            System.out.println("Basket is empty.");   
        }
    }
}