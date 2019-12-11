package model;

import java.text.DecimalFormat;

/**
 *
 * @author mcorekci
 */
public class Good {
    
    public final static double BASIC_SALES_TAX=10;
    public final static double IMPORT_DUTY_SALES_TAX=5;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    private int piece;
    private String name;
    private double value;
    private boolean isExempt;
    private boolean isImported;
    private double salesTax;

    public Good(int piece, String name, double value, boolean isExempt, boolean isImported) {
        this.piece = piece;
        this.name = name;
        this.value = value;
        this.isExempt = isExempt;
        this.isImported = isImported;
        this.calculateSalesTax();
    }
    
    private void calculateSalesTax() {
        this.salesTax=0;
        if(!this.isExempt){
            this.salesTax+=this.value*(BASIC_SALES_TAX/100);
        }
        if(this.isImported){            
            this.salesTax+=this.value*(IMPORT_DUTY_SALES_TAX/100);
        }
        this.salesTax=Math.ceil(this.salesTax*20)/20.0;            
    }

    @Override
    public String toString() {
    	double price=this.value+this.salesTax;
        return this.piece + this.name + " : " + ( df2.format(price));
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isIsExempt() {
        return isExempt;
    }

    public void setIsExempt(boolean isExempt) {
        this.isExempt = isExempt;
    }

    public boolean isIsImported() {
        return isImported;
    }

    public void setIsImported(boolean isImported) {
        this.isImported = isImported;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }
}
